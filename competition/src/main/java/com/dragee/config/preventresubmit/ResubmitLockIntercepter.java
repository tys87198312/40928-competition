package com.dragee.config.preventresubmit;

import com.dragee.common.R;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class ResubmitLockIntercepter {
    //定义缓存，设置最大缓存数及过期日期
    private static final Cache<String,Object> CACHE = CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(20, TimeUnit.SECONDS).build();

    @Around("execution(public * *(..))  && @annotation(com.dragee.config.preventresubmit.LocalResubmitLock)")
    public Object interceptor(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LocalResubmitLock localResubmitLock = method.getAnnotation(LocalResubmitLock.class);
        String key = getKey(localResubmitLock.key(),joinPoint.getArgs());
        if(!StringUtils.isEmpty(key)){
            if(CACHE.getIfPresent(key) != null){
                return R.error("请勿重复提交");
            }
            CACHE.put(key,key);
        }
        try{
            return joinPoint.proceed();
        }catch (Throwable throwable){
            throw new RuntimeException("服务器异常");
        }finally {

        }
    }

    private String getKey(String keyExpress, Object[] args){
        for (int i = 0; i < args.length; i++) {
            keyExpress = keyExpress.replace("target[" + i + "]", args[i].toString());
        }
        return keyExpress;
    }
}
