package com.dragee.modules.sys.vo;

import com.dragee.config.NotNull;
import lombok.ToString;

/**
 * @author tys on 11/11/20
 */
@ToString
public class LoginSmsVo {
    @NotNull("用户名")
    private String username;
    @NotNull("验证码")
    private String verifyCode;
    @NotNull("客户端ID")
    private String clientId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
