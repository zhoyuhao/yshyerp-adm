package com.yshyerp.adm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bukrs_prctr")
public class Bukrsprctr {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //通过注解声明该字段不是数据库的字段
    @TableField(exist = false)
    private  Integer key;

    private String d;
    private String bukrsNo;

    private String bukrsname;

    private String prctrNo;

    private String prctrname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }

    public String getBukrsNo() {
        return bukrsNo;
    }

    public void setBukrsNo(String bukrsNo) {
        this.bukrsNo = bukrsNo == null ? null : bukrsNo.trim();
    }

    public String getBukrsname() {
        return bukrsname;
    }

    public void setBukrsname(String bukrsname) {
        this.bukrsname = bukrsname == null ? null : bukrsname.trim();
    }

    public String getPrctrNo() {
        return prctrNo;
    }

    public void setPrctrNo(String prctrNo) {
        this.prctrNo = prctrNo == null ? null : prctrNo.trim();
    }

    public String getPrctrname() {
        return prctrname;
    }

    public void setPrctrname(String prctrname) {
        this.prctrname = prctrname == null ? null : prctrname.trim();
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}