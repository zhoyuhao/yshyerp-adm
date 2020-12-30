package com.yshyerp.adm.serviceImpl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.mapper.OtherDictMapper;
import com.yshyerp.adm.entity.OtherDict;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.OtherDictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @Data: 2020/11/5
 * @Description: ShipcodeImpl
 */

@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class OtherDictImpl implements OtherDictService {

    @Autowired
    private OtherDictMapper otherDictMapper;

    @Override
    public Response getOtherDict(Request<OtherDict> req) {
        Response response = null;
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize())) {
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        }
        QueryWrapper<OtherDict> qw = Wrappers.query();
        qw.apply("ISNULL(d,' ')=' '");
        if (!StringUtils.isEmpty(req.getData().geteName())) qw.eq("e_name", req.getData().geteName());
        if (!StringUtils.isEmpty(req.getData().getcName())) qw.eq("c_name", req.getData().getcName());
        //List<OtherDict>ListData=otherDictMapper.getOtherDict(req.getData().getCode(),req.getData().getcName());
        return Response.success("查询成功", new PageInfo<>(otherDictMapper.getOtherDict(req.getData())));
    }

    @Override
    public Response addOtherDict(OtherDict otherDict) {
        otherDict.setKey(null);
        otherDict.setCode("A6");
        return Response.success("添加成功", otherDictMapper.insert(otherDict));
    }

    @Override
    public Response updateOtherDict(OtherDict otherDict) {
        otherDict.setKey(null);
        return Response.success("修改成功", otherDictMapper.updateById(otherDict));
    }

    /**
     * 根据List修多修改状态
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response daleteOtherDict(List<Integer> list) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), otherDictMapper.daleteOtherDict(list));
        } catch (Exception e) {
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.error("daleteOtherDict接口操作失败：{}", e.getMessage());
        }
        return response;
    }
}
