package com.yshyerp.adm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

@TableName("vessel")
public class Vessel {

    @TableField(exist = false)
    private Integer key;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    @TableId("vessel")
    private String vessel;

    private String type;

    @TableField(value = "[desc]")
    private String desc;
    @TableField(value = "c_name")
    private String cName;

    private String owner;

    private String operater;

    private String agent;

    private String nationality;

    private String nation;

    private BigDecimal length;

    private BigDecimal breadth;

    private BigDecimal draft;

    private BigDecimal netWeight;

    private BigDecimal grossWt;

    private BigDecimal loadWt;

    private String builder;

    private String builtYear;

    private Short loadCap;

    private Integer pumpRate;

    private Short count;

    private Boolean crane;

    public String getVessel() {
        return vessel;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel == null ? null : vessel.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater == null ? null : operater.trim();
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getBreadth() {
        return breadth;
    }

    public void setBreadth(BigDecimal breadth) {
        this.breadth = breadth;
    }

    public BigDecimal getDraft() {
        return draft;
    }

    public void setDraft(BigDecimal draft) {
        this.draft = draft;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getGrossWt() {
        return grossWt;
    }

    public void setGrossWt(BigDecimal grossWt) {
        this.grossWt = grossWt;
    }

    public BigDecimal getLoadWt() {
        return loadWt;
    }

    public void setLoadWt(BigDecimal loadWt) {
        this.loadWt = loadWt;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder == null ? null : builder.trim();
    }

    public String getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(String builtYear) {
        this.builtYear = builtYear == null ? null : builtYear.trim();
    }

    public Short getLoadCap() {
        return loadCap;
    }

    public void setLoadCap(Short loadCap) {
        this.loadCap = loadCap;
    }

    public Integer getPumpRate() {
        return pumpRate;
    }

    public void setPumpRate(Integer pumpRate) {
        this.pumpRate = pumpRate;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public Boolean getCrane() {
        return crane;
    }

    public void setCrane(Boolean crane) {
        this.crane = crane;
    }
}