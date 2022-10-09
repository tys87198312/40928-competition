package com.dragee.config.exception;

import lombok.Getter;

/**　权限异常类
 * @author tys on 11/2/20
 */
@Getter
public class AuthException extends RuntimeException {

    private int code;

    public AuthException(AuthErrorType type) {
        super(type.getMsg());
        this.code = type.getCode();
    }

    public AuthException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
