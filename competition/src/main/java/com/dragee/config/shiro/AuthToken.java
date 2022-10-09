package com.dragee.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/** 自定义的token类
 * @author tys on 11/9/20
 */
public class AuthToken implements AuthenticationToken {

    private String token;

    public AuthToken (String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public String getCredentials() {
        return token;
    }

    public String getToken() {
        return token;
    }
}
