package com.zwo.pls.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.Map;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/8/9
 */
public class CoreUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
    final String USER = "user";

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> response = (Map<String, Object>) super.convertUserAuthentication(authentication);
        response.put("user",authentication.getPrincipal());
        return response;
    }
}
