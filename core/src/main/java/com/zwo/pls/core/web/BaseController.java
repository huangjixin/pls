package com.zwo.pls.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.validation.ValidationException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 基类控制器，将控制器行为做一个抽象
 *
 * @author Tony（黄记新） 2019.03.19
 */
public class BaseController {

    // 使用InitBinder来处理Date类型的参数
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    /**
     * 获取框架内当前登录用户名
     *
     * @return
     */
    protected String getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        } else {
            return null;
        }
    }

}
