package com.dianping.pigeon.governor.model;

import java.util.Date;

public class ProjectOrg {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.id
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.name
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.bu
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    private String bu;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.product
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    private String product;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.updateTime
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.id
     *
     * @return the value of organization.id
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.id
     *
     * @param id the value for organization.id
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.name
     *
     * @return the value of organization.name
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.name
     *
     * @param name the value for organization.name
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.bu
     *
     * @return the value of organization.bu
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public String getBu() {
        return bu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.bu
     *
     * @param bu the value for organization.bu
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public void setBu(String bu) {
        this.bu = bu == null ? null : bu.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.product
     *
     * @return the value of organization.product
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public String getProduct() {
        return product;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.product
     *
     * @param product the value for organization.product
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.updateTime
     *
     * @return the value of organization.updateTime
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.updateTime
     *
     * @param updatetime the value for organization.updateTime
     *
     * @mbggenerated Thu Aug 11 18:00:50 CST 2016
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}