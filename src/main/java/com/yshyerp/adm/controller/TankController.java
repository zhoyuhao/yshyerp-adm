package com.yshyerp.adm.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.controller.common.ControllerTemplate;
import com.yshyerp.adm.entity.TankEntity;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.ITankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-02
 * @Description: 临时罐号controller
 */
@Slf4j
@RequestMapping("tank/")
@RestController
public class TankController implements ControllerTemplate<TankEntity> {

    @Autowired
    private ITankService iTankService;


    /**
     * 查看最近一条数据（临时罐号）
     * @return
     */
    @PostMapping("/queryTankByTankOneDesc")
    public Response  queryTankByTankOneDesc(){
        Request<TankEntity> request = new Request<>();
        request.setPageNum(1);
        request.setPageSize(1);
        String  jsonStr = JSON.toJSONString(iTankService.queryTankByTankAll(request).getData());
        PageInfo pageInfo = JSON.parseObject(jsonStr,PageInfo.class);
        Response response = Response.success("查询成功",pageInfo.getList()==null?null:pageInfo.getList().get(0));
        return response;
    }

    @Override
    public Response getDetail(String request) {
        log.info("queryByTank Request报文：{}", JSON.toJSONString(request));
        Response response = iTankService.queryByTank(request);
        return response;
    }

    @Override
    public Response getUpdateInit(String request) {
        log.info("queryByTank Request报文：{}", JSON.toJSONString(request));
        Response response = iTankService.queryByTank(request);
        return response;
    }

    @Override
    public Response addPost(Request<TankEntity> request) {
        log.info("inserTank Request报文：{}", JSON.toJSONString(request));
        if(StringUtils.isEmpty(request.getData().gettCustomer()))
            return  Response.error("添加失败！缺少必填参数tCustomer=null");
        if(StringUtils.isEmpty(request.getData().getCommodity()))
            return  Response.error("添加失败！缺少必填参数tCommodity=null");
        Response response = iTankService.inserTank(request);
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("deleteTankeByTank Request报文：{}", JSON.toJSONString(request));
        Response response = iTankService.deleteTankeByTank(JSON.parseArray(JSON.toJSONString(request.getData()),String.class));
        return response;
    }


    public Response addInint(Request request) {
        log.info("addInint Request报文：{}", JSON.toJSONString(request));
        Response response = iTankService.deleteTankeByTank(JSON.parseArray(JSON.toJSONString(request.getData()),String.class));
        return response;
    }

    @Override
    public Response updatePut(Request<TankEntity> request) {
        log.info("updateTankeByTank Request报文：{}", JSON.toJSONString(request));
        Response response = iTankService.updateTankeByTank(request);
        return response;
    }

    @Override
    public Response getDropDownInit() {
        Response response = iTankService.queryDropDownAll();
        String strList = JSON.toJSONString(response.getData()).replaceAll("\\s","");
        response.setData(JSON.parse(strList));
        log.info("getDropDownInit Response报文：{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @Override
    public Response postListInit(Request<TankEntity> request) {
        log.info("queryTankByTankAll Request报文：{}", JSON.toJSONString(request));
        Response response = iTankService.queryTankByTankAll(request);
        return response;
    }
}
