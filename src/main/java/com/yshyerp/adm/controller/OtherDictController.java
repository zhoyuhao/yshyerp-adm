package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.entity.OtherDict;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.OtherDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("other/")
@RestController
@Slf4j
public class OtherDictController implements ControllerTemplate<OtherDict> {

    @Autowired
    private OtherDictService otherDictService;

//    @PostMapping ("OtherDictController")
//    public Response getOtherDict(@RequestBody Request<OtherDict> otherDict){
//     return  otherDictService.getOtherDict(otherDict);
//  }

//  @PostMapping("addOtherDict")
//    public Response addByOtherDict(@RequestBody  Request<OtherDict> otherDict){
//       return  otherDictService.addOtherDict(otherDict.getData());
//  }
//  @PostMapping("updateOtheDict")
//  public Response updateOtheDict(@RequestBody  Request<OtherDict> otherDict){
//      return    otherDictService.updateOtherDict(otherDict.getData());
//  }


//  @GetMapping("deleteOtherDict/{code}")
//    public Response deleteCode(@PathVariable String code){
//       return otherDictService.daleteOtherDict(code);
//  }

//    @DeleteMapping("delete/{code}")
//    public Response deleteByCode(@RequestBody Request request) {
//        log.info("daleteOtherDict Response报文:{}",JSON.toJSONString(request));
//        Response response=otherDictService.daleteOtherDict((List<String>) request.getData());
//        log.info("daleteOtherDict Response报文:{}",JSON.toJSONString(response));
//        return  response;
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
    public Response addPost(Request<OtherDict> request) {

        log.info("addOtherDict Response报文:{}", JSON.toJSONString(request));
        Response response = otherDictService.addOtherDict(request.getData());
        log.info("addOtherDict Response报文:{}", JSON.toJSONString(response));
        return response;

    }

    @Override
    public Response delete(Request request) {
        log.info("daleteOtherDict Response报文:{}", JSON.toJSONString(request));
        List<Integer> list = JSON.parseArray(JSON.toJSONString(request.getData()), Integer.class);
        Response response = otherDictService.daleteOtherDict(list);
        log.info("daleteOtherDict Response报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response updatePut(Request<OtherDict> request) {
        log.info("updateOtherDict Response报文:{}", JSON.toJSONString(request));
        Response response = otherDictService.updateOtherDict(request.getData());
        log.info("updateOtherDict Response报文:{}", JSON.toJSONString(response));
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
    public Response postListInit(Request<OtherDict> request) {
        log.info("getOtherDict Response报文:{}", JSON.toJSONString(request));
        Response response = otherDictService.getOtherDict(request);
        return response;
    }
}
