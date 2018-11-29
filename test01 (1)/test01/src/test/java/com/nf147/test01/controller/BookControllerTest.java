package com.nf147.test01.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookControllerTest {

    BookController bookController = new BookController();

    @Test
    public void makeImagePath() {
        String s = bookController.makeRelativePath("meinsfsdfsfdfsdv.jpg");
        System.out.println(s);
    }

    @Test
    public void testSplitFileName() {
        String file = "hellsdfsf.sdfsfdo.jpg";
        String[] strings = bookController.splitFileString(file);
        System.out.println(strings[0]);
        System.out.println(strings[1]);

    }
}