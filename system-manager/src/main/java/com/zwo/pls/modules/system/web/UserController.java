package com.zwo.pls.modules.system.web;

import com.zwo.pls.core.web.BaseController;
import com.zwo.pls.modules.system.domain.User;
import com.zwo.pls.modules.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/30
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @GetMapping("test")
    public User test(){
        User user = userService.selectByPrimaryKey("1");
        return  user;
    }

    @PreAuthorize("hasAnyAuthority('*', 'sys:user:test')")
    @GetMapping("testoauth")
    public String testoauth(){
        User user = userService.selectByPrimaryKey("1");
        return  "你已经成功进入受保护的方法，得到user："+user.toString();
    }

    @PreAuthorize("hasAnyAuthority('*', 'sys:user:getLoginName')")
    @GetMapping("getLoginName")
    public String getLoginName(){
       String loginName = super.getLoginUser();
        return  loginName;
    }

    @PreAuthorize("hasAnyAuthority('*', 'sys:user:getAuthorities')")
    @GetMapping("getAuthorities")
    public Collection<SimpleGrantedAuthority> getAuthorities(){
        Collection<SimpleGrantedAuthority> authorities = super.getAuthorities();
        return  authorities;
    }

    @GetMapping("getClaims")
    public String getClaims(@RequestParam String token){
        Jwt jwt = JwtHelper.decode(token);
        String claims = jwt.getClaims();
        return  claims;
    }

    @GetMapping("insertBatch")
    public int insertBatch(){
        int result = -1;
        List<User> list = new ArrayList<User>();
        User user = null;
        for (int i=0;i<10000;i++){
            user = new User();
            user.setId(UUID.randomUUID().toString().replaceAll("-",""));
            user.setLoginName(UUID.randomUUID().toString().replaceAll("-",""));
            user.setPassword("$10$jre6mb1sNNUqUGbZTiUMUe9aBz774m777nWcABBEj0feARudyIUuu");
        }
        result = this.userService.insertBatch(list);
        return  result;
    }
}
