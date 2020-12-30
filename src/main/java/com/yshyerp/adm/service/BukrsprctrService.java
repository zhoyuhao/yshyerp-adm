package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.Bukrsprctr;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/12
 * @Description:
 */
public interface BukrsprctrService {
    /**
     * 公司_利润中心表查询
     *
     * @param req
     * @return 返回公司_利润中心表
     */
    Response getBukrsprctr(Request<Bukrsprctr> req);

    /**
     * 添加公司_利润中心表
     *
     * @param
     */
    Response addBukrsprctr(Request<Bukrsprctr> bukrsprctr);

    /**
     * 修改公司_利润中心表
     *
     * @param
     */
    Response updateBukrsprctr(Request<Bukrsprctr> bukrsprctr);

    /**
     * 根据id删除公司_利润中心表
     *
     * @param id
     */
    Response daleteBukrsprctr(List<Integer> id);
}
