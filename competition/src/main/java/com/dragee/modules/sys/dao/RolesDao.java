package com.dragee.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.sys.dto.RoleCarsDTO;
import com.dragee.modules.sys.dto.RoleFarmsDTO;
import com.dragee.modules.sys.dto.RoleUsersDTO;
import com.dragee.modules.sys.entity.RolesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-12 09:36:29
 */
@Mapper
public interface RolesDao extends BaseMapper<RolesEntity> {
    List<RoleUsersDTO> getUsers(String enName);

    List<RoleFarmsDTO> getFarms(String enName);

    List<RoleCarsDTO> getCarsByFarmAndRole(@Param("farmCode") String farmCode, @Param("enName") String enName);

    void insertUserRole(@Param("role") String role,
                        @Param("roleName") String roleName,
                        @Param("value") String value,
                        @Param("label") String label);
    void insertMenuRole(@Param("role") String role,
                        @Param("roleName") String roleName,
                        @Param("value") String value,
                        @Param("label") String label);
    void insertFarmRole(@Param("role") String role,
                        @Param("roleName") String roleName,
                        @Param("value") String value,
                        @Param("label") String label);
    void insertCarRole(@Param("role") String role,
                       @Param("roleName") String roleName,
                       @Param("value") String value,
                       @Param("label") String label);

    void deleteUserRole(String role);
    void deleteMenuRole(String role);
    void deleteFarmRole(String role);
    void deleteCarRole(String role);

}
