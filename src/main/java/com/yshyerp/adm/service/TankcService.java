package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.tankc;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

import java.util.List;

public interface TankcService {

    /**
     * 根据id查询
     *
     * @param id   打印货品id
     * @param tank 罐号
     * @return
     */
    Response getTankc(Request<tankc> req);

    /**
     * 添加打印货品
     *
     * @param tankc 对象
     * @return
     */
    Response addTankc(tankc tankc);

    /**
     * 根据id删除打印货品
     *
     * @param id 货品id
     */
    Response dateleTankc(List<Integer> id);

    /**
     * 根据id修改打印货品
     *
     * @param tankc 对象
     * @return
     */
    Response updateTankc(tankc tankc);
}
