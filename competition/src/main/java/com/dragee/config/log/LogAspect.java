package com.dragee.config.log;

import cn.hutool.json.JSONUtil;
import com.dragee.common.P;
import com.dragee.modules.sys.entity.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/** 统一请求日志 包含 接口名 参数 返回值 耗时
 * @author tys on 10/23/20
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    private String normalLog_pre = "";

    /** 切点一
     *  目标 net.robot.modules.你的模块.controller 目录下的所有类的public方法
     */
    @Pointcut("execution(public * com.dragee.modules.*.controller.*.* (..))")
    public void logPoint1 () {}

    @Pointcut("execution(public * com.dragee.*.controller.*.* (..))")
    public void logPoint2 () {}

    @Pointcut("@annotation(com.dragee.config.log.SysLog)")
    public void logPoint3 () {}

    @Pointcut("logPoint1() || logPoint2() || logPoint3()")
    public void logPoint () {}


    /** 常规日志 可以打印 接口路径, 返回值, 参数 , 接口耗时 抛出异常
     * @param point
     * @return
     */
    @Around("logPoint()")
    public Object normalLogAround (ProceedingJoinPoint point) throws Throwable {
        Long start = System.currentTimeMillis();
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object obj = null;
        if ("/error".equals(req.getRequestURI()))  {
            obj = point.proceed();
        } else {
            System.out.println();
            P.white("[");
            P.green("   接口:    " + req.getRequestURI());
            P.green("   提交方式:    " + req.getMethod());
            Arrays.asList(point.getArgs()).forEach(arg -> {
                if (arg !=null && !(arg instanceof LoginUser)) {
                    P.green("   参数:    " + arg.toString());
                }
            });
            obj = point.proceed();
            Long end = System.currentTimeMillis() - start;
            P.green("   耗时:    " + end + "ms");
            // P.green("   返回值:    " + JSONUtil.parse(obj).toStringPretty());
            if (obj != null) {
                P.green("   返回值:    " + JSONUtil.parse(obj).toString());
            }
            P.white("]");
        }
        return obj;
    }

    /** 常规日志 可以打印 接口路径, 返回值, 参数 , 接口耗时
     * @param point
     * @return
     */
//    @Around("logPoint()")
//    public Object normalLogAround (ProceedingJoinPoint point) {
//        Long start = System.currentTimeMillis();
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        Object obj = null;
//        try {
//            if ("/error".equals(req.getRequestURI()))  {
//                obj = point.proceed();
//            } else {
//                System.out.println();
//                log.info("{}---------------------------------------------------------------------------------------", normalLog_pre);
//                log.info("{}接口 : {}", normalLog_pre, req.getRequestURI());
//                log.info("{}参数 : {}", normalLog_pre, point.getArgs());
//                obj = point.proceed();
//                log.info("{}返回值 : {}", normalLog_pre, obj);
//                log.info("{}耗时 : {}ms", normalLog_pre, System.currentTimeMillis() - start);
//                log.info("{}---------------------------------------------------------------------------------------", normalLog_pre);
//            }
//        } catch (Throwable throwable) {
//            log.error("{}异常 : {} ", normalLog_pre, throwable.getMessage());
//            log.info("{}---------------------------------------------------------------------------------------", normalLog_pre);
//        } finally {
//            return obj;
//        }
//    }


}
