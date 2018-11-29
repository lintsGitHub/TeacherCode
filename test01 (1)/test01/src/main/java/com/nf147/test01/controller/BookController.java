package com.nf147.test01.controller;

import com.nf147.test01.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/book")
    public String input(Book book) {
        book.setPrice(200f);
        return "book_input";
    }

    @PostMapping("/book222")
    public String submit222(Book book, BindingResult result) {
        String name = book.getName();
        if (name == null || name.length() < 5) {
            result.rejectValue("name", null, "名字不能为空，并且不能太短(>5)");
        }

        Float price = book.getPrice();
        if (price > 10000) {
            result.rejectValue("price", null, "您的价格是不是不对啊？");
        }

        if (result.hasErrors())
            return "book_input";

        System.out.println("正常业务。。。。");
        return "book_home";
    }

    @PostMapping("/book2")
    public String submit(@Valid Book book, BindingResult result) {
        if (result.hasErrors())
            return "book_input";

        System.out.println("正常业务。。。。");
        return "book_home";
    }

    @PostMapping("/book")
    public String imageshangchuan(MultipartFile ufile, Model model, HttpServletRequest request, @Valid Book book, BindingResult bookResult) {
        if (bookResult.hasErrors()) {
            return "book_input";
        }

        List<String> errors = new ArrayList<>();
        if (ufile.isEmpty()) {
            errors.add("文件为空错误");
        }
        if (ufile.getSize() > 1024 * 1024 * 5) {
            errors.add("文件超出大小，请重新选择！");
        }
        if (!ufile.getContentType().contains("image/")) {
            errors.add("只允许上传图片文件！");
        }
        if (!errors.isEmpty()) {
            model.addAttribute("errs", errors);
            return "book_input";
        }

        // 获取今天时间
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = LocalDateTime.of(2018, 10, 12, 22, 1, 1);

        // 格式化时间
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
        LocalDateTime.now().format(dtf);


        String basePath = request.getServletContext().getRealPath("/img");

        String relativePath; // 图片的保存路径
        try {
            relativePath = makeRelativePath(ufile.getOriginalFilename());
            File target = new File(basePath + relativePath);
            target.getParentFile().mkdir();
            ufile.transferTo(target);
        } catch (IOException e) {
            model.addAttribute("err", "文件上传失败，请重试！");
            return "book_input";
        }

        book.setCover(relativePath);
        try {
            System.out.println("对" + book + "进行保存等操作");
        } catch (Exception e) {
            // 实际业务中，要考虑异常的处理
            model.addAttribute("err", "something");
            return "book_input";
        }
        return "book_home";
    }

    public String makeRelativePath(String fileName) {
        Date now = new Date();
        String[] fileNames = splitFileString(fileName);
        return String.format("%s%s%supload_%s_%s.%s",
                File.separator,
                new SimpleDateFormat("yyyyMMdd").format(now),
                File.separator,
                fileNames[0],
                new SimpleDateFormat("hhmmss").format(now),
                fileNames[1]
        );
    }

    public String[] splitFileString(String fileName) {
        int dotPos = fileName.lastIndexOf(".");
        String ext = fileName.substring(dotPos + 1);
        String name = fileName.substring(0, dotPos);
        return new String[]{name, ext};
    }
}
