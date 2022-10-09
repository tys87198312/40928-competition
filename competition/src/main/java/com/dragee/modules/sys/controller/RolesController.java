package com.dragee.modules.sys.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dragee.common.PageUtils;
import com.dragee.common.R;
import com.dragee.config.exception.BusinessErrorType;
import com.dragee.config.exception.BusinessException;
import com.dragee.modules.sys.entity.RolesEntity;
import com.dragee.modules.sys.service.RolesService;
import com.dragee.modules.sys.vo.RoleSubmitDataFarmCarVo;
import com.dragee.modules.sys.vo.RoleSubmitDataMenussVo;
import com.dragee.modules.sys.vo.RoleSubmitDataUsersVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 角色
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-12 09:36:29
 */
@RestController
@RequestMapping("sys/role")
@Api(tags = "角色管理")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    /**
     * 列表
     */
    @GetMapping("list")
    @ApiOperation("角色列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rolesService.queryPage(params);
        return R.ok().put("data", page);
    }

    /**
     * 保存
     */
    @PostMapping()
    @ApiOperation("保存角色")
    public R save(@RequestBody RolesEntity role){
        int count = rolesService.count(new QueryWrapper<RolesEntity>()
                .eq("enName", role.getEnName()));
        if (count > 0)
            throw new BusinessException(BusinessErrorType.ROLES_EXISTED);
        rolesService.save(role);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update-all")
    @ApiOperation("修改角色所有字段")
    public R updateAll(@RequestBody RolesEntity role){
        int count = rolesService.count(new QueryWrapper<RolesEntity>()
                .ne("roleId", role.getRoleId())
                .eq("enName", role.getEnName()));
        if (count > 0)
            throw new BusinessException(BusinessErrorType.ROLES_EXISTED);
		rolesService.saveOrUpdate(role);
        return R.ok();
    }
    /**
     * 删除
     */
    @PostMapping("delete-by-ids")
    @ApiOperation("删除角色通过多个ID")
    public R deleteByIds(@RequestBody Long[] roleids){
		rolesService.removeByIds(Arrays.asList(roleids));
        return R.ok();
    }

    @GetMapping("find-users")
    @ApiOperation("查询角色下的用户列表")
    public R getUsers(String enName){
        if (StrUtil.isBlank(enName))
            throw new BusinessException(BusinessErrorType.INVALID_PARAMS);
        return R.ok().put("data", rolesService.getUsers(enName));
    }
    @GetMapping("find-farm-car")
    @ApiOperation("查询角色下的农场和车辆列表")
    public R getFarmCarData(String enName){
        if (StrUtil.isBlank(enName))
            throw new BusinessException(BusinessErrorType.INVALID_PARAMS);
        return R.ok().put("data", rolesService.getFarmsAndCars(enName));
    }
    @GetMapping("find-menus")
    @ApiOperation("查询角色下的菜单")
    public R getMenus(String enName){
        if (StrUtil.isBlank(enName))
            throw new BusinessException(BusinessErrorType.INVALID_PARAMS);
        return R.ok().put("data", rolesService.getMenus(enName));
    }

    @PostMapping("submit-users")
    @ApiOperation("提交用户数据")
    public R submitUsers (@RequestBody RoleSubmitDataUsersVo vo) {
        rolesService.submitUsers(vo);
        return R.ok();
    }

    @PostMapping("submit-menus")
    @ApiOperation("提交菜单数据")
    public R submitMenus (@RequestBody RoleSubmitDataMenussVo vo) {
        rolesService.submitMenus(vo);
        return R.ok();
    }

    @PostMapping("submit-farm-car")
    @ApiOperation("提交农场和车辆数据")
    public R submitFarmCar (@RequestBody RoleSubmitDataFarmCarVo vo) {
        rolesService.submitFarmCar(vo);
        return R.ok();
    }



}
