package com.dragee.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.sys.dto.UserDTO;
import com.dragee.modules.sys.entity.LoginUser;
import com.dragee.modules.sys.entity.UserEntity;
import com.dragee.modules.sys.vo.UpdatePasswordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-11 17:46:45
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    LoginUser getLoginUser(@Param("username") String username, @Param("password") String password);

    List<String> getPerms(Long userId);

    List<String> getRoles(Long userId);
    void updatePassword(UpdatePasswordVo vo);
    UserEntity getUserRole(Long userId);

    UserDTO UserInfo(String userid);
}
