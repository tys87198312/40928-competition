package com.dragee.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.sys.dto.UserDTO;
import com.dragee.modules.sys.entity.LoginUser;
import com.dragee.modules.sys.entity.UserEntity;
import com.dragee.modules.sys.vo.UpdatePasswordVo;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-11 17:46:45
 */
public interface UserService extends IService<UserEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

    LoginUser getLoginUser(String username, String password);

    List<String> getPerms(Long userId);

    List<String> getRoles(Long userId);

    void updatePassword(UpdatePasswordVo vo);

    UserDTO UserInfo(String userid);
}

