package com.zwo.pls.security.web;

import com.zwo.pls.security.domain.User;
import com.zwo.pls.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/30
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private IUserService userService;

    @GetMapping("setsession")
    public String setsession(HttpSession httpSession){
        httpSession.setAttribute("username","huangjixin");
        return  "设置session成功，username:huangjixin";
    }

    @GetMapping("getsession")
    public String getsession(HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        return  username;
    }

    @GetMapping("clearsession")
    public String clearsession(HttpSession httpSession){
        httpSession.removeAttribute("username");
        return  "移除session成功";
    }

    @GetMapping("hello")
    public String hello(HttpSession httpSession){
        return  "hello,huang";
    }
}
