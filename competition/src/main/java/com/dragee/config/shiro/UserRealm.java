package com.dragee.config.shiro;

import com.dragee.config.exception.AuthErrorType;
import com.dragee.config.exception.AuthException;
import com.dragee.modules.sys.entity.LoginUser;
import com.dragee.utils.TokenUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author tys on 11/6/20
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /** 认证
     *  这里的token就是调用 subject.login(token)传入的token
     *
     *  此处用于解析token, 并认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 强转我们自定义的token
        String token = ((AuthToken)authenticationToken).getToken();
        if (token == null) {
            throw new AuthException(AuthErrorType.NO_LOGIN);
        }
//        // token 和数据库比对
//        int size = this.jdbcTemplate.queryForList("select *\n" +
//                "from t_base_token where invalidTime > now() and token = '" + token + "' ").size();
//        if (size == 0) {
//            throw new CustomException(ExceptionType.INVAIL_TOKEN);
//        }
        // 将token内的用户对象解析出来
        LoginUser loginUser = TokenUtil.parseToken(token);

        // 最终认证, 之后我们可以使用 LoginUser user = (LoginUser)SecurityUtils.getSubject().getPrincipal(); 获取当前认证的用户
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginUser, token, getName());
        return info;
    }

    /** 授权, 访问资源进入
     * 1、subject.hasRole(“admin”) 或 subject.isPermitted(“admin”)：自己去调用这个是否有什么角色或者是否有什么权限的时候；
     * 2、@RequiresRoles("admin") ：在方法上加注解的时候；
     * 3、[@shiro.hasPermission name = "admin"][/@shiro.hasPermission]：在页面上加shiro标签的时候，即进这个页面的时候扫描到有这个标签的时候。
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LoginUser user = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    /** 配置支持自定义AuthToken验证,
     * 不配置的话, 用自定义的token认证 不会生效
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }


}
