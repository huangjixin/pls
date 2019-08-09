package com.zwo.pls.config;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.Map;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/8/9
 */
public class CoreAccessTokenConverter extends DefaultAccessTokenConverter {

    private UserAuthenticationConverter userTokenConverter = new CoreUserAuthenticationConverter();

    /**
     * Converter for the part of the data in the token representing a user.
     *
     * @param userTokenConverter the userTokenConverter to set
     */
    @Override
    public void setUserTokenConverter(UserAuthenticationConverter userTokenConverter) {
        super.setUserTokenConverter(userTokenConverter);
        this.userTokenConverter = userTokenConverter;
    }

    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Map<String, Object> response = (Map<String, Object>) super.convertAccessToken(token,authentication);
        return response;
    }
}
