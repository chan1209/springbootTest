package com.example.springboot.web;

import com.example.springboot.exception.MyException;
import com.example.springboot.utils.ExcelUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by chenpei on 2018-08-10.
 */
@RestController
public class HelloController {

//    @Value("${name}")
//    private String name;

//    @Autowired
//    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {

        return "Hello Spring Boot!";
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误213123");
    }

    @RequestMapping("/excel")
    public void excel(@RequestParam(value = "file", required = false) MultipartFile file){
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.getExcelRowsContent(file);
    }







    }
