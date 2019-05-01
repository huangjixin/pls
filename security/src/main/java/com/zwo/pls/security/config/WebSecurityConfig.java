/**
 *
 */
package com.zwo.pls.security.config;

import com.zwo.pls.security.service.impl.UserServiceDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author 黄记新
 *
 */
@Configuration
@EnableWebSecurity
//@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceDetailImpl userServiceDetail;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /* http自定义配置 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/**")
//                .permitAll();
        http.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/**").permitAll().and().authorizeRequests()
                .antMatchers("/**").permitAll();
        // 放行的请求
                /*.antMatchers(
                        "/login/**",
                        // Oauth2
                        "/oauth/token",
                        // swagger
                        "/swagger-ui.html",
                        "/webjars/springfox-swagger-ui/**",
                        "/swagger-resources/**",
                        "/v2/api-docs"
                ).permitAll()
                // 其他所有请求，需要认证
                .anyRequest().authenticated();*/
    }

    /* 认证管理器配置 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* 配置UserDetailsService及密码规则 */
        auth.userDetailsService(userServiceDetail).passwordEncoder(passwordEncoder());
    }

    /* 声明密码的规则 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
