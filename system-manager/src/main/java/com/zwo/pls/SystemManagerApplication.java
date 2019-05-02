package com.zwo.pls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = {"com.zwo.pls.modules.*.mapper"})
public class SystemManagerApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SystemManagerApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(SystemManagerApplication.class, args);
    }

}
