package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.OtherDict;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;

import java.util.List;

public interface OtherDictService {
    /**
     * 根据id查询颜色
     *
     * @param  req
     * @return 返回颜色
     */
    Response getOtherDict(Request<OtherDict> req);

    /**
     * 添加颜色
     *
     * @param otherDict
     */
    Response addOtherDict(OtherDict otherDict);

    /**
     * 修改颜色
     *
     * @param otherDict
     */
    Response updateOtherDict(OtherDict otherDict);

    /**
     * 根据cole删除
     *
     * @param list
     */
    Response daleteOtherDict(List<Integer> list);
}
