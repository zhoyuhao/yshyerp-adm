package com.yshyerp.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.adm.entity.Berth;
import com.yshyerp.adm.entity.Bukrsprctr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BukrsprctrMapper extends BaseMapper<Bukrsprctr> {
    /**
     * 公司_利润中心表查询
     *
     * @param
     * @return 返回公司_利润中心表
     */
    List<Bukrsprctr> getBukrsprctr(@Param("bukrsname") String bukrsname, @Param("prctrname") String prctrname);

    /**
     * 添加公司_利润中心表
     *
     * @param
     */
    Integer addBukrsprctr(Bukrsprctr bukrsprctr);

    /**
     * 修改公司_利润中心表
     *
     * @param
     */
    Integer updateBukrsprctr(Bukrsprctr bukrsprctr);

    /**
     * 根据id删除公司_利润中心表
     *
     * @param id
     */
    Integer daleteBukrsprctr(List<Integer> id);
}