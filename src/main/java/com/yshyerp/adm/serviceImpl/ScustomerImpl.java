package com.yshyerp.adm.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.entity.ScustomerEntity;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.mapper.ScustomerMapper;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.response.dto.DropDownBoxDTO;
import com.yshyerp.adm.service.IScustomerService;
import com.yshyerp.adm.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-03
 * @Description: 小客户 service
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.READ_COMMITTED,readOnly = true)
public class ScustomerImpl implements IScustomerService {


    @Autowired
    private ScustomerMapper scustomerMapper;

    /**
     * 根据 customer、scustomer 删除小客户数据
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public Response deleteByCustomer(Request request) {
        Response response = null;
        try {
            List<String> list = JSON.parseArray(JSON.toJSONString(request.getData()), String.class);
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), scustomerMapper.deleteByCustomer(list));
        }catch (Exception e){
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.error("deleteByCustomer接口操作失败：{}",e.getMessage());
        }
        return response;
    }

    /**
     * 根据  customer and sCustomer 查看指定数据
     * @param request
     * @return
     */
    @Override
    public Response queryCustomer(Request<ScustomerEntity> request) {
        Response response = null;
        try {
            //执行查询SQL操作
            QueryWrapper<ScustomerEntity> qw = Wrappers.query();
            qw.apply(" ISNULL(d,' ')=' '");
            qw.eq("s_customer",request.getData().getsCustomer());
            qw.eq("customer",request.getData().getCustomer());
            List<ScustomerEntity> list = scustomerMapper.queryCustomerAll(request.getData());
            if(list!=null && list.size()!=0){
                response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(),list.get(0));
            }else{
                response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(),null);
            }

        }catch (Exception e){
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryCustomer接口操作失败：{}",e.getMessage());
        }
        return response;
    }

    /**
     * 查看所有小客户数据  支持分页 、条件（customer、sCustomer、cname）
     * @param request
     * @return
     */
    @Override
    public Response queryCustomerAll(Request<ScustomerEntity> request) {
        Response response = null;
        //判断是否分页 否则查看所有
        if(!StringUtils.isEmpty(request) && !StringUtils.isEmpty(request.getPageNum()) && !StringUtils.isEmpty(request.getPageSize()))
            PageHelper.startPage(request.getPageNum(), request.getPageSize());
        try {
            //执行查询SQL操作
            QueryWrapper<ScustomerEntity> qw = Wrappers.query();
            qw.apply(" ISNULL(d,' ')=' '");
            if (!StringUtils.isEmpty(request) && !StringUtils.isEmpty(request.getData())){
                if (!StringUtils.isEmpty(request.getData().getCustomer())) qw.eq("customer",request.getData().getCustomer());
                if (!StringUtils.isEmpty(request.getData().getCname())) qw.eq("cname",request.getData().getCname());
                if (!StringUtils.isEmpty(request.getData().getsCustomer())) qw.eq("s_customer",request.getData().getsCustomer());
            }
            List<ScustomerEntity> listData = scustomerMapper.queryCustomerAll(request.getData());
            for (int i = 0; i < listData.size(); i++) {
                listData.get(i).setKey(i+1);
            }
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(),new PageInfo(listData));
        }catch (Exception e){
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryCustomerAll接口操作失败：{}",e.getMessage());
        }
        return response;
    }

    /**
     * 根据 customer、sCustomer 修改小客户数据
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public Response updateCustomer(Request<ScustomerEntity> request) {
        Response response = null;
        try {
            QueryWrapper<ScustomerEntity> qw = Wrappers.query();
          //  qw.apply(" ISNULL(d,' ')=' '");
//            qw.eq("s_customer",request.getData().getsCustomer());
//            qw.eq("customer",request.getData().getCustomer());
            response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(),scustomerMapper.updateById(request.getData()));
        }catch (Exception e){
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
            log.error("updateCustomer接口操作失败：{}",e.getMessage());
        }
        return response;
    }

    /**
     * 添加小客户数据
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public Response insertCustomer(Request<ScustomerEntity> request) {
        Response response = null;
        try {
            //执行查询SQL操作
            request.getData().setKey(null);
            List<ScustomerEntity> list = scustomerMapper.queryCustomerAll(request.getData());
            ScustomerEntity scustomerEntity = null;
            if(list!=null && list.size()!=0){
                scustomerEntity =list.get(0);
            }
            if(!StringUtils.isEmpty(scustomerEntity) && StringUtils.isEmpty(scustomerEntity.getD())){
                response = Response.error("输入的该大客户的小客户已存在,请重新输入！");
            }else{
                response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(),scustomerMapper.insert(request.getData()));
            }

        }catch (Exception e){
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
            log.error("insertCustomer接口操作失败：{}",e.getMessage());
        }
        return response;
    }

    /**
     * 查询大客户
     * @return
     */
    @Override
    public Response getDropDownInit() {
        List<DropDownBoxDTO> list = scustomerMapper.queryCustomer();
        JSONObject jsonObj = new JSONObject();
            jsonObj.put("customerList", DropDownBoxUtils.toDropDownBoxJSON(list));
        return Response.success("查询成功",jsonObj);
    }
}
