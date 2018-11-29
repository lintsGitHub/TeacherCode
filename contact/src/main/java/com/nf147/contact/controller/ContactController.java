package com.nf147.contact.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nf147.contact.dao.ContactMapper;
import com.nf147.contact.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class ContactController {

    @Autowired
    private ContactMapper contactMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String home (@RequestParam(defaultValue = "1") int page, Model model) {
        PageHelper.startPage(page, 2);
        List<Contact> contacts = contactMapper.selectAll();
        model.addAttribute("contacts", contacts);
        model.addAttribute("pageInfo", new PageInfo<>(contacts));
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create (Contact contact) {
        contactMapper.insert(contact);
        return "redirect:/";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String delete (@PathVariable("id") int id) {
        contactMapper.deleteByPrimaryKey(id);
        return "redirect:/";
    }
}
