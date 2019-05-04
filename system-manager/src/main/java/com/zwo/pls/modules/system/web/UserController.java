package com.zwo.pls.modules.system.web;

import com.zwo.pls.core.web.BaseController;
import com.zwo.pls.modules.system.domain.User;
import com.zwo.pls.modules.system.domain.UserCriteria;
import com.zwo.pls.modules.system.service.IUserService;
import com.zwo.pls.modules.system.vo.UserVo;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/4/30
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    @Lazy(value=true)
    CompositeCacheManager cacheManger;

//    @Resource(name="ehcacheCacheManager")
//    @Lazy(value=true)
//    CacheManager cacheManger1;

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

    @GetMapping("selectByUserName")
    public UserVo selectByUserName(@RequestParam String loginName) {
        UserVo userVo = null;

        // 使用缓存
        if(cacheManger != null){
            Cache cache = null;
            try {
                cache = cacheManger.getCache("UserVo");
            } catch (Exception e) {

            }
            if(cache != null){
                Cache.ValueWrapper wrapper =  cache.get(loginName);
                userVo = (UserVo) wrapper.get();
                UserVo uVo = cache.get(loginName,UserVo.class);
            }

        }

        if (userVo == null) {
            userVo = this.userService.selectByUserName(loginName);
            // 使用缓存
            if(cacheManger != null && userVo != null){
                Cache cache = null;
                try {
                    cache = cacheManger.getCache("UserVo");
                } catch (Exception e) {

                }
                if(cache != null)
                    cache.put(loginName,userVo);
            }
        }
        return userVo;
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

    @GetMapping("selectByExamplePage")
    List<UserVo> selectByExamplePage(HttpServletRequest request, @RequestParam(required = false,defaultValue = "0") Integer start, @RequestParam(required = false,defaultValue = "10")Integer size){
        UserCriteria example = this.getCriteria(request);
        List<UserVo> list = this.userService.selectByExamplePage(example,start,size);
        return list;
    }

    private UserCriteria getCriteria(HttpServletRequest request) {
        UserCriteria example = null;
        if (request.getParameterNames().hasMoreElements()) {
            example = new UserCriteria();
            UserCriteria.Criteria criteria = example.createCriteria();
            String loginName = request.getParameter("loginName");
            if (StringUtils.isNotEmpty(loginName)) {
                criteria.andLoginNameLike("%"+loginName+"%");
            }
//            Date createTime = request.getParameter("createTime");
//            if (StringUtils.isNotEmpty(loginName)) {
//                criteria.andLoginNameLike("%"+loginName+"%");
//            }
        }
        return example;
    }
}
