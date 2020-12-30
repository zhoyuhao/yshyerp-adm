package com.yshyerp.adm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("customer")
public class CustomerEntity implements Serializable {

    @TableField(exist = false)
    private Integer key;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.customer
     *
     * @mbggenerated
     */
    @TableId("customer")
    private String customer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.fullname
     *
     * @mbggenerated
     */
    private String fullname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.cname
     *
     * @mbggenerated
     */
    private String cname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.postcode
     *
     * @mbggenerated
     */
    private String postcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.area_code
     *
     * @mbggenerated
     */
    @TableField("area_code")
    private String areaCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.telephone1
     *
     * @mbggenerated
     */
    private String telephone1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.telephone2
     *
     * @mbggenerated
     */
    private String telephone2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.faxno
     *
     * @mbggenerated
     */
    private String faxno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.contact
     *
     * @mbggenerated
     */
    private String contact;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.taxno
     *
     * @mbggenerated
     */
    private String taxno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.d
     *
     * @mbggenerated
     */
    private String d;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.drumlock
     *
     * @mbggenerated
     */
    private Integer drumlock;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.order1
     *
     * @mbggenerated
     */
    private Integer order1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.customer
     *
     * @return the value of customer.customer
     *
     * @mbggenerated
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.customer
     *
     * @param customer the value for customer.customer
     *
     * @mbggenerated
     */
    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.code
     *
     * @return the value of customer.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.code
     *
     * @param code the value for customer.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.fullname
     *
     * @return the value of customer.fullname
     *
     * @mbggenerated
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.fullname
     *
     * @param fullname the value for customer.fullname
     *
     * @mbggenerated
     */
    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.cname
     *
     * @return the value of customer.cname
     *
     * @mbggenerated
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.cname
     *
     * @param cname the value for customer.cname
     *
     * @mbggenerated
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.address
     *
     * @return the value of customer.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.address
     *
     * @param address the value for customer.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.postcode
     *
     * @return the value of customer.postcode
     *
     * @mbggenerated
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.postcode
     *
     * @param postcode the value for customer.postcode
     *
     * @mbggenerated
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.area_code
     *
     * @return the value of customer.area_code
     *
     * @mbggenerated
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.area_code
     *
     * @param areaCode the value for customer.area_code
     *
     * @mbggenerated
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.telephone1
     *
     * @return the value of customer.telephone1
     *
     * @mbggenerated
     */
    public String getTelephone1() {
        return telephone1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.telephone1
     *
     * @param telephone1 the value for customer.telephone1
     *
     * @mbggenerated
     */
    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1 == null ? null : telephone1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.telephone2
     *
     * @return the value of customer.telephone2
     *
     * @mbggenerated
     */
    public String getTelephone2() {
        return telephone2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.telephone2
     *
     * @param telephone2 the value for customer.telephone2
     *
     * @mbggenerated
     */
    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2 == null ? null : telephone2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.faxno
     *
     * @return the value of customer.faxno
     *
     * @mbggenerated
     */
    public String getFaxno() {
        return faxno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.faxno
     *
     * @param faxno the value for customer.faxno
     *
     * @mbggenerated
     */
    public void setFaxno(String faxno) {
        this.faxno = faxno == null ? null : faxno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.contact
     *
     * @return the value of customer.contact
     *
     * @mbggenerated
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.contact
     *
     * @param contact the value for customer.contact
     *
     * @mbggenerated
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.taxno
     *
     * @return the value of customer.taxno
     *
     * @mbggenerated
     */
    public String getTaxno() {
        return taxno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.taxno
     *
     * @param taxno the value for customer.taxno
     *
     * @mbggenerated
     */
    public void setTaxno(String taxno) {
        this.taxno = taxno == null ? null : taxno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.d
     *
     * @return the value of customer.d
     *
     * @mbggenerated
     */
    public String getD() {
        return d;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.d
     *
     * @param d the value for customer.d
     *
     * @mbggenerated
     */
    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.drumlock
     *
     * @return the value of customer.drumlock
     *
     * @mbggenerated
     */
    public Integer getDrumlock() {
        return drumlock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.drumlock
     *
     * @param drumlock the value for customer.drumlock
     *
     * @mbggenerated
     */
    public void setDrumlock(Integer drumlock) {
        this.drumlock = drumlock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.order1
     *
     * @return the value of customer.order1
     *
     * @mbggenerated
     */
    public Integer getOrder1() {
        return order1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.order1
     *
     * @param order1 the value for customer.order1
     *
     * @mbggenerated
     */
    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }
}