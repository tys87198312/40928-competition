package com.dragee.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.sys.dto.RoleMenusDTO;
import com.dragee.modules.sys.entity.MenuTree;
import com.dragee.modules.sys.entity.MenusEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-12 09:36:29
 */
@Mapper
public interface MenusDao extends BaseMapper<MenusEntity> {
    List<MenusEntity> getTopMenus(Long userId);

    List<MenusEntity> getSonMenus(@Param("userId") Long userId, @Param("parentId") Long parentId);

    List<MenusEntity> getTops();

    List<MenuTree> getTopMenusByRole(String roleEnName);

    List<MenuTree> getMenusNext(Long parentId);

    List<RoleMenusDTO> getTopMenusByRoleBase(String roleEnName);

    List<RoleMenusDTO> getMenusNextBase(@Param("parentId") Long parentId, @Param("roleEnName") String roleEnName);
}
