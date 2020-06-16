package com.mydev.demo.modules.system.service.impl;

import com.mydev.demo.DemoApplication;
import com.mydev.demo.modules.system.domain.User;
import com.mydev.demo.modules.system.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestUserServiceImpl {
    @Autowired
    private IUserService userService;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setEmail("517714860@qq.com");
        int result = userService.insert(user);
        System.out.println(result);
    }
}
