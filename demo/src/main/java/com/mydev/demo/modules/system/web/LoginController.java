package com.mydev.demo.modules.system.web;

import com.mydev.demo.modules.system.domain.User;
import com.mydev.demo.modules.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Author:黄记新 2020.05.26
 * 登录控制器。
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;
//    @Autowired
//    private ILoginLogService loginLogService;

    @PostMapping("login")
    public String login(@RequestParam String username, @RequestParam String password,HttpServletRequest request,
                        HttpServletResponse response, HttpSession session, Model model) {
        Boolean validateResult = userService.validateUser(username, password);
        if (validateResult) {
            User user = userService.selectByPrimaryKey(username);
            session.setAttribute("user", user);

            String rememberMe = request.getParameter("remember-me");
            if(new Boolean(rememberMe)){
                Cookie cookie=new Cookie("username",username);
                cookie.setMaxAge(7 * 24 * 60 * 60); // 7天过期
//                cookie.setSecure(true);
                response.addCookie(cookie);
                cookie=new Cookie("password",password= DigestUtils.md5DigestAsHex(password.getBytes()));
                cookie.setMaxAge(7 * 24 * 60 * 60); // 7天过期
//                cookie.setSecure(true);
                response.addCookie(cookie);
            }

            /*LoginLog loginLog = new LoginLog();
            loginLog.setUsername(username+"-"+ UUID.randomUUID().toString().replaceAll("-",""));
            String ip = null;
            try {
                ip = this.getIp(request);
            }catch (Exception e){

            }

            loginLog.setIp(ip);
            loginLogService.insertSelective(loginLog);*/
        }
        return "redirect:/index";
    }

    @GetMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        /*ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        return mv;*/
        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.removeAttribute("user");
        Cookie cookie = new Cookie("username", null);
        //将`Max-Age`设置为0
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        cookie = new Cookie("password", null);
        //将`Max-Age`设置为0
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/login";
    }

    public String getIp(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(",");
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }
}
