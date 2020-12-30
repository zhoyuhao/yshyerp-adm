package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.entity.ScustomerEntity;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.response.dto.DropDownBoxDTO;
import com.yshyerp.adm.response.dto.ScustomerRespDTO;
import com.yshyerp.adm.service.IScustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: zhoyuhao
 * @Data: 2020-11-03
 * @Description: 小客户 controller
 */
@RequestMapping("scustomer/")
@RestController
@Slf4j
public class ScustomerController implements ControllerTemplate<ScustomerEntity> {

    @Autowired
    private IScustomerService iScustomerService;


    @Override
    public Response getDetail(String request) {
         log.info("getUpCustomerAndSCustomer报文：{}", request);
        Response response = this.selectByCustomerAndSCustomerOne(request);
        log.info("queryCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

//    @GetMapping("getDetail/{customer}/{sCustomer}")
//    public Response getUpCustomerAndSCustomer(@PathVariable String customer, @PathVariable String sCustomer) {
//        log.info("getUpCustomerAndSCustomer报文：{},{}", customer, sCustomer);
//        Response response = this.selectByCustomerAndSCustomerOne(customer);
//        log.info("queryCustomer Response报文：{}", JSON.toJSONString(response));
//        return response;
//    }

    private Response selectByCustomerAndSCustomerOne(String customer){
        Request<ScustomerEntity> request = new Request();
        ScustomerEntity entity = new ScustomerEntity();
        entity.setId(Integer.parseInt(customer));
        request.setData(entity);
        return iScustomerService.queryCustomer(request);

    }
    @GetMapping("getUpdateInit/{customer}")
    public Response getUpCustomerAndSCustomerInits(@PathVariable String customer) {
        log.info("getUpCustomerAndSCustomerInits报文：{}", customer);
        Response response = this.selectByCustomerAndSCustomerOne(customer);
        ScustomerRespDTO scustomerRespDTO = JSON.parseObject(JSON.toJSONString(response.getData()),ScustomerRespDTO.class);
        scustomerRespDTO.setDropDownBox(JSON.parseArray(JSON.toJSONString(iScustomerService.getDropDownInit().getData()), DropDownBoxDTO.class));
        if (scustomerRespDTO.getDropDownBox()!=null){
            String strList = JSON.toJSONString(scustomerRespDTO.getDropDownBox()).replaceAll("\\s","");
            scustomerRespDTO.setDropDownBox(JSON.parseArray(strList, DropDownBoxDTO.class));
            response.setData(scustomerRespDTO);
        }

        log.info("queryCustomer Response报文：{}", JSON.toJSONString(scustomerRespDTO));
        return response;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<ScustomerEntity> request) {
        log.info("insertCustomer Request报文：{}", JSON.toJSONString(request));
        Response response = iScustomerService.insertCustomer(request);
        log.info("insertCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("deleteByCustomer Request报文：{}", JSON.toJSONString(request));
        //参数效验
        Response response = null;
        if (!StringUtils.isEmpty(request) && !StringUtils.isEmpty(request.getData())) {

            response = iScustomerService.deleteByCustomer(request);

        } else {
            response = Response.error("入参异常！null");
        }
        log.info("deleteByCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response updatePut(Request<ScustomerEntity> request) {
        log.info("updateCustomer Request报文：{}", JSON.toJSONString(request));
        //参数效验
        if (!StringUtils.isEmpty(request) && !StringUtils.isEmpty(request.getData())) {
            if (StringUtils.isEmpty(request.getData().getCustomer())) return Response.error("大客户不能为空！customer=null");
            if (StringUtils.isEmpty(request.getData().getsCustomer())) return Response.error("小客户不能为空！scustomer=null");
        }
        Response response = iScustomerService.updateCustomer(request);
        log.info("updateCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getDropDownInit() {

        Response response = iScustomerService.getDropDownInit();
        if (response.getData()!=null){
            String strList = JSON.toJSONString(response.getData()).replaceAll("\\s","");
            response.setData(JSON.parse(strList));
        }
        log.info("getDropDownInit Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getAddDropDownInit() {
        Response response = iScustomerService.getDropDownInit();
        log.info("getDropDownInit Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response postListInit(Request<ScustomerEntity> request) {
        log.info("queryCustomerAll Request报文：{}", JSON.toJSONString(request));
        Response response = iScustomerService.queryCustomerAll(request);
        String strList = JSON.toJSONString(response.getData()).replaceAll("\\s","");
        response.setData(JSON.parse(strList));
        log.info("queryCustomerAll Response报文：{}", JSON.toJSONString(response));
        return response;
    }
}
