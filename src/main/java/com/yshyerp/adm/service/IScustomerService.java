package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.ScustomerEntity;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-03
 * @Description: 小客户 IService
 */
public interface IScustomerService {

    /**
     * 根据 customer 删除小客户数据
     * @param request
     * @return
     */
    Response deleteByCustomer(Request request);

    /**
     * 根据  customer and sCustomer 查看指定数据
     * @param request
     * @return
     */
    Response queryCustomer(Request<ScustomerEntity> request);


    /**
     * 查看所有小客户数据  支持分页 、条件（customer、sCustomer、cname）
     * @param request
     * @return
     */
    Response queryCustomerAll(Request<ScustomerEntity> request);

    /**
     * 根据 customer、sCustomer 修改小客户数据
     * @param request
     * @return
     */
    Response updateCustomer(Request<ScustomerEntity> request);

    /**
     * 添加小客户数据
     * @param request
     * @return
     */
    Response insertCustomer(Request<ScustomerEntity> request);


    /**
     * 查询大客户
     * @return
     */
    Response getDropDownInit();

}
