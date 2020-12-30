package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.entity.tankc;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.TankcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tankcPrint/")
@RestController
@Slf4j
public class TankcController implements ControllerTemplate<tankc> {
    @Autowired
    private TankcService tankcService;
//   @PostMapping("getTankc")
//    public Response getTankc(@RequestBody Request<tankc> tankc){
//       return  tankcService.getTankc(tankc);
//   }
//   @PostMapping("addTankc")
//    public Response addTankc(@RequestBody Request<tankc> tankc){
//       return  tankcService.addTankc(tankc.getData());
//   }
//
//   @PostMapping("updateTankc")
//    public Response updateTankc(@RequestBody Request<tankc> tankc){
//       return  tankcService.updateTankc(tankc.getData());
//   }

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<tankc> request) {
        log.info("addTankc Response报文:{}", JSON.toJSONString(request));
        Response response = tankcService.addTankc(request.getData());
        log.info("addTankc Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("dateleTankc Response报文:{}", JSON.toJSONString(request));
        List<Integer> list = JSON.parseArray(JSON.toJSONString(request.getData()), Integer.class);
        Response response = tankcService.dateleTankc(list);
        log.info("deteleTankc Response报文:{}", JSON.toJSONString(request));
        return response;
    }

    @Override
    public Response updatePut(Request<tankc> request) {
        log.info("updateTankc Response报文:{}", JSON.toJSONString(request));
        Response response = tankcService.updateTankc(request.getData());
        log.info("updateTankc Response报文:{}", JSON.toJSONString(response));
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
    public Response postListInit(Request<tankc> request) {
        log.info("getTankc Response报文:{}", JSON.toJSONString(request));
        Response response = tankcService.getTankc(request);
        log.info("getTankc Response报文:{}", JSON.toJSONString(response));
        return response;
    }
}
