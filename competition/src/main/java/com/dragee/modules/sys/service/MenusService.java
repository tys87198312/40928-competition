package com.dragee.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.sys.dto.RoleMenusDTO;
import com.dragee.modules.sys.entity.MenuTree;
import com.dragee.modules.sys.entity.MenusEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-12 09:36:29
 */
public interface MenusService extends IService<MenusEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

    List<MenuTree> getMenus(Long userId);

    List<MenusEntity> getMenuList(Long userId);

    List<MenuTree> getTopMenusByRole(String roleEnName);

    List<MenuTree> getMenusNext(Long parentId);

    List<RoleMenusDTO> getTopMenusByRoleBase(String roleEnName);

    List<RoleMenusDTO> getMenusNextBase(Long parentId, String enName);
}

