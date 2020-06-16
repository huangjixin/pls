package com.mydev.demo.modules.system.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄记新
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String defaultIndex(){
        return  home();
    }

    @GetMapping("/index")
    public String home(){
        return  "main";
    }

}
