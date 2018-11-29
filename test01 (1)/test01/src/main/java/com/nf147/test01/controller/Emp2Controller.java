package com.nf147.test01.controller;

import com.nf147.test01.dao.EmMapper;
import com.nf147.test01.entity.Book;
import com.nf147.test01.entity.Emp;
import com.nf147.test01.vo.FormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/emp2")
public class Emp2Controller {
    @Autowired
    private EmMapper emMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model, Locale locale) {
        model.addAttribute("formBean", new FormBean());
        List<Emp> empList = emMapper.selectAll();
        model.addAttribute("empList", empList);
        return "index3";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@Valid FormBean fb, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("err", result.getAllErrors());
            return "index3";

        }
        int c = emMapper.add(fb.getEmps());
        return "redirect: /emp2";
    }

    @RequestMapping("/xx")
    @ResponseBody
    public String xxx() {
        return "hello, world";
    }

    @RequestMapping("/del/{eId}")
    public String del(@PathVariable("eId") String eid) {
        emMapper.deleteByPrimaryKey(eid);
        return "redirect:/emp2";
    }

//////////////////////////////////////////////////////

    @Autowired
    private LocaleResolver localeResolver;

    @GetMapping("/cl/{loc}")
    public String changeLocale (@PathVariable("loc") String localeStr, HttpServletRequest req, HttpServletResponse resp) {
        Locale locale = new Locale(localeStr);
        localeResolver.setLocale(req, resp, locale);
        return "redirect: /emp2";
    }

    @Autowired
    private ThemeResolver themeResolver;

    @GetMapping("/ct/{theme}")
    public String changeTheme (@PathVariable("theme") String theme, HttpServletRequest req, HttpServletResponse resp) {
        themeResolver.setThemeName(req, resp, theme);
        return "redirect: /emp2";
    }

    /////////////////////////////////

    @GetMapping("/aaa")
    @ResponseBody
    public Object aaa (Book book, BindingResult result) {
        if (result.hasErrors()) {
            return result.getAllErrors();
        }
        return String.valueOf(book);
    }

}