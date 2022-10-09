package com.dragee.modules.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.base.entity.LoginLogEntity;

import java.util.Map;

public interface LoginLogService extends IService<LoginLogEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

}

