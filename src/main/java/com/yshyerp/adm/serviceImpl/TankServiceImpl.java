package com.yshyerp.adm.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.entity.ScustomerEntity;
import com.yshyerp.adm.entity.TankEntity;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.mapper.TankMapper;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.ITankService;
import com.yshyerp.adm.utils.CreateLetterUtils;
import com.yshyerp.adm.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-02
 * @Description: 临时罐号serverImpl
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class TankServiceImpl implements ITankService {

    @Autowired
    private TankMapper tankMapper;

    /**
     * 根据tank查看所有临时罐号
     *
     * @param request
     * @return
     */
    @Override
    public Response queryTankByTankAll(Request<TankEntity> request) {
        Response response = null;
        if (!StringUtils.isEmpty(request) && !StringUtils.isEmpty(request.getPageNum()) && !StringUtils.isEmpty(request.getPageSize()))
            PageHelper.startPage(request.getPageNum(), request.getPageSize());
        try {
            //执行查询SQL操作
            List<TankEntity> listData = tankMapper.queryTankByTankAll(request.getData());
            for (int i = 0; i < listData.size(); i++) {
                listData.get(i).setKey(i + 1);
            }
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo(listData));
        } catch (NullPointerException e) {
            response = Response.error("queryTankByTankAll接口内部异常！");
            log.error("queryTankByTankAll接口操作失败：{}", "switch(val) val=null");
        } catch (Exception e) {
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryTankByTankAll接口操作失败：{}", e.getMessage());
        }
        return response;
    }

    /**
     * 查看所有下拉集合
     *
     * @return
     */
    @Override
    public Response queryDropDownAll() {
        Response response = null;
        try {
            JSONObject json = new JSONObject();
            json.put("commodityList", DropDownBoxUtils.toDropDownBoxJSON(tankMapper.commodityDropDown()));
            json.put("customerList", DropDownBoxUtils.toDropDownBoxJSON(tankMapper.customerDropDown()));
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), json);
        } catch (Exception e) {
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryDropDownAll接口操作失败：{}", e.getMessage());
        }
        return response;
    }

    /**
     * 根据tank修改临时罐号
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateTankeByTank(Request<TankEntity> request) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), tankMapper.updateById(request.getData()));
        } catch (Exception e) {
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
            log.error("updateTankeByTank接口操作失败：{}", e.getMessage());
        }
        return response;
    }

    /**
     * 根据tank删除临时罐号
     *
     * @param tank
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response deleteTankeByTank(List<String> tank) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), tankMapper.deleteTankeByTank(tank));
        } catch (Exception e) {
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.error("deleteTankeByTank接口操作失败：{}", e.getMessage());
        }
        return response;
    }

    /**
     * 添加临时罐号数据
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response inserTank(Request<TankEntity> request) {
        Response response = null;
        try {
            //执行sql
            QueryWrapper<TankEntity> qw = Wrappers.query();
            qw.apply(" ISNULL(d,' ')=' '");
            qw.apply(" LEFT(tank,1)='I'");
            qw.eq("t_customer", request.getData().gettCustomer());
            qw.eq("commodity", request.getData().getCommodity());
            TankEntity tank = tankMapper.selectOne(qw);
            if (StringUtils.isEmpty(tank)) {//验证是否已经存在此临时罐号
                request.getData().setTank(this.createTanke());//生成临时罐号
                request.getData().setCode(CreateLetterUtils.createLetter(tankMapper.queryTankCodeDescOne()));  //生成随机字母（两位大写）
                request.getData().setcCustomer(request.getData().gettCustomer());
                response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(), tankMapper.addTank(request.getData()));
            } else {
                response = Response.error("添加失败！该客户及货品的临时罐已经存在");
            }
        } catch (IndexOutOfBoundsException e) {
            response = Response.error("临时罐code已满! 请清除不必要的临时罐号");
            log.error("inserTank接口操作失败：{}", e.getMessage());
        } catch (Exception e) {
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
            log.error("inserTank接口操作失败：{}", e.getMessage());
        }
        return response;
    }


    /**
     * 生成临时罐号
     * @return
     */
    private String createTanke() {
        //I-0065
        String str = tankMapper.queryTankDescOne();
        String str2 = str.substring(0, str.indexOf("-") + 1);
        str = str.substring(str.indexOf("-") + 1).replaceAll("\\s", "");
        str = Integer.parseInt(str) + 1 + "";
        if (str.length() == 1) {
            str = "000" + str;
        } else if (str.length() == 2) {
            str = "00" + str;
        } else if (str.length() == 3) {
            str = "0" + str;
        }
        str = str2 + str;
        System.out.println(str);
        return str;
    }


    /**
     * 查看指定临时罐号
     *
     * @param request
     * @return
     */
    @Override
    public Response queryByTank(String request) {
        Response response = null;
        try {
            //执行查询SQL操作
            QueryWrapper<TankEntity> qw = Wrappers.query();
            qw.apply(" ISNULL(d,' ')=' '");
            qw.eq("tank", request);
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), tankMapper.selectOne(qw));
        } catch (Exception e) {
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryByTank接口操作失败：{}", e.getMessage());
        }
        return response;
    }
}
