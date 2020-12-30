package com.yshyerp.adm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("berth")
public class Berth {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //通过注解声明该字段不是一个数据库表里面的字段
    @TableField(exist = false)
    private Integer key;

    private String d;

    private String berthNo;

    private String berthname;

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

    public String getBerthNo() {
        return berthNo;
    }

    public void setBerthNo(String berthNo) {
        this.berthNo = berthNo == null ? null : berthNo.trim();
    }

    public String getBerthname() {
        return berthname;
    }

    public void setBerthname(String berthname) {
        this.berthname = berthname == null ? null : berthname.trim();
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

}