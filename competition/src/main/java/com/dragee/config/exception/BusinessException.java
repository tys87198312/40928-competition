package com.dragee.config.exception;

import lombok.Getter;

/**　自定义异常类
 * @author tys on 11/2/20
 */
@Getter
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException(BusinessErrorType type) {
        super(type.getMsg());
        this.code = type.getCode();
    }

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode () {
        return this.code;
    }
}
