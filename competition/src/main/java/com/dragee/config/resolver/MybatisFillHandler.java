package com.dragee.config.resolver;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.dragee.modules.sys.entity.LoginUser;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/** mybatis预留参数处理类
 * @author tys on 11/26/20
 */
@Component
public class MybatisFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        if (loginUser == null) return;
        this.strictInsertFill(metaObject, "createBy", String.class, loginUser.getName());
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "sort", Long.class, System.currentTimeMillis());
        this.strictInsertFill(metaObject, "authUserId", String.class, loginUser.getUserId().toString());
        this.strictInsertFill(metaObject, "createById", Long.class, loginUser.getUserId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        if (loginUser == null) return;
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "updateById", Long.class, loginUser.getUserId());
        this.strictUpdateFill(metaObject, "updateBy", String.class, loginUser.getName());
    }
}
