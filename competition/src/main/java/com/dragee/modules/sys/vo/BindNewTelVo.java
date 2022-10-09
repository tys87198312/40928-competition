package com.dragee.modules.sys.vo;

import com.dragee.config.NotNull;
import lombok.ToString;

/**
 * @author tys on 11/11/20
 */
@ToString
public class BindNewTelVo {
    @NotNull("新用户名")
    private String newUserName;
    @NotNull("旧用户名")
    private String oldUserName;
    @NotNull("验证码")
    private String code;

    public String getNewUserName() {
        return newUserName;
    }

    public void setNewUserName(String newUserName) {
        this.newUserName = newUserName;
    }

    public String getOldUserName() {
        return oldUserName;
    }

    public void setOldUserName(String oldUserName) {
        this.oldUserName = oldUserName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
