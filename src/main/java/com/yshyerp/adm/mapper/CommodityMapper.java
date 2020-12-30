package com.yshyerp.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.adm.entity.CommodityEntity;

import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-10-30
 * @Description: 货品mapper
 */
public interface CommodityMapper extends BaseMapper<CommodityEntity> {

    /**
     *查看所有货品
     * @return
     */
   List<CommodityEntity> queryCommodityAll(CommodityEntity commodity);


    /**
     *根据commodity删除货品
     * @return
     */
   Integer deleteByCommodity(List<Integer> commodity);
}