package com.dragee.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 权限异常
 * @author tys on 11/2/20
 */
@Getter
@AllArgsConstructor
public enum AuthErrorType {

    /*权限 701 - 799*/
    USERNAME_OR_PASSWORD_ERROR(801, "用户名密码错误"),
    NO_TOKEN(802, "缺失Token"),
    INVAIL_TOKEN(803, "无效Token"),
    SIGNATURE_ERROR(806, "签名错误"),
    TOKEN_EXPIRED(806, "token过期"),
    NO_LOGIN(804, "用户未登陆"),
    PASSWORD_ERROR(805, "密码录入错误"),
    UPDATE_PASSWORD_ERROR(805, "修改密码失败"),
    BIND_TEL_ERROR(805, "绑定新手机失败"),
    USERNAME_NOT_REGISTERED(806, "用户未验证, 请验证"),
    SMS_CODE_ERROR(807, "短信验证码错误"),
    NO_AUTHORIZATION(705, "资源未授权"),
    NO_SUPPORT_CLIENT(706, "不支持的客户端"),
    USERNAME_PASSWORD_ERROR(707, "用户名或密码错误"),
    ;
    private int code;
    private String msg;

}
