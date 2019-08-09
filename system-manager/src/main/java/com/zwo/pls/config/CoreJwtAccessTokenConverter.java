package com.zwo.pls.config;


import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/8/9
 */
public class CoreJwtAccessTokenConverter extends JwtAccessTokenConverter {

    private AccessTokenConverter tokenConverter = new CoreAccessTokenConverter();

    /**
     * @param tokenConverter the tokenConverter to set
     */
    @Override
    public void setAccessTokenConverter(AccessTokenConverter tokenConverter) {
        super.setAccessTokenConverter(tokenConverter);
        this.tokenConverter = tokenConverter;
    }

    /**
     * @return the tokenConverter in use
     */
    @Override
    public AccessTokenConverter getAccessTokenConverter() {
        return tokenConverter;
    }


    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        return tokenConverter.convertAccessToken(token, authentication);
    }

    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
        return tokenConverter.extractAccessToken(value, map);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        return tokenConverter.extractAuthentication(map);
    }
}
