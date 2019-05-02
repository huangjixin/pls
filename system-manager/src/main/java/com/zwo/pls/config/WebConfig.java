package com.zwo.pls.config;


import com.zwo.pls.core.converter.CustomLocalDateConverter;
import com.zwo.pls.core.converter.CustomYearMonthConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问。
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .allowCredentials(true);
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
////        corsConfiguration.addExposedHeader("head1");
//        //corsConfiguration.addExposedHeader("Location");
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        // 设置允许跨域的路径
//        registry.addMapping("/**")
//                // 设置允许跨域请求的域名
//                .allowedOrigins("*")
//                // 是否允许证书 不再默认开启
//                .allowCredentials(true)
//                // 设置允许的方法
//                .allowedMethods("*")
//                // 跨域允许时间
//                .maxAge(360000000);
//    }

//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        /*是否允许请求带有验证信息*/
//        corsConfiguration.setAllowCredentials(true);
//        /*允许访问的客户端域名*/
//        corsConfiguration.addAllowedOrigin("*");
//        /*允许服务端访问的客户端请求头*/
//        corsConfiguration.addAllowedHeader("*");
//        /*允许访问的方法名,GET POST等*/
//        corsConfiguration.addAllowedMethod("*");
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
    }

    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        // 自定义配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);

        // 字符编码
        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);

        converter.setSupportedMediaTypes(mediaTypeList);
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(1, converter);
    }*/

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 添加自定义参数绑定转换器
        registry.addConverter(new CustomLocalDateConverter());
        registry.addConverter(new CustomYearMonthConverter());
    }
}
