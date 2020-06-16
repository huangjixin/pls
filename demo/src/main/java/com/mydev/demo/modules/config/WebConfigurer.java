package com.mydev.demo.modules.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;

/**
 * 黄记新，2020.05.27
 * 拦截器
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginInterceptor loginInterceptor;

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**/*.png")
//                .addResourceHandler("/**/*.png")
//                .addResourceHandler("/**/*.png")
//                .addResourceHandler("/**/*.png");
        super.addResourceHandlers(registry);
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
//        interceptorRegistration.addPathPatterns("/**")
//                .excludePathPatterns("/logout","/","/login", "/**/*.css",
//                        "/**/*.js", "/**/*.png", "/**/*.jpg",
//                        "/**/*.jpeg", "/**/*.gif", "/**/fonts/*");

    }
}