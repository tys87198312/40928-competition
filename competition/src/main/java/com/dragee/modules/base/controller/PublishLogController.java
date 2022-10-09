package com.dragee.modules.base.controller;

import com.dragee.common.PageUtils;
import com.dragee.common.R;
import com.dragee.modules.base.service.PublishLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 消息发布历史
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-12-16 17:26:05
 */
@RestController
@RequestMapping("base/publish-log")
@Api(tags = "消息发布历史")
public class PublishLogController {
    @Autowired
    private PublishLogService publishLogService;

    /**
     * 列表
     */
    @GetMapping()
    @ApiOperation("消息发布历史列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = publishLogService.queryPage(params);
        return R.ok().put("data", page);
    }




}
