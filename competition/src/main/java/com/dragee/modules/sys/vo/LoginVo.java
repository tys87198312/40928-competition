package com.dragee.modules.sys.vo;

import lombok.ToString;

/**
 * @author tys on 11/11/20
 */
@ToString
public class LoginVo {
    private String username;
    private String password;
    private String clientId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
