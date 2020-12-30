package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.CommodityEntity;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

/**
 * @Author: zhoyuhao
 * @Data: 2020-10-30
 * @Description: 货品service
 */
public interface ICommodityService {


    /**
     * 查看货品
     * @param request
     * @return
     */
    Response queryCommodityAll(Request<CommodityEntity> request);

    /**
     * 查看知道货品信
     * @param commodity
     * @return
     */
    Response queryCommodityOne(String commodity);

    /**
     *根据commodity删除货品
     * @param commodity
     * @return
     */
    Response updateByCommodity(Request commodity);

    /**
     *添加货品数据
     * @return
     */
    Response insertCommodity(Request<CommodityEntity> request);

    /**
     *修改货品数据
     * @param request
     * @return
     */
    Response updateById(Request<CommodityEntity> request);

    /**
     * 查看所有货品类型
     * @return
     */
    Response queryCommodityType();

}
