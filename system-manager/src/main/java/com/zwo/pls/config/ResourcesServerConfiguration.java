package com.zwo.pls.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;


@Configuration
@EnableResourceServer
//@Order(-1)
public class ResourcesServerConfiguration extends ResourceServerConfigurerAdapter {
    private static Logger log = LogManager.getLogger(ResourcesServerConfiguration.class);

    @Resource(name="clientTokenStore")
    public TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/**")
//                .permitAll();

        http.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/**").permitAll().and().authorizeRequests()
                .antMatchers("/**").permitAll();
    }

    /* 资源服务器安全属性配置，与AuthorizationServer授权服务器匹配 */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        log.info("Configuring ResourceServerSecurityConfigurer");
        resources.resourceId("user").tokenStore(tokenStore);
    }

}
