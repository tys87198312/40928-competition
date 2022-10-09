package com.dragee.modules.base.controller;

import com.dragee.common.PageUtils;
import com.dragee.common.R;
import com.dragee.modules.base.entity.DicEntity;
import com.dragee.modules.base.service.DicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-12-01 17:00:35
 */
@RestController
@RequestMapping("base/dic")
@Api(tags = "字典管理")
public class DicController {

    @Autowired
    private DicService dicService;

    /**
     * 列表
     */
    @GetMapping()
    @ApiOperation("字典列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dicService.queryPage(params);
        return R.ok().put("data", page);
    }

    //根据英文名查询字典信息
    @ApiOperation("根据英文名获取字典")
    @GetMapping("findDic/{enName}")
    public R findDic (@PathVariable String enName) {
        List<DicEntity> dic = dicService.findDic(enName);
        return R.ok().put("data", dic);
    }

    //保存字典信息
    @PostMapping()
    @ApiOperation("字典保存")
    public R save(@RequestBody DicEntity dic){
        dicService.save(dic);
        return R.ok();
    }

    //删除字典
    @PostMapping("delete-by-ids")
    @ApiOperation("字典删除")
    public R delete(@RequestBody Long[] ids){
        dicService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    //修改字典
    @PostMapping("update-all")
    @ApiOperation("字典修改")
    public R update(@RequestBody DicEntity dic){
        dicService.saveOrUpdate(dic);
        return R.ok();
    }
}
