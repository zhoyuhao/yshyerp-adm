package com.yshyerp.adm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tank_c")
public class tankc {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //通过注解声明该字段不是数据库的字段
    @TableField(exist = false)
    private  Integer key;

    private String d;

    private String tank;

    private String comm1;

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

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank == null ? null : tank.trim();
    }

    public String getComm1() {
        return comm1;
    }

    public void setComm1(String comm1) {
        this.comm1 = comm1 == null ? null : comm1.trim();
    }
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}