package com.yshyerp.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.adm.entity.OtherDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OtherDictMapper extends BaseMapper<OtherDict> {
    /**
     * 根据id查询颜色
     *
     * @param  otherDict
     * @return 返回颜色
     */
    List<OtherDict> getOtherDict(OtherDict otherDict);

    /**
     * 添加颜色
     *
     * @param otherDict
     */
    Integer addOtherDict(OtherDict otherDict);

    /**
     * 修改颜色
     *
     * @param otherDict
     */
    Integer updateOtheDict(OtherDict otherDict);

    /**
     * 根据cole删除
     *
     * @param list
     */
    Integer daleteOtherDict(List<Integer> list);
}