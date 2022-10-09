package com.dragee.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/** shiro核心配置类
 * @author tys on 11/6/20
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /** anon 可以匿名访问
     *  authc 认证通过访问
     *  roles[manager,guest] 角色授权访问
     *  perms[add,query] 具有权限访问
     *  以上都是shiro内置的过滤器
     *
     *  自定义过滤器authToken
     * @param wsm
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean (@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager wsm) {
        // 设置SecurityManager
        ShiroFilterFactoryBean shiroFactoryBean = new ShiroFilterFactoryBean();
        shiroFactoryBean.setSecurityManager(wsm);
        // 自定义的过滤器
        Map<String, Filter> filterBeans = new HashMap<>();
        filterBeans.put("authToken",  new AuthFilter(jdbcTemplate));
        shiroFactoryBean.setFilters(filterBeans);

        Map<String, String> filters = new LinkedHashMap<>();

        filters.put("/login", "anon");   // 首页放行
        filters.put("/cloudControl/registered", "anon");   // 首页放行
        filters.put("/access-login", "anon");   // 首页放行
        filters.put("/cloudControl/login-pwd", "anon");   // 首页放行
        filters.put("/cloudControl/login-sms", "anon");   // 首页放行
        filters.put("/cloudControl/update-pwd", "anon");   // 首页放行
        filters.put("/cloudControl/verify-sms-code", "anon");   // 首页放行
        filters.put("/cloudControl/sms-code", "anon");   // 短信验证码
        filters.put("/cloudControl/pc/login-pwd", "anon");   // 首页放行
        filters.put("/cloudControl/pc/login-sms", "anon");   // 首页放行
        filters.put("/cloudControl/pc/update-pwd", "anon");   // 首页放行
        filters.put("/cloudControl/pc/verify-sms-code", "anon");   // 首页放行
        filters.put("/cloudControl/pc/registered", "anon");   // 首页放行
        filters.put("/cloudControl/pc/sms-code", "anon");   // 短信验证码
        filters.put("/rmt/**", "anon");   // 首页放行

        filters.put("/swagger/**", "anon");
        filters.put("/webjars/bycdao-ui/**", "anon");
        filters.put("/v2/**", "anon");
        filters.put("/swagger-ui.html", "anon");
        filters.put("/swagger-resources/**", "anon");
        filters.put("/doc.html", "anon");
        filters.put("/base/apk/download", "anon"); // 二维码下载


        filters.put("/cloudControl/common/privacy-agreement", "anon"); // 隐私协议
        filters.put("/file/**", "anon");
        filters.put("/cloudControl/file/**", "anon");
        filters.put("/demo/**", "anon");
        filters.put("/fms/cardebugargument/export-argument", "anon");
        // filters.put("/common/**", "anon");
        filters.put("/**", "authToken"); // 使用authToken的方式过滤所有请求
        shiroFactoryBean.setFilterChainDefinitionMap(filters);
        return shiroFactoryBean;
    }


    /** 将UserRealm设置到DefaultWebSecurityManager中
     * @param userRealm
     * @return
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager (@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager wsm = new DefaultWebSecurityManager();
        wsm.setRealm(userRealm);
        wsm.setRememberMeManager(null);
        return wsm;
    }

    /** 注入自定义的UserRealm
     * @return
     */
    @Bean
    public UserRealm userRealm () {
        return new UserRealm();
    }


}
