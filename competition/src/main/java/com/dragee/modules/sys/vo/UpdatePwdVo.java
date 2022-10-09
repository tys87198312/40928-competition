package com.dragee.modules.sys.vo;

import com.dragee.config.NotNull;
import lombok.ToString;

/**
 * @author tys on 11/11/20
 */
@ToString
public class UpdatePwdVo {
    @NotNull("用户名")
    private String username;
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
}
