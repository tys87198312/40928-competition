package com.dragee.modules.sys.vo;

import com.dragee.config.NotNull;
import lombok.ToString;

/**
 * @author tys on 11/11/20
 */
@ToString
public class LoginPwdVo {
    @NotNull("用户名")
    private String username;
    @NotNull("密码")
    private String password;
    @NotNull("客户端ID")
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
