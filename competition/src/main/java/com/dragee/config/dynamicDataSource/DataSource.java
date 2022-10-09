package com.dragee.config.dynamicDataSource;

import java.lang.annotation.*;

/** 数据源选择
 * @author tys on 10/27/20
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.METHOD)
public @interface DataSource {
    String value() default "mysql";
}

