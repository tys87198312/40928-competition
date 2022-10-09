package com.dragee.config.preventresubmit;

import java.lang.annotation.*;

/**
 * @author 28251
 * 防止重复提交的注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalResubmitLock {
    String key() default "";
}
