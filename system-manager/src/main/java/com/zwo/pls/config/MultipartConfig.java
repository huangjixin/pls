package com.zwo.pls.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Create by Yuanquan.Liu on 2018/5
 */
@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        // 文件大小限制
        multipartConfigFactory.setMaxFileSize("512KB");
        // 总上传数据总大小
        multipartConfigFactory.setMaxRequestSize("1024KB");
        // 上传路径
//        multipartConfigFactory.setLocation("/upload");
        return multipartConfigFactory.createMultipartConfig();
    }
}
