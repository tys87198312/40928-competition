package com.dragee.utils;

import com.dragee.constants.Identity;
import com.dragee.modules.sys.entity.LoginUser;
import org.apache.shiro.SecurityUtils;

/** 获取当前登陆人工具类 必须用户登陆后才可以
 * @author tys on 11/27/20
 */
public class LoginUserUtil {
    public static LoginUser getLoginUser () {
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        return loginUser;
    }

    public static Long getLoginUserId () {
        try {
            return LoginUserUtil.getLoginUser().getUserId();
        } catch (NullPointerException e) {
            return null;
        }
    }
    public static String getLoginName () {
        try {
            return LoginUserUtil.getLoginUser().getName();
        } catch (NullPointerException e) {
            return null;
        }
    }
    public static Identity getLoginIdentity () {
        String clientId = getLoginUser().getClientId();
        if (clientId.equals("wcc_app")) {
            return Identity.WCC_APP;
        } else if (clientId.equals("wcc_pc")) {
            return Identity.WCC_PC;
        } else if (clientId.equals("wops")) {
            return Identity.WOPS;
        } else {
            return Identity.UNKNOW;
        }
    }


}
