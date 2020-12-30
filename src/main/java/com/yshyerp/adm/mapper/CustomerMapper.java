package com.yshyerp.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.adm.entity.CustomerEntity;
import com.yshyerp.adm.entity.vo.CustomerVO;

import java.util.List;

public interface CustomerMapper extends BaseMapper<CustomerEntity> {



    /**
     * 查看所有公司信息
     * @param request
     * @return
     */
    List<CustomerVO> queryCustomerAll(CustomerEntity request);

    /**
     * 修改该公司的邮箱信息
     * @param customerVO
     * @return
     */
    Integer updateEmail(CustomerVO customerVO);

    /**
     * 删除公司
     * @param customer
     * @return
     */
    Integer updateByCustomer(List<String> customer);
}