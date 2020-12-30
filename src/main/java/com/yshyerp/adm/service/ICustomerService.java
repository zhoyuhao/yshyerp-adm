package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.CustomerEntity;
import com.yshyerp.adm.entity.vo.CustomerVO;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-03
 * @Description: 公司  IService
 */
public interface ICustomerService {

    /**
     * 查看所有公司信息
     * @param request
     * @return
     */
    Response queryCustomerAll(Request<CustomerEntity> request);


    /**
     * 修改公司信息
     * @param request
     * @return
     */
    Response updateCustomer(Request<CustomerVO> request);



    /**
     * 删除公司
     * @param customer
     * @return
     */
    Response deleteCustomer(Request customer);


    /**
     * 查看指定公司
     * @param request
     * @return
     */
    Response queryByCustomer(String request);


    /**
     * 添加公司信息
     * @param request
     * @return
     */
    Response insertCustomer(Request<CustomerVO> request);

}
