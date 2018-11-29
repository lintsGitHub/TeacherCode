package com.nf147.test01.entity;

import com.nf147.test01.annotation.CellPhone;
import com.nf147.test01.annotation.OrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

public class OrderBk {

    // 必须是 10 位
    @NotBlank
    @Size(min = 10, max = 10)
    private String orderId;

    @NotBlank
    private String customer;

    @Email
    private String email;

    //@Pattern(regexp = "^[0-9]{11}$") //?
    @CellPhone
    private String telephone;

    @NotBlank
    private String address;

    @OrderStatus(message = "装个错误")
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    private Date createDate;

    @NotNull
    @Valid
    private Product product;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
