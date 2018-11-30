package com.nf147.ssms.controller.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ContainerHelper {
    @Autowired
    private WebApplicationContext context;

    @GetMapping("/ioc")
    @ResponseBody
    public HashMap<String, Object> status(HttpServletRequest request, HttpSession session) {
        ArrayList<String> reqAttrs = new ArrayList<>();
        Enumeration<String> reqNames = request.getAttributeNames();
        while (reqNames.hasMoreElements()) reqAttrs.add(reqNames.nextElement());

        ArrayList<String> sessAttrs = new ArrayList<>();
        Enumeration<String> sessNames = session.getAttributeNames();
        while (sessNames.hasMoreElements()) sessAttrs.add(sessNames.nextElement());

        return new HashMap<String, Object>() {{
            put("子容器", context.getBeanDefinitionNames());
            put("父容器", Objects.requireNonNull(context.getParent()).getBeanDefinitionNames());
            put("request", reqAttrs);
            put("session", sessAttrs);
        }};
    }

    @GetMapping("/session/{key}:{value}")
    @ResponseBody
    public ArrayList<String> setSession (@PathVariable String key, @PathVariable String value, HttpSession session) {
        session.setAttribute(key, value);

        ArrayList<String> sessAttrs = new ArrayList<>();
        Enumeration<String> sessNames = session.getAttributeNames();
        while (sessNames.hasMoreElements()) sessAttrs.add(sessNames.nextElement());

        return sessAttrs;
    }
}
