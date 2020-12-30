package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.Vessel;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/3
 * @Description: VesselService
 */
public interface VesselService {

    /**
     * 查询和条件查询船泊资料
     *
     * @param vessel
     * @param cName
     * @return
     */
    Response getVessel(Request<Vessel> req);

    /**
     * 添加船泊资料
     *
     * @param vessel
     * @return
     */
    Response addVessel(Vessel vessel);

    /**
     * 删除船泊资料
     *
     * @param vessel
     * @return
     */
    Response deleteVessel(List<String> list);

    /**
     * 修改船泊资料
     *
     * @param vessel
     * @return
     */
    Response update(Vessel vessel);
}
