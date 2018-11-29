package com.nf147.test01.service;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ExcelServiceTest {

    @Test
    public void testFetchFromExcel() throws IOException {
        ExcelService excelService = new ExcelService();
        excelService.testFetchFromExcel();
    }
}