package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.entity.SerVice;
import com.yshyerp.adm.entity.Vessel;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.VesselService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/3
 * @Description: VesselController
 */
@RequestMapping("vessel/")
@RestController
@Slf4j
public class VesselController implements ControllerTemplate<Vessel> {
    @Autowired
    private VesselService vesselService;

    //    @PostMapping("getVessel")
//    public Response getVessel(@RequestBody Request<Vessel> vessel){
//        return vesselService.getVessel(vessel);
//    }
//    @PostMapping("addVessel")
//    public  Response addVessel(@RequestBody Request<Vessel> vessel){
//        return vesselService.addVessel(vessel.getData());
//    }
//    @PostMapping("updateVessel")
//    public Response updateVessel(@RequestBody Request<Vessel>vessel){
//        return vesselService.update(vessel.getData());
//    }

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<Vessel> request) {
        log.info("addVessel Response报文:{}", JSON.toJSONString(request));
        Response response = vesselService.addVessel(request.getData());
        log.info("addVessel Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        List<String> list = JSON.parseArray(JSON.toJSONString(request.getData()),String.class);
        return vesselService.deleteVessel(list);
    }

    @Override
    public Response updatePut(Request<Vessel> request) {
        log.info("update Response报文:{}", JSON.toJSONString(request));
        Response response = vesselService.update(request.getData());
        log.info("update Response报文:{}", JSON.toJSONString(response));
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
    public Response postListInit(Request<Vessel> request) {
        log.info("getVessel Request报文:{}", JSON.toJSONString(request));
        Response response = vesselService.getVessel(request);
        log.info("getVessel Request报文:{}", JSON.toJSONString(response));
        return response;

    }
}
