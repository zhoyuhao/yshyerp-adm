package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.BukrsprctrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/13
 * @Description:
 */
@RequestMapping("Bukrsprctr/")
@RestController
@Slf4j
public class BukrsprctrController implements ControllerTemplate {
    @Autowired
    private BukrsprctrService bukrsprctrService;

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request request) {
        log.info("addBukrsprctr报文:{}", JSON.toJSONString(request));
        Response response = bukrsprctrService.addBukrsprctr(request);
        log.info("addBukrsprctr报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("daleteBukrsprctr报文:{}", JSON.toJSONString(request));
        List<Integer> list = JSON.parseArray(JSON.toJSONString(request.getData()), Integer.class);
        Response response = bukrsprctrService.daleteBukrsprctr(list);
        log.info("daleteBukrsprctr报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response updatePut(Request request) {
        log.info("updateBukrsprctr报文:{}", JSON.toJSONString(request));
        Response response = bukrsprctrService.updateBukrsprctr(request);
        log.info("updateBukrsprctr报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getDropDownInit() {
        return null;
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @Override
    public Response postListInit(Request request) {
        log.info("getBukrsprctr报文:{}", JSON.toJSONString(request));
        Response response = bukrsprctrService.getBukrsprctr(request);
        log.info("getBukrsprctr报文:{}", JSON.toJSONString(response));
        return response;
    }
}
