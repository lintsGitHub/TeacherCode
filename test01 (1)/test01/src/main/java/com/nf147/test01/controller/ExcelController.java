package com.nf147.test01.controller;

import com.nf147.test01.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @GetMapping(value = "/excel_download")
    ResponseEntity<byte[]> downloadFile() throws IOException {
        byte[] contents = excelService.exportExcel().toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl("no-cache, no-store, must-revalidate");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(contents.length);
        headers.setContentDispositionFormData("attachment", "xxx_" + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".xls");

        return ResponseEntity.ok().headers(headers).body(contents);
    }
}
