package com.nf147.test01.controller;

import com.nf147.test01.entity.Book;
import com.nf147.test01.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormTestController {

    @GetMapping("/form")
    public String input() {
        return "formtest";
    }

    @GetMapping("/formpost")
    public String input2() {
        return "formtest";
    }

    @PostMapping("/formpost")
    public String input3(MultipartFile ddd, String aaa, int bbb, String ccc) {
        return "formtest";
    }

    @PostMapping("/myupload")
    public @ResponseBody
    String myupload(MultipartFile fff) throws IOException {
        fff.transferTo(new File("d:/aaa.jpg"));
        return "success";
    }

    @GetMapping("/myupload")
    public String myup(HttpServletResponse response) {
        response.setHeader("content-type", "application/suibian");
        response.setHeader("content-length", "0");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        PrintWriter writer = response.getWriter();
//        writer.write();
        return "fileUpload";
    }

    @GetMapping("/aaa")
    public ResponseEntity aaa() {
        Book book = new Book();
        book.setName("你的风流往事");
        book.setPrice(333f);
        return ResponseEntity.ok(book);
    }

}
