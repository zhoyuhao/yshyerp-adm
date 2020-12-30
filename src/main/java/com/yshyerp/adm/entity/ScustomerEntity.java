package com.yshyerp.adm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("s_customer")
public class ScustomerEntity implements Serializable {

private Integer key;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_customer.customer
     *
     * @mbggenerated
     */

    private String customer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_customer.s_customer
     *
     * @mbggenerated
     */
    @TableField("s_customer")
    private String sCustomer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_customer.cname
     *
     * @mbggenerated
     */
    private String cname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_customer.d
     *
     * @mbggenerated
     */
    private String d;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table s_customer
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_customer.customer
     *
     * @return the value of s_customer.customer
     *
     * @mbggenerated
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_customer.customer
     *
     * @param customer the value for s_customer.customer
     *
     * @mbggenerated
     */
    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_customer.s_customer
     *
     * @return the value of s_customer.s_customer
     *
     * @mbggenerated
     */
    public String getsCustomer() {
        return sCustomer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_customer.s_customer
     *
     * @param sCustomer the value for s_customer.s_customer
     *
     * @mbggenerated
     */
    public void setsCustomer(String sCustomer) {
        this.sCustomer = sCustomer == null ? null : sCustomer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_customer.cname
     *
     * @return the value of s_customer.cname
     *
     * @mbggenerated
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_customer.cname
     *
     * @param cname the value for s_customer.cname
     *
     * @mbggenerated
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_customer.d
     *
     * @return the value of s_customer.d
     *
     * @mbggenerated
     */
    public String getD() {
        return d;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_customer.d
     *
     * @param d the value for s_customer.d
     *
     * @mbggenerated
     */
    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }
}