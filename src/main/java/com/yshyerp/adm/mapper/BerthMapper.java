package com.yshyerp.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.adm.entity.Berth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BerthMapper extends BaseMapper<Berth> {
    /**
     * 根据berth_no  berthname查询
     *
     * @param berthno berthname
     * @return 返回泊位资料
     */
    List<Berth> getBerth(@Param("berthno") String berthno, @Param("berthname") String berthname);

    /**
     * 添加泊位资料
     *
     * @param berth
     */
    Integer addBerth(Berth berth);

    /**
     * 修改泊位资料
     *
     * @param berth
     */
    Integer updateBerth(Berth berth);

    /**
     * 根据id删除泊位资料
     *
     * @param id
     */
    Integer daleteBerth(List<Integer> id);
}