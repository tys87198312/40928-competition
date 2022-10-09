package com.dragee.config.shiro;

import cn.hutool.json.JSONUtil;
import com.dragee.common.R;
import com.dragee.config.exception.AuthErrorType;
import com.dragee.utils.HttpContextUtils;
import com.dragee.utils.TokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import lombok.SneakyThrows;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义认证过滤器
 *
 * @author tys on 11/9/20
 */
public class AuthFilter extends AuthenticatingFilter {

    private JdbcTemplate jdbcTemplate;

    public AuthFilter (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 第一步拦截,  true 直接放行
     *            false 转入到onAccessDenied
     */
    @SneakyThrows
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if(((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())){
            return true;
        }
        return false;
    }

    /**　
     *   第二步
     *   false 请求结束
     *   true 进入到业务controller
     *   核心: 调用executeLogin, 并不是真正的login, 本质还是调用subject.login(token) 到Realm去做认证, 返回true认证通过, 访问controller
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // 设置response
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
        httpResponse.setHeader("content-type", "text/html;charset=utf-8");

        // 从请求里获取token
        String token = TokenUtil.getToken((HttpServletRequest) request);
        // token 为null不通过
        String result = "";
        if (token == null) {
//            HttpServletRequest req = (HttpServletRequest) request;
//            P.yellow(req.getRequestURL().toString());
            result = JSONUtil.toJsonStr(R.error(AuthErrorType.NO_TOKEN));
            response.getWriter().println(result);
            return false;
        }

        // TokenUtil.checkToken(token);
        try {
            Jwts.parserBuilder().setSigningKey(TokenUtil.key).build().parse(token);
        } catch (SignatureException e) {
            result = JSONUtil.toJsonStr(R.error(AuthErrorType.SIGNATURE_ERROR));
            response.getWriter().println(result);
            return false;
        } catch (ExpiredJwtException e) {
            result = JSONUtil.toJsonStr(R.error(AuthErrorType.TOKEN_EXPIRED));
            response.getWriter().println(result);
            return false;
        }



//        Set<String> keys = RedisUtil.keys(RamKey.TOKEN + "*");
//        List<String> tokens = keys.stream().map(k -> (String) RedisUtil.get(k)).collect(Collectors.toList());
//
//        if (!tokens.contains(token)) {
//            String result = JSONUtil.toJsonStr(R.error(AuthErrorType.INVAIL_TOKEN));
//            response.getWriter().println(result);
//            return false;
//        }



        // 核心!!!  执行认证 底层调用subject.login(token) 建议点进去看下源码
        return executeLogin(request, response);
    }

    /** executeLogin 会调用此方法
     *  不是创建token 而是从请求获取我们传入的token 并包装为自定义的AuthToken对象 返回
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        String token = TokenUtil.getToken((HttpServletRequest) request);
        return new AuthToken(token);
    }

}
