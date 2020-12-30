package com.yshyerp.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.adm.entity.ScustomerEntity;
import com.yshyerp.adm.response.dto.DropDownBoxDTO;

import java.util.List;

public interface ScustomerMapper extends BaseMapper<ScustomerEntity> {

    /**
     * 根据 customer 删除小客户数据
     * @param list
     * @return
     */
    Integer deleteByCustomer(List<String> list);

    List<DropDownBoxDTO> queryCustomer();

    List<ScustomerEntity> queryCustomerAll(ScustomerEntity req);
}