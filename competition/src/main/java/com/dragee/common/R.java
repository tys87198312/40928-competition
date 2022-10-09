package com.dragee.common;


import com.dragee.config.exception.AuthErrorType;

import java.util.HashMap;
import java.util.Map;

/** 返回值的包装类 请使用　code msg data　作为ｋｅｙ
 * @author tys on 10/23/20
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 200);
        put("msg", "操作成功");
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error(AuthErrorType type) {
        R r = new R();
        r.put("code", type.getCode());
        r.put("msg", type.getMsg());
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
    public R println () {
        System.out.println("app返回结果： "+ this);
        return this;
    }
}

