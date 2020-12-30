package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.entity.CustomerEntity;
import com.yshyerp.adm.entity.vo.CustomerVO;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.response.dto.DropDownBoxDTO;
import com.yshyerp.adm.service.ICustomerService;
import com.yshyerp.adm.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-03
 * @Description: 公司 Controller
 */
@RequestMapping("customer/")
@RestController
@Slf4j
public class CustomerController implements ControllerTemplate<CustomerEntity> {

    @Autowired
    private ICustomerService iCustomerService;



    @Override
    public Response getDetail(String request) {
        log.info("queryByCustomer Request报文：{}", JSON.toJSONString(request));
        Response response = iCustomerService.queryByCustomer(request);
        log.info("queryByCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getUpdateInit(String request) {
        log.info("queryByCustomer Request报文：{}", JSON.toJSONString(request));
        Response response = iCustomerService.queryByCustomer(request);
        log.info("queryByCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response addPost(Request request) {
        log.info("insertCustomer Request报文：{}", JSON.toJSONString(request));
        //参数效验
        CustomerVO customerVO = JSON.parseObject(JSON.toJSONString(request.getData()),CustomerVO.class);
        if (StringUtils.isEmpty(customerVO) || StringUtils.isEmpty(customerVO.getCustomer()))
            return Response.error("公司简称不能为空");
        Request<CustomerVO> req = new Request();
        req.setData(customerVO);
        Response response = iCustomerService.insertCustomer(req);
        log.info("insertCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("deleteCustomer Request报文：{}", JSON.toJSONString(request));
        Response response = iCustomerService.deleteCustomer(request);
        log.info("deleteCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response updatePut(Request request) {
        log.info("updateCustomer Request报文：{}", JSON.toJSONString(request));
        Response response = iCustomerService.updateCustomer(request);
        log.info("updateCustomer Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getDropDownInit() {
        List<DropDownBoxDTO> list = new ArrayList();
        list.add(new DropDownBoxDTO("1","是","是"));
        list.add(new DropDownBoxDTO("0","否","否"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isNoList", DropDownBoxUtils.toDropDownBoxJSON(list));
        return Response.success(MessageEnum.SELECT_SUCCESS.getVal(),jsonObject);
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @Override
    public Response postListInit(Request<CustomerEntity> request) {
        log.info("queryCustomerAll Request报文：{}", JSON.toJSONString(request));
        Response response = iCustomerService.queryCustomerAll(request);
        String strList = JSON.toJSONString(response.getData()).replaceAll("\\s","");
        response.setData(JSON.parse(strList));
        log.info("queryCustomerAll Response报文：{}", JSON.toJSONString(response));
        return response;
    }
}
