package com.dragee.modules.base.controller;

import com.dragee.common.PageUtils;
import com.dragee.common.R;
import com.dragee.modules.base.service.ErrorLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 异常表
 *
 * @author zhb
 * @email zhb@mail.com
 * @date 2020-12-04 16:11:21
 */
@RestController
@RequestMapping("base/error-log")
@Api(tags = "异常日志")
public class ErrorLogController {
    @Autowired
    ErrorLogService errorLogService;

    @ApiOperation("查看异常日志")
    @GetMapping("/errorSelect")
    public R errorSelect(@RequestParam Map<String,Object> params){
        PageUtils page = errorLogService.queryPage(params);
        return R.ok().put("data",page);

    }



}
