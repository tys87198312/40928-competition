package com.dragee.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.sys.dao.MenusDao;
import com.dragee.modules.sys.dto.RoleMenusDTO;
import com.dragee.modules.sys.entity.MenuTree;
import com.dragee.modules.sys.entity.MenusEntity;
import com.dragee.modules.sys.service.MenusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("menusService")
@Transactional(readOnly = true)
public class MenusServiceImpl extends ServiceImpl<MenusDao, MenusEntity> implements MenusService {


    @Resource
    private MenusDao menusDao;
    /**
    * 列表
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int limit = params.get(CommonConstants.LIMIT) == null
                ? CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ? CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<MenusEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, new QueryWrapper<MenusEntity>().select().orderByAsc("sort", "menuName"));
        return new PageUtils(page);
    }

    @Override
    public List<MenuTree> getMenus(Long userId) {
        List<MenusEntity> top = menusDao.getTopMenus(userId);
        List<MenuTree> tops = new ArrayList<>();
        for (MenusEntity t: top) {
            MenuTree menu = new MenuTree();
            List<MenuTree> sons = new ArrayList<>();
            menu.setName(t.getMenuName());
            menu.setUrl(t.getUrl());
            menu.setIcon(t.getIcon());
            menu.setMenuId(t.getMenuId());

            List<MenusEntity> sonMenus = menusDao.getSonMenus(userId, t.getMenuId());
            sonMenus.forEach(m -> sons.add(new MenuTree(m)));
            menu.setChildren(sons);
            tops.add(menu);
        }
        return tops;
    }

    @Override
    public List<MenusEntity> getMenuList (Long userId) {
        List<MenusEntity> top = menusDao.getTops();
        top.forEach(t -> t.setLabel(t.getMenuName()));
        for (MenusEntity t: top) {
            List<MenusEntity> sonMenus = baseMapper.selectList(new QueryWrapper<MenusEntity>()
                    .eq("parentId", t.getMenuId())
                    .orderByAsc("sort", "menuName"));
            sonMenus.forEach(s -> s.setLabel(t.getMenuName()));
            t.setChildren(sonMenus);
        }
        return top;
    }

    @Override
    public List<MenuTree> getTopMenusByRole(String roleEnName) {
        return menusDao.getTopMenusByRole(roleEnName);
    }

    @Override
    public List<MenuTree> getMenusNext(Long parentId) {
        return menusDao.getMenusNext(parentId);
    }

    @Override
    public List<RoleMenusDTO> getTopMenusByRoleBase(String roleEnName) {
        return menusDao.getTopMenusByRoleBase(roleEnName);
    }

    @Override
    public List<RoleMenusDTO> getMenusNextBase(Long parentId, String enName) {
        return menusDao.getMenusNextBase(parentId, enName);
    }
}