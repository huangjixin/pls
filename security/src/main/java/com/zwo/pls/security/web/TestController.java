package com.zwo.pls.security.web;

import com.zwo.pls.security.service.IUserService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
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
//    private static Logger logger = LogManager.getLogger(TestController.class);

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
//        logger.log("测试打印");
        return  "hello,huang";
    }

    @GetMapping("throwexception")
    public String throwexception(HttpSession httpSession) throws Exception{
        if( 1==1){
            throw new Exception("报错了");
        }
        return  "hello,huang";
    }
}
