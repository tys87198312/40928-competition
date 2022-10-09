package com.dragee.config.async;

import com.dragee.modules.base.entity.ErrorLogEntity;
import com.dragee.modules.base.entity.LoginLogEntity;
import com.dragee.modules.base.service.ErrorLogService;
import com.dragee.modules.base.service.LoginLogService;
import com.dragee.modules.sys.entity.LoginUser;
import com.dragee.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 异步任务
 *
 * @author tys on 11/2/20
 */
@Component
public class AsyncTask {
    /**
     * 错误日志
     */
    @Autowired
    private ErrorLogService baseErrorLogService;
    @Autowired
    private LoginLogService loginLogService;


    @Async
    public void errorLog(int errorCode, String errorMsg, HttpServletRequest req) {
        ErrorLogEntity errorLog = new ErrorLogEntity();
        LoginUser user = LoginUserUtil.getLoginUser(); // 获取登录人信息
        if (user != null) {
            errorLog.setClientId(user.getClientId());
            errorLog.setLoginUser(user.getName()); // 用户名
        }
        errorLog.setParams(req.getQueryString()); // 获取接口参数
        errorLog.setUrl(req.getRequestURI()); // 获取接口路径
        errorLog.setMethod(req.getMethod()); // 获取提交方式
        errorLog.setErrorCode(errorCode);
        errorLog.setErrorMsg(errorMsg);
        baseErrorLogService.save(errorLog);
    }





    @Async
    public void loginLog(String clientId, String name) {
        LoginLogEntity loginLog = new LoginLogEntity();
        loginLog.setClientId(clientId);
        loginLog.setOperator(name);
        loginLog.setOperatorTime(new Date());
        loginLogService.save(loginLog);
    }




}
