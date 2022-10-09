package com.dragee.config.dynamicDataSource;

import com.dragee.common.P;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/** 切换数据源
 * @author tys on 10/27/20
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    @Override
    public int getOrder() {
        return 1;
    }
    @Pointcut("@annotation(com.dragee.config.dynamicDataSource.DataSource)")
    public void dataSourceCut () {}

    @Around("dataSourceCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        if(ds == null){
            DynamicDataSource.setDataSource(DataSourceType.mysql);
            System.out.println("set datasource is " + DataSourceType.mysql);
        }else {
            DynamicDataSource.setDataSource(ds.value());
            P.cyan("当前数据源: " + DynamicDataSource.getDateSouce());
        }
        try{
            return point.proceed();
        } finally {
            DynamicDataSource.removeDataSource();
            // System.out.println("clean dataSource");
        }
    }
}
