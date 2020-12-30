package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.TankEntity;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-02
 * @Description: 临时罐号Service
 */
public interface ITankService {

    /**
     * 查看所有临时罐号(支持条件)
     * @param request
     * @return
     */
    Response queryTankByTankAll(Request<TankEntity> request);

    /**
     * 查看所有下拉数据
     * @return
     */
    Response queryDropDownAll();

    /**
     * 根据tank修改临时罐号
     * @param request
     * @return
     */
    Response updateTankeByTank(Request<TankEntity> request);

    /**
     * 根据tank删除临时罐号
     * @param tank
     * @return
     */
    Response deleteTankeByTank(List<String>  tank);

    /**
     * 添加临时罐号数据
     * @param request
     * @return
     */
    Response inserTank(Request<TankEntity> request);


    /**
     * 查看指定临时罐号
     * @param request
     * @return
     */
    Response queryByTank(String request);
}
