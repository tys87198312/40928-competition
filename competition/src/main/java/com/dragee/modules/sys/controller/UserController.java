package com.dragee.modules.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dragee.common.PageUtils;
import com.dragee.common.R;
import com.dragee.common.VerifyParam;
import com.dragee.config.exception.BusinessException;
import com.dragee.constants.AuthConstants;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.sys.entity.UserEntity;
import com.dragee.modules.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 用户表
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-11 17:46:45
 */
@RestController
@RequestMapping("sys/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @GetMapping("list")
    @ApiOperation("用户列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);
        return R.ok().put("data", page);
    }

    /**
     * 信息
     */
    @GetMapping("{userid}")
    @ApiOperation("用户信息")
    public R info(@PathVariable("userid") Long userid){
		UserEntity user = userService.getById(userid);
        return R.ok().put("data", user);
    }

    /**
     * 保存
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或修改用户")
    public R saveOrUpdate(@RequestBody UserEntity user){
        VerifyParam.notNull(user);
        user.setStatus(true);
        String password = new Sha256Hash(CommonConstants.initPassword, AuthConstants.SLAT_PWD).toHex();
        if (user.getUserId() == null) {
            // 新增
            //用户名唯一性校验
            int count = userService.count(new QueryWrapper<UserEntity>().eq("username", user.getUsername()));
            if (count!=0){
                throw new BusinessException(502,"用户名已存在");
            }
            user.setPassword(password);
            userService.save(user);
        } else {
            // 修改
            int count = userService.count(new QueryWrapper<UserEntity>()
                    .ne("userId", user.getUserId())
                    .eq("username", user.getUsername()));
            if (count!=0) {
                throw new BusinessException(502,"用户名已存在");
            }
            userService.saveOrUpdate(user);
        }
        return R.ok();
    }

    /**
     * 保存
     */
    @PostMapping()
    @ApiOperation("保存用户")
    public R save(@RequestBody UserEntity user){
        String password = new Sha256Hash(CommonConstants.initPassword, AuthConstants.SLAT_PWD).toHex();
        //用户名唯一性校验
        int count = userService.count(new QueryWrapper<UserEntity>().eq("username", user.getUsername()));
        if (count!=0){
            throw new BusinessException(502,"用户名已存在");
        }
        user.setPassword(password);
		userService.save(user);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("update-all")
    @ApiOperation("修改用户全部字段")
    public R updateAll(@RequestBody UserEntity user){
        int count = userService.count(new QueryWrapper<UserEntity>()
                .ne("userId", user.getUserId())
                .eq("username", user.getUsername()));
        if (count!=0) {
            throw new BusinessException(502,"用户名已存在");
        }
        userService.saveOrUpdate(user);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("delete-by-ids")
    @ApiOperation("删除用户通过多个UserId")
    public R deleteByIds(@RequestBody Long[] userids){
		userService.removeByIds(Arrays.asList(userids));
        return R.ok();
    }

    @GetMapping("delete-by-id")
    @ApiOperation("删除用户通过UserId")
    public R deleteById(String userId){
        http://localhost:8080/api/sys/user/delete-by-id?userId=1
        userService.removeById(Long.parseLong(userId));
        return R.ok();
    }



}
