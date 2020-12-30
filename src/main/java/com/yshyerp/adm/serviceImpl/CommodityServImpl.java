package com.yshyerp.adm.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.entity.CommodityEntity;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.response.dto.DropDownBoxDTO;
import com.yshyerp.adm.enums.CommodityEnum;
import com.yshyerp.adm.mapper.CommodityMapper;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.ICommodityService;
import com.yshyerp.adm.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Author: zhoyuhao
 * @Data: 2020-10-30
 * @Description: 货品serviceImpl
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS,isolation = Isolation.READ_COMMITTED,readOnly = true)
public class CommodityServImpl implements ICommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 查看货品
     * @param request
     * @return
     */
    @Override
    public Response queryCommodityAll(Request<CommodityEntity> request) {
        Response response = null;
        if(!StringUtils.isEmpty(request) && !StringUtils.isEmpty(request.getPageNum()) && !StringUtils.isEmpty(request.getPageSize()))
            PageHelper.startPage(request.getPageNum(), request.getPageSize());
        try {
            //执行查询SQL操作
            List<CommodityEntity>  listData = commodityMapper.queryCommodityAll(request.getData());
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo( this.setListData(listData)));
        }catch (NullPointerException e){
            response = Response.error("queryCommodityAll接口内部异常！");
            log.error("queryCommodityAll接口操作失败：{}","switch(val) val=null");
        }catch (Exception e){
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryCommodityAll接口操作失败：{}",e.getMessage());
        }
        return response;
    }


    /**
     * 查看指定货品信息
     * @param commodity
     * @return
     */
    @Override
    public Response queryCommodityOne(String commodity) {
        Response response = null;
        try {
            //执行查询SQL操作
            CommodityEntity commod = new CommodityEntity();
            commod.setId(Integer.parseInt(commodity));
            List<CommodityEntity>  listData = commodityMapper.queryCommodityAll(commod);
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(),listData.size()==0?null:this.setListData(listData).get(0));
        }catch (NullPointerException e){
            response = Response.error("queryCommodityOne接口内部异常！");
            log.error("queryCommodityOne接口操作失败：{}","switch(val) val=null");
        }catch (Exception e){
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryCommodityOne接口操作失败：{}",e.getMessage());
        }
        return response;
    }

    /**
     *根据commodity删除货品
     * @param commodity
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public Response updateByCommodity(Request commodity) {
        Response response=null;
        try {
            //执行删除SQL操作
            List<Integer> intList = JSON.parseArray(JSON.toJSONString(commodity.getData()),Integer.class);
            if(commodityMapper.deleteByCommodity(intList) != 0) {
                response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(),1);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.info("updateByCommodity接口操作失败：{}", e.getMessage());
        }
        return response;
    }

    /**
     *添加货品数据
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public Response insertCommodity(Request<CommodityEntity> request){
        Response response =null;
        try{
            request.getData().setWx(request.getData().getWx().equals("是")?"1":"0");
            if (CommodityEnum.getTypeMap()!=null){
                CommodityEnum.getTypeMap().forEach((k,v)->{
                    if(v.equals(request.getData().getType())){
                        request.getData().setType(k);
                    }
                });
            }
            //执行添加SQL操作
            if(commodityMapper.insert(request.getData())!=0){
                response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(),1);
            }else{
                throw  new Exception();
            }
        }catch (Exception e){
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
            log.info("insertCommodity接口操作失败：{}", e.getMessage());
        }
        return response;
    }

    /**
     *修改货品数据
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = false)
    public Response updateById(Request<CommodityEntity> request) {
        Response response =null;
        try{
            //执行添加SQL操作
            request.getData().setCode(null);
            request.getData().setCommodity(null);
            request.getData().setKey(null);
            request.getData().setWx(request.getData().getWx().equals("是")?"1":"0");

            if (CommodityEnum.getTypeMap()!=null){
                CommodityEnum.getTypeMap().forEach((k,v)->{
                   if(v.equals(request.getData().getType())){
                       request.getData().setType(k);
                   }
                });
            }
            if(commodityMapper.updateById(request.getData())!=0){
                response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(),1);
            }else{
                throw  new Exception();
            }
        }catch (Exception e){
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
            log.info("updateById接口操作失败：{}", e.getMessage());
        }
        return response;
    }

    /**
     * 查看所有货品类型
     * @return
     */
    @Override
    public Response queryCommodityType() {
        List<DropDownBoxDTO> listData = new ArrayList();
        if (CommodityEnum.getTypeMap()!=null){
            CommodityEnum.getTypeMap().forEach((k,v)->{
                listData.add(new DropDownBoxDTO(k,v,v));
            });
        }
        List<DropDownBoxDTO> listData2 = new ArrayList();
        DropDownBoxDTO dropDownBoxDTO1 = new DropDownBoxDTO("是","是","是");
        DropDownBoxDTO dropDownBoxDTO2 = new DropDownBoxDTO("否","否","否");
        listData2.add(dropDownBoxDTO1);
        listData2.add(dropDownBoxDTO2);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("typeList",DropDownBoxUtils.toDropDownBoxJSON(listData));
        jsonObject.put("riskList",DropDownBoxUtils.toDropDownBoxJSON(listData2));
        return Response.success(MessageEnum.SELECT_SUCCESS.getVal(),jsonObject);
    }


    /**
     * 将数据结果的type属性值转为对应的中文名称
     * @param listData
     * @return
     */
    private List<CommodityEntity> setListData(List<CommodityEntity> listData){
        String typeName = null;
        for (CommodityEntity listDatum : listData) {
            if(listDatum.getId()==195){
                listDatum.setType("1");
            }
            if(listDatum.getWx().equals("1")){
                listDatum.setWx("是");
            }else{
                listDatum.setWx("否");
            }
            listDatum.setKey(listDatum.getId());
            if(StringUtils.isEmpty(listDatum.getType()))continue;
            switch (Objects.requireNonNull(CommodityEnum.getByValue(listDatum.getType()))) {
                case TYPE_NAME1:
                    typeName = CommodityEnum.TYPE_NAME1.getName();
                    break;
                case TYPE_NAME2:
                    typeName = CommodityEnum.TYPE_NAME2.getName();
                    break;
                case TYPE_NAME3:
                    typeName = CommodityEnum.TYPE_NAME3.getName();
                    break;
                case TYPE_NAME4:
                    typeName = CommodityEnum.TYPE_NAME4.getName();
                    break;
                case TYPE_NAME5:
                    typeName = CommodityEnum.TYPE_NAME5.getName();
                    break;
            }


            listDatum.setType(typeName);


        }
        return  listData;
    }
}
