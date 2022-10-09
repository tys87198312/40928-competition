package com.dragee.modules.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.base.entity.ErrorLogEntity;

import java.util.Map;

/**
 * 异常表
 *
 * @author zhb
 * @email zhb@mail.com
 * @date 2020-12-04 16:11:21
 */
public interface ErrorLogService extends IService<ErrorLogEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

}

