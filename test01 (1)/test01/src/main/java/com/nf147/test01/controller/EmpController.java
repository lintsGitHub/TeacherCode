package com.nf147.test01.controller;

import com.nf147.test01.dao.EmMapper;
import com.nf147.test01.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmMapper emMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model) {
        List<Emp> empList = emMapper.selectAll();
        model.addAttribute("emList", empList);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody List<Emp> list) {
        int c = emMapper.add(list);
        if (c > 0)
            return "{\"msg\":\"ok\"}";
        return "{\"msg\":\"no\"}";
    }

    @RequestMapping("/del/{eId}")
    public String del(@PathVariable("eId") String eid) {
        emMapper.deleteByPrimaryKey(eid);
        return "redirect:/emp";
    }
}