package com.dragee.config.resolver;

import com.dragee.modules.sys.entity.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * LoginUser处理器
 *
 * @author tys on 11/2/20
 */
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    /** 设置支持, 对象类型为LoginUser 并有User注解
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(LoginUser.class) && parameter.hasParameterAnnotation(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        return loginUser;
    }

}
