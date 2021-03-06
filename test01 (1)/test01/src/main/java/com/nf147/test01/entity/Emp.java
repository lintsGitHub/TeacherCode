package com.nf147.test01.entity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class Emp {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em.e_id
     *
     * @mbg.generated
     */
    private String eId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em.e_name
     *
     * @mbg.generated
     */
    @NotEmpty
    private String eName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em.e_sex
     *
     * @mbg.generated
     */
    private String eSex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em.e_xueli
     *
     * @mbg.generated
     */
    private String eXueli;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em.e_salary
     *
     * @mbg.generated
     */
    @DecimalMin("10")
    private BigDecimal eSalary;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em.e_id
     *
     * @return the value of em.e_id
     *
     * @mbg.generated
     */
    public String geteId() {
        return eId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em.e_id
     *
     * @param eId the value for em.e_id
     *
     * @mbg.generated
     */
    public void seteId(String eId) {
        this.eId = eId == null ? null : eId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em.e_name
     *
     * @return the value of em.e_name
     *
     * @mbg.generated
     */
    public String geteName() {
        return eName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em.e_name
     *
     * @param eName the value for em.e_name
     *
     * @mbg.generated
     */
    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em.e_sex
     *
     * @return the value of em.e_sex
     *
     * @mbg.generated
     */
    public String geteSex() {
        return eSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em.e_sex
     *
     * @param eSex the value for em.e_sex
     *
     * @mbg.generated
     */
    public void seteSex(String eSex) {
        this.eSex = eSex == null ? null : eSex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em.e_xueli
     *
     * @return the value of em.e_xueli
     *
     * @mbg.generated
     */
    public String geteXueli() {
        return eXueli;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em.e_xueli
     *
     * @param eXueli the value for em.e_xueli
     *
     * @mbg.generated
     */
    public void seteXueli(String eXueli) {
        this.eXueli = eXueli == null ? null : eXueli.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em.e_salary
     *
     * @return the value of em.e_salary
     *
     * @mbg.generated
     */
    public BigDecimal geteSalary() {
        return eSalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em.e_salary
     *
     * @param eSalary the value for em.e_salary
     *
     * @mbg.generated
     */
    public void seteSalary(BigDecimal eSalary) {
        this.eSalary = eSalary;
    }
}