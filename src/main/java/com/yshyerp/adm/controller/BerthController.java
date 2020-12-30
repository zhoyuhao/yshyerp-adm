package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.entity.Berth;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.BerthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: yinsongjia
 * @Data: 2020/11/12
 * @Description:
 */
@RequestMapping("berth/")
@RestController
@Slf4j
public class BerthController implements ControllerTemplate<Berth> {
    @Autowired
    private BerthService berthService;

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<Berth> request) {
        log.info("addBerth Response报文:{}", JSON.toJSONString(request));
        Response response = berthService.addBerth(request);
        log.info("addBerth Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("daleteBerth报文:{}", JSON.toJSONString(request));
        List<Integer> list = JSON.parseArray(JSON.toJSONString(request.getData()), Integer.class);
        Response response = berthService.daleteBerth(list);
        log.info("daleteBerth报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response updatePut(Request<Berth> request) {
        log.info("updateBerth Response报文:{}", JSON.toJSONString(request));
        Response response = berthService.updateBerth(request);
        log.info("updateBerth Response报文:{}", JSON.toJSONString(response));
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
    public Response postListInit(Request<Berth> request) {
        log.info("getBerth报文:{}", JSON.toJSONString(request));
        Response response = berthService.getBerth(request);
        log.info("getBerth报文:{}", JSON.toJSONString(response));
        return response;
    }
}
