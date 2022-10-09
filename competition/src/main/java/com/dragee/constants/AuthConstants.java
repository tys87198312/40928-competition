package com.dragee.constants;

/**
 * 权限相关常量类
 */
public interface AuthConstants {
    /**
     * 认证信息Http请求头
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    long TOKEN_EXPIRE = 1000 * 60 * 60 * 24 * 3;

    /**
     * JWT签名
     */
    String JWT_SIGN = "JdL6sB4OXKU6wc3ZL2KLULzBCcbfzCg6sD5xNoPp8Oc=";

    /**
     * 密码的盐值加密
     */
    String SLAT_PWD = "qimvKuGaL8yNdL8vSi7Z";

    String[] CLIENTS = {"common"};

    String[] ACCESS_CLIENTS = {"sanht"};

    /**
     * token过期时间单位天
     */
    int JWT_EXPRIED_TIME = 7;
}
