package com.yshyerp.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.adm.entity.Vessel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VesselMapper extends BaseMapper<Vessel> {

    /**
     * 查询和条件查询船泊资料
     *
     * @param vessel
     * @param name
     * @return
     */
    List<Vessel> getVessel(@Param("vessel") String vessel, @Param("name") String name);

    /**
     * 添加船泊资料
     *
     * @param vessel
     * @return
     */
    Integer addVessel(Vessel vessel);

    /**
     * 删除船泊资料
     *
     * @param vessel
     * @return
     */
    Integer deleteVessel(List<String> list);

    /**
     * 修改船泊资料
     *
     * @param vessel
     * @return
     */
    Integer update(Vessel vessel);
}