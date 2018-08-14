package com.example.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by chenpei on 2018-08-10.
 */
@Controller
public class JspController {

    @GetMapping("/helloTest")
    public String helloTest(ModelMap m){
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }

//    @Value("${application.message}")
//    private String message;


    @GetMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("time", System.currentTimeMillis());
        model.put("message", "test");
        return "welcome";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
