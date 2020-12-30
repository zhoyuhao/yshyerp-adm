package com.yshyerp.adm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yshyerp.adm.entity.TankEntity;
import com.yshyerp.adm.response.dto.DropDownBoxDTO;

import java.util.List;

public interface TankMapper extends BaseMapper<TankEntity> {


   /**
    * 查看所有临时罐号
    * @param request
    * @return
    */
   List<TankEntity> queryTankByTankAll(TankEntity request);

   /**
    * 临时管好删除
    * @return
    */
   Integer deleteTankeByTank(List<String> tank);

   /**
    * 查看临时罐号 流水号最近的
    * @return
    */
   String queryTankDescOne();

   /**
    * 查看临时罐号 code最近的一条
    * @return
    */
   String queryTankCodeDescOne();

   /**
    * 查看客户下拉
    * @return
    */
   List<DropDownBoxDTO> customerDropDown();

   /**
    * 查看货品下拉
    * @return
    */
   List<DropDownBoxDTO> commodityDropDown();

   /**
    * 添加临时罐号
    * @param tankEntity
    * @return
    */
   Integer addTank(TankEntity tankEntity);
}