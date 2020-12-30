package com.yshyerp.adm.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yshyerp.adm.entity.CusEmail;
import com.yshyerp.adm.entity.CustomerEntity;
import com.yshyerp.adm.entity.ScustomerEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-09
 * @Description: 公司vo
 */
@Data
public class CustomerVO{

    //小公司
    private List<String> sCustomer;


    private String customer;


    private String code;


    private String fullname;


    private String cname;


    private String address;


    private String postcode;


    private String areaCode;


    private String telephone1;


    private String telephone2;


    private String faxno;


    private String contact;


    private String taxno;


    private String d;


    private Integer drumlock;


    private Integer order1;



    ///客户email信息
    private Boolean d1Enabled;


    private String dEnabled;


    private String rdEnabled;


    private String rdMail;


    private String email1;


    private String email2;


    private String email3;


    private String email4;


    private String email5;


    private String email6;


    private String email7;


    private String email8;

    private CusEmail cusEmail;

    private List<CusEmail> cusEmailList;

}
