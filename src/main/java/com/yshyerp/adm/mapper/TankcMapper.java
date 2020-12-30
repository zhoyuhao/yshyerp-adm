package com.yshyerp.adm.mapper;

import com.yshyerp.adm.entity.tankc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TankcMapper {

    /**
     * 根据id查询
     *
     * @param id   打印货品id
     * @param tank 罐号
     * @return
     */
    List<tankc> getTankc(tankc t);

    /**
     * 添加打印货品
     *
     * @param tankc 对象
     * @return
     */
    Integer addTankc(tankc tankc);

    /**
     * 根据id删除打印货品
     *
     * @param id 货品id
     */
    Integer dateleTankc(List<Integer> id);

    Integer updateTankc(tankc tankc);
}