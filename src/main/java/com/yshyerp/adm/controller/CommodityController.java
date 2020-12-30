package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.entity.CommodityEntity;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.response.dto.*;
import com.yshyerp.adm.service.ICommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: zhoyuhao
 * @Data: 2020-10-30
 * @Description: 货品controller
 */
@Slf4j
@RequestMapping("commodity/")
@RestController
public class CommodityController implements ControllerTemplate<CommodityEntity> {

    @Autowired
    private ICommodityService iCommodityServ;


    @Override
    public Response getDetail(String request) {
        log.info("queryCommodityOne Request报文：{}", JSON.toJSONString(request));
        Response response = iCommodityServ.queryCommodityOne(request);
        log.info("queryCommodityOne Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getUpdateInit(String request) {
        log.info("queryCommodityOne Request报文：{}", JSON.toJSONString(request));
        CommodityRespDTO respDto = new CommodityRespDTO();
        Response response = iCommodityServ.queryCommodityOne(request);
        respDto = JSON.parseObject(JSON.toJSONString(response.getData()),CommodityRespDTO.class);
        if(!StringUtils.isEmpty(respDto)){
            respDto.setDropDownBox(JSON.parseArray(JSON.toJSONString( iCommodityServ.queryCommodityType().getData()), DropDownBoxDTO.class));
            response.setData(respDto);
        }
        log.info("queryCommodityOne Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response addPost(Request<CommodityEntity> request) {
        log.info("insertCommodity Request报文：{}", JSON.toJSONString(request));
        Response response = null;
        if(!StringUtils.isEmpty(request)){
            if(!StringUtils.isEmpty(request.getData())){
                CommodityEntity commodityEntity = JSON.parseObject(JSON.toJSONString(request.getData()),CommodityEntity.class);
                if(StringUtils.isEmpty(commodityEntity.getCommodity())) response = Response.error("货品简称不能为空!");
                if(StringUtils.isEmpty(commodityEntity.getDensity())) response = Response.error("货品密度必须填写准确，否则影响正确出货!");
            }
            response = iCommodityServ.insertCommodity(request);
        }
        log.info("insertCommodity Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("updateByCommodity Request报文：{}", request);
        Response response = null;
        if(!StringUtils.isEmpty(request.getData())){//参数效验
            response = iCommodityServ.updateByCommodity(request);
        }else{
            response = Response.error("删除失败！参数commodity=null");
        }
        log.info("updateByCommodity Response报文：{}", response);
        return response;
    }

    @Override
    public Response updatePut(Request<CommodityEntity> request) {
        log.info("updateById Request报文：{}", JSON.toJSONString(request));
        Response response = iCommodityServ.updateById(request);
        log.info("updateById Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getDropDownInit() {
        Response response = iCommodityServ.queryCommodityType();
        log.info("queryCommodityOne Response报文：{}", JSON.toJSONString(response));
        return Response.success("查询成功",response.getData());
    }

    @Override
    public Response getAddDropDownInit() {
        Response response = iCommodityServ.queryCommodityType();
        log.info("queryCommodityOne Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response postListInit(Request<CommodityEntity> request) {
        log.info("queryCommodityAll Request报文：{}", JSON.toJSONString(request));
        Response response = iCommodityServ.queryCommodityAll(request);
        log.info("queryCommodityAll Response报文：{}", JSON.toJSONString(response));
        return response;
    }

}
