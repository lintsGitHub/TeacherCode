package com.nf147.test01.entity;


import com.nf147.test01.annotation.Price;
import com.nf147.test01.annotation.PriceRange;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 产品类
 */
public class Product {
    @NotBlank
    private String name;

    @PriceRange(min = 10, max = 20)
    private Float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
