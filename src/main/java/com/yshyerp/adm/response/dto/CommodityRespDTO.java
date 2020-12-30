package com.yshyerp.adm.response.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-06
 * @Description: 货品修修改初始化数据
 */
@Data
public class CommodityRespDTO {

    private String code;

    private String commodity;

    private String fullname;

    private String cname;

    private BigDecimal density;

    private String commCode;

    private String d;

    private Boolean wx;

    private Integer id;

    private Integer order1;

    private BigDecimal flash;

    private String nature;

    private String type;

    private List<DropDownBoxDTO> dropDownBox;

}
