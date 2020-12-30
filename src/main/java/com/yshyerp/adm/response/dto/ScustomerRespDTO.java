package com.yshyerp.adm.response.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-09
 * @Description: 码头管线 respdto
 */
@Data
public class ScustomerRespDTO {


    private String customer;


    private String sCustomer;


    private String cname;


    private String d;

    private List<DropDownBoxDTO> dropDownBox;
}
