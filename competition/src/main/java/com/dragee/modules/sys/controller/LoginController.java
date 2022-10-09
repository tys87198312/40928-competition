package com.dragee.modules.sys.controller;

import cn.hutool.core.util.StrUtil;
import com.dragee.common.R;
import com.dragee.config.async.AsyncTask;
import com.dragee.config.exception.AuthErrorType;
import com.dragee.config.exception.AuthException;
import com.dragee.config.exception.BusinessErrorType;
import com.dragee.config.exception.BusinessException;
import com.dragee.config.resolver.User;
import com.dragee.config.shiro.AuthToken;
import com.dragee.constants.AuthConstants;
import com.dragee.modules.sys.dto.TokenDTO;
import com.dragee.modules.sys.dto.UserInfomactionDTO;
import com.dragee.modules.sys.entity.LoginUser;
import com.dragee.modules.sys.entity.MenuTree;
import com.dragee.modules.sys.service.MenusService;
import com.dragee.modules.sys.service.UserService;
import com.dragee.modules.sys.vo.LoginVo;
import com.dragee.modules.sys.vo.UpdatePasswordVo;
import com.dragee.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;

/**
 * @author tys on 11/10/20
 */
@RestController
@Api(tags = "登陆")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenusService menusService;

    @Autowired
    private AsyncTask asyncTask;



    @ApiOperation("登陆")
    @PostMapping("/login")
    public R login (@RequestBody LoginVo loginVo) {
        String tokenStr;
        AuthenticationToken token;
        Subject subject = SecurityUtils.getSubject();

        // 参数校验
        if (StrUtil.isBlank(loginVo.getUsername()) || StrUtil.isBlank(loginVo.getPassword()) || StrUtil.isBlank(loginVo.getClientId()))
            throw new BusinessException(BusinessErrorType.INVALID_PARAMS);
        // 校验clientId
        if (!Arrays.asList(AuthConstants.CLIENTS).contains(loginVo.getClientId()))
            throw new AuthException(AuthErrorType.NO_SUPPORT_CLIENT);
        // 传入的密码加密
        String password = new Sha256Hash(loginVo.getPassword(), AuthConstants.SLAT_PWD).toHex();
        // 根据用户名密码去数据库比对用户 获取LoginUser
        LoginUser loginUser = userService.getLoginUser(loginVo.getUsername(), password);
        if (loginUser == null)
            throw new AuthException(AuthErrorType.USERNAME_OR_PASSWORD_ERROR);
        loginUser.setClientId(loginVo.getClientId());
        // 将loginUser对象放到token中
        tokenStr = TokenUtil.createToken(loginUser, AuthConstants.TOKEN_EXPIRE);
        // 用户登陆 返回token
        token = new AuthToken(tokenStr);
        /*核心 调用认证方法*/
        try  {
            subject.login(token);
            TokenDTO dto = new TokenDTO(AuthConstants.JWT_TOKEN_HEADER,
                    AuthConstants.JWT_TOKEN_PREFIX + tokenStr,
                    loginUser.getUserId(),
                    loginUser.getUsername(),
                    loginUser.getRoleName(),
                    loginUser.getName());
            return R.ok().put("data", dto);
        } catch (BusinessException e) {
            return R.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return R.error();
        }
    }

    @ApiOperation("三方登录")
    @PostMapping("/access-login")
    public R accessLogin (@RequestBody LoginVo loginVo) {
        String tokenStr;
        AuthenticationToken token;
        Subject subject = SecurityUtils.getSubject();

        // 参数校验
        if (StrUtil.isBlank(loginVo.getUsername()) || StrUtil.isBlank(loginVo.getPassword()) || StrUtil.isBlank(loginVo.getClientId()))
            throw new BusinessException(BusinessErrorType.INVALID_PARAMS);
        // 校验clientId
        if (!Arrays.asList(AuthConstants.ACCESS_CLIENTS).contains(loginVo.getClientId()))
            throw new AuthException(AuthErrorType.NO_SUPPORT_CLIENT);
        // 传入的密码加密
        String password = new Sha256Hash(loginVo.getPassword(), AuthConstants.SLAT_PWD).toHex();
        // 根据用户名密码去数据库比对用户 获取LoginUser
        LoginUser loginUser = userService.getLoginUser(loginVo.getUsername(), password);
        if (loginUser == null)
            throw new AuthException(AuthErrorType.USERNAME_OR_PASSWORD_ERROR);
        loginUser.setClientId(loginVo.getClientId());

        // 将loginUser对象放到token中
        tokenStr = TokenUtil.createToken(loginUser, AuthConstants.TOKEN_EXPIRE);
        // 用户登陆 返回token
        token = new AuthToken(tokenStr);
        /*核心 调用认证方法*/
        try  {
            subject.login(token);
            TokenDTO dto = new TokenDTO(AuthConstants.JWT_TOKEN_HEADER,
                    AuthConstants.JWT_TOKEN_PREFIX + tokenStr,
                    loginUser.getUserId(),
                    loginUser.getUsername(),
                    loginUser.getRoleName(),
                    loginUser.getName());
            return R.ok().put("token", dto.getToken());
        } catch (BusinessException e) {
            return R.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return R.error();
        }
    }




    @ApiOperation("修改密码")
    @PostMapping("/update-password")
    public R updatePassword (@RequestBody UpdatePasswordVo vo) {

        // 传入的密码加密
        String password = new Sha256Hash(vo.getOldPassword(), AuthConstants.SLAT_PWD).toHex();
        // 根据用户名密码去数据库比对用户 获取LoginUser
        LoginUser loginUser = userService.getLoginUser(vo.getUsername(), password);
        if (loginUser == null) {
            //比对失败
            throw new AuthException(AuthErrorType.USERNAME_PASSWORD_ERROR);
        }
        userService.updatePassword(vo);
        return R.ok();
    }

    @GetMapping("user-info")
    @ApiOperation("获取当前登陆人权限和菜单")
    public R userInfo (@User @ApiIgnore LoginUser user) {
        List<MenuTree> menuTree = menusService.getMenus(user.getUserId());
        List<String> perms = userService.getPerms(user.getUserId());
        return R.ok().put("data", new UserInfomactionDTO()
                .setMenus(menuTree)
                .setPerms(perms)
                .setUserId(user.getUserId())
                .setName(user.getName()));
    }


}


