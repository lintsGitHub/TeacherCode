package com.nf147.test01.controller;

import com.nf147.test01.entity.Order;
import com.nf147.test01.validator.CommonValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class OrderController {
//    @InitBinder
//    public void suibianqigemingzidanyidingyaoyouyiyi(WebDataBinder binder) {
//        binder.setValidator(new CommonValidator());
//    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public Order order (@Validated @RequestBody Order order, BindingResult result) {
        return order;
    }
}
