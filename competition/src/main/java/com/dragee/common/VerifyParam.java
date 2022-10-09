package com.dragee.common;

import com.dragee.config.NotNull;
import com.dragee.config.exception.BusinessException;

import java.lang.reflect.Field;

/**
 * 校验参数
 *
 * @author tys on 2021/5/8
 */
public class VerifyParam {

    public static <T> void notNull (T t){
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field:fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value == null || value == "") {
                    NotNull notNull = field.getAnnotation(NotNull.class);
                    notNull.value();
                    throw new BusinessException(501, notNull.value() + "不能为空");
                }
            }
        }
    }
}
