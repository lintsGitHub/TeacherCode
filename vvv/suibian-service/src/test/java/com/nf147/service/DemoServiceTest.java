package com.nf147.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class DemoServiceTest {

    @Test
    public void sayHello() {
        DemoService demoService = new DemoService();
        demoService.sayHello();
    }
}