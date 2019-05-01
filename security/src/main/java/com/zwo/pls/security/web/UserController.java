package com.zwo.pls.security.web;

import com.zwo.pls.security.domain.User;
import com.zwo.pls.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/30
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("test")
    public User test(){
        User user = userService.selectByUserName("1");
        return  user;
    }
}
