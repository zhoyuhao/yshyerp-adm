package com.yshyerp.adm.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.entity.Berth;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.mapper.BerthMapper;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.BerthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/12
 * @Description:
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class BerthImpl implements BerthService {

    @Autowired
    private BerthMapper berthMapper;

    @Override
    public Response getBerth(Request<Berth> req) {
        Response response = null;
        //判断是否分页 否则查看所有
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        try {
            //执行查询sql操作
            QueryWrapper<Berth> qw = Wrappers.query();
            qw.apply(" ISNULL(d,' ')=' '");
            if (!StringUtils.isEmpty(req.getData().getBerthNo())) qw.eq("berth_no", req.getData().getBerthNo());
            if (!StringUtils.isEmpty(req.getData().getBerthname())) qw.eq("berthname", req.getData().getBerthname());

            //    List<Shipcode>ListData=shipcodeMapper.selectList(qw);
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo<>(berthMapper.selectList(qw)));
        } catch (Exception e) {
            log.info("getBerth接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response addBerth(Request<Berth> berth) {
        Response response = null;
        try {
            //执行sql操作
            response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(), berthMapper.insert(berth.getData()));
        } catch (Exception e) {
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
            log.info("addBerth接口操作失败", e.getMessage());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateBerth(Request<Berth> berth) {
        Response response = null;
        try {
            //执行sql操作
            response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), berthMapper.updateById(berth.getData()));
        } catch (Exception e) {
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
            log.info("updateBerth接口操作失败", e.getMessage());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response daleteBerth(List<Integer> id) {
        Response response = null;
        try {
            //执行sql操作
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), berthMapper.daleteBerth(id));
        } catch (Exception e) {
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.info("daleteBerth接口操作失败", e.getMessage());
        }
        return response;
    }
}
