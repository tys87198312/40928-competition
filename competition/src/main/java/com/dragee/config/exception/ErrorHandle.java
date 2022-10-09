package com.dragee.config.exception;

import com.dragee.common.P;
import com.dragee.common.R;
import com.dragee.config.async.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/** 做统一异常返回, 并处理异常
 * @author tys on 11/2/20
 */
@ControllerAdvice
@Slf4j
public class ErrorHandle {

    @Autowired
    private AsyncTask asyncTask;



    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public R handle (BusinessException e, HttpServletRequest req) {
        P.red("   异常:  BusinessException 异常码: " + e.getCode() + "    异常提示: " + e.getMessage());
        P.white("]");
        // 增加错误日志
        // asyncTask.errorLog(e.getCode(),e.getMessage(), req);
        return R.error(e.getCode(), e.getMessage());
    }
    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public R handle (AuthException e, HttpServletRequest req) {
        P.red("   异常:  AuthException 异常码: " + e.getCode() + "    异常提示: " + e.getMessage());
        P.white("]");
        // 增加错误日志
        // asyncTask.errorLog(e.getCode(),e.getMessage(), req);
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(IOException.class)
    @ResponseBody
    public R handle (IOException e, HttpServletRequest req) {
        P.red("   异常:  IOException   异常提示: " + e.getMessage());
        e.printStackTrace();
        P.white("]");
       //  asyncTask.errorLog(500,e.getMessage(), req);
        return R.error(500, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R handle (Exception e, HttpServletRequest req) {
        P.red("   异常:  " + e.getMessage());
        e.printStackTrace();
        P.white("]");
        // asyncTask.errorLog(500,e.getMessage(), req);
        return R.error(500, "未知异常, 请联系管理员");
    }



}
