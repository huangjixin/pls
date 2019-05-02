package com.zwo.pls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create by Yuanquan.Liu on 2018/9/12
 */
@Configuration
@EnableSwagger2
@Profile({"dev"})
public class Swagger2Config {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("PLS演示项目APIs")
                .description("PLS演示项目后台API接口文档")
                .version("2.0.0").build();
    }

    @Bean
    public Docket createRestApi() {
        // 扫描共同包路径
        // RequestHandlerSelectors.basePackage("com.pt.award.modules.system.web")
        // 扫描共同实现的接口类，例如RestController.class
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }
}
