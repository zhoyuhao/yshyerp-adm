package com.yshyerp.adm.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.entity.Berth;
import com.yshyerp.adm.entity.Bukrsprctr;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.mapper.BukrsprctrMapper;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.BukrsprctrService;
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
 * @Data: 2020/11/13
 * @Description:
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class BukrsprctrImpl implements BukrsprctrService {
    @Autowired
    private BukrsprctrMapper bukrsprctrMapper;

    @Override
    public Response getBukrsprctr(Request<Bukrsprctr> req) {
        Response response = null;
        //判断是否分页 否则查看所有
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize()))
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        try {
            //执行查询sql操作
            QueryWrapper<Bukrsprctr> qw = Wrappers.query();
            Bukrsprctr bukrsprctr = JSON.parseObject(JSON.toJSONString(req.getData()),Bukrsprctr.class);
            qw.apply(" ISNULL(d,' ')=' '");
            if (!StringUtils.isEmpty(bukrsprctr.getBukrsNo())) qw.eq("bukrs_no", bukrsprctr.getBukrsNo());
            if (!StringUtils.isEmpty(bukrsprctr.getBukrsname())) qw.eq("bukrsname", bukrsprctr.getBukrsname());
            if (!StringUtils.isEmpty(bukrsprctr.getPrctrNo())) qw.eq("prctr_no", bukrsprctr.getPrctrNo());
            if (!StringUtils.isEmpty(bukrsprctr.getPrctrname())) qw.eq("prctrname", bukrsprctr.getPrctrname());


            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo<>(bukrsprctrMapper.selectList(qw)));
        } catch (Exception e) {
            log.info(e.getMessage());
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response addBukrsprctr(Request<Bukrsprctr> bukrsprctr) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(), bukrsprctrMapper.insert(bukrsprctr.getData()));
        } catch (Exception e) {
            log.info("addBukrsprctr接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateBukrsprctr(Request<Bukrsprctr> bukrsprctr) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(), bukrsprctrMapper.updateById(bukrsprctr.getData()));
        } catch (Exception e) {
            log.info("updateBukrsprctrj接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
        }
        return response;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response daleteBukrsprctr(List<Integer> id) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), bukrsprctrMapper.daleteBukrsprctr(id));
        } catch (Exception e) {
            log.info("daleteBukrsprctr接口操作失败", e.getMessage());
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
        }
        return response;
    }
}
