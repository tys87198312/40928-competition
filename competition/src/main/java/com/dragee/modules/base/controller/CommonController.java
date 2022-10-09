package com.dragee.modules.base.controller;

import com.dragee.common.R;
import com.dragee.config.exception.AuthErrorType;
import com.dragee.config.exception.BusinessErrorType;
import com.dragee.modules.base.entity.DicDTO;
import com.dragee.modules.base.service.CommonService;
import com.dragee.modules.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CommonController 存放工具接口的controller
 *
 * @author tys on 11/10/20
 */
@RestController
@RequestMapping("common")
@Api(tags = "通用")
public class CommonController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private UserService userService;

    @ApiOperation("根据英文名获取字典")
    @GetMapping("find-dic/{enName}")
    public R findDic (@PathVariable String enName) {
        List<DicDTO> dic = commonService.getDic(enName);
        return R.ok().put("data", dic);
    }

    @ApiOperation("查看异常列表")
    @GetMapping("list-error")
    public R listError () {
        Map<Integer, String> authMap = new HashMap<>();
        Map<Integer, String> businessMap = new HashMap<>();
        Arrays.asList(AuthErrorType.values()).forEach(a -> {
          authMap.put(a.getCode(), a.getMsg());
        });
        Arrays.asList(BusinessErrorType.values()).forEach(b -> {
            businessMap.put(b.getCode(), b.getMsg());
        });
        Map map = new HashMap<>();
        map.put("权限异常", authMap);
        map.put("业务异常", businessMap);
        return R.ok().put("data", map);
    }


}
