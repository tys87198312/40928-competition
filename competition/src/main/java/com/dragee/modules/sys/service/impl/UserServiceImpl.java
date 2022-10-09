package com.dragee.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.AuthConstants;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.sys.dao.UserDao;
import com.dragee.modules.sys.dto.UserDTO;
import com.dragee.modules.sys.entity.LoginUser;
import com.dragee.modules.sys.entity.UserEntity;
import com.dragee.modules.sys.service.UserService;
import com.dragee.modules.sys.vo.UpdatePasswordVo;
import com.dragee.utils.RedisUtil;
import com.dragee.utils.WrapperUtil;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {




    @Resource
    private UserDao userDao;

    @Resource
    private UserService userService;
    private String business = "user";
    /**
    * 列表
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<UserEntity> wrapper =
                WrapperUtil.getWrapper(business, params,UserEntity.class);
        int limit = params.get(CommonConstants.LIMIT) == null
                ?CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ?CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<UserEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select());
        page.getRecords().forEach(r->r.setRole(userDao.getUserRole(r.getUserId()).getRole()));
        return new PageUtils(page);
    }

    @Override
    public LoginUser getLoginUser(String username, String password) {
        LoginUser loginUser = userDao.getLoginUser(username, password);
        return loginUser;
    }

    @Override
    public List<String> getPerms(Long userId) {
        return userDao.getPerms(userId);
    }

    @Override
    public List<String> getRoles(Long userId) {
        return userDao.getRoles(userId);
    }

    @Override
    public void updatePassword(UpdatePasswordVo vo) {

        String password = new Sha256Hash(vo.getNewPassword(), AuthConstants.SLAT_PWD).toString();

        vo.setNewPassword(password);
        userDao.updatePassword(vo);

        RedisUtil.del();
    }

    /**
     * 登录人信息包含角色信息
     */
    @Override
    public UserDTO UserInfo(String userid) {
        return userDao.UserInfo(userid);
    }
}
