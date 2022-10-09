package com.dragee.modules.sys.vo;

import com.dragee.config.NotNull;
import lombok.ToString;

/**
 * @author tys on 11/11/20
 */
@ToString
public class RegisteredVo {
    @NotNull("手机号")
    private String username;
    @NotNull("账号")
    private String name;
    @NotNull("客户端ID")
    private String clientId;
    @NotNull("密码")
    private String password;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
