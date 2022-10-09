/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.dragee.config.dynamicDataSource;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源
 *
 * @author tys on 10/27/20
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public DynamicDataSource(){}
    /**
     * 多数据源基础设置 ， 设置默认数据源 设置所有数据源
     * @param defalutSource
     * @param tagetDataSource
     */
    public DynamicDataSource (DataSource defalutSource, Map<String, DataSource> tagetDataSource) {
        super.setDefaultTargetDataSource(defalutSource);
        super.setTargetDataSources(new HashMap<>(tagetDataSource));
        super.afterPropertiesSet();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return getDateSouce();
    }
    public static void setDataSource(String dataSource){
        contextHolder.set(dataSource);
    }
    public static String getDateSouce(){
        return contextHolder.get();
    }
    public static void removeDataSource(){
        contextHolder.remove();
    }
}

