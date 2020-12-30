package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.Berth;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/12
 * @Description:
 */
public interface BerthService {
    /**
     * 根据berth_no  berthname查询
     *
     * @param req
     * @return 返回泊位资料
     */
    Response getBerth(Request<Berth> req);

    /**
     * 添加泊位资料
     *
     * @param berth
     */
    Response addBerth(Request<Berth> berth);

    /**
     * 修改泊位资料
     *
     * @param berth
     */
    Response updateBerth(Request<Berth> berth);

    /**
     * 根据id删除泊位资料
     *
     * @param id
     */
    Response daleteBerth(List<Integer> id);
}
