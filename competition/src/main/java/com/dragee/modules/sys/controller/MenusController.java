package com.dragee.modules.sys.controller;

import com.dragee.common.R;
import com.dragee.modules.sys.entity.MenusEntity;
import com.dragee.modules.sys.service.MenusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 菜单
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-12 09:36:29
 */
@RestController
@RequestMapping("sys/menu")
@Api(tags = "菜单")
public class MenusController {
    @Autowired
    private MenusService menusService;


    /**
     * 列表
     */
    @GetMapping("list")
    @ApiOperation("菜单列表")
    public R list(@RequestParam Map<String, Object> params){
        List<MenusEntity> menuTree = menusService.getMenuList(null);
        return R.ok().put("data", menuTree);
    }


    /**
     * 信息
     */
    @GetMapping("{menuId}")
    @ApiOperation("菜单信息")
    public R info(@PathVariable("menuId") Long menuid){
		MenusEntity menus = menusService.getById(menuid);
        return R.ok().put("data", menus);
    }

    /**
     * 保存
     */
    @PostMapping()
    @ApiOperation("保存菜单")
    public R save(@RequestBody MenusEntity menus){
        menus.setLabel(menus.getMenuName());
        menus.setStatus("启用");
		menusService.save(menus);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("update-all")
    @ApiOperation("修改菜单全部字段")
    public R updateAll(@RequestBody MenusEntity menus){
		menusService.saveOrUpdate(menus);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("delete-by-ids")
    @ApiOperation("删除菜单")
    public R deleteByIds(@RequestBody Long[] menuids){
		menusService.removeByIds(Arrays.asList(menuids));
        return R.ok();
    }

}
