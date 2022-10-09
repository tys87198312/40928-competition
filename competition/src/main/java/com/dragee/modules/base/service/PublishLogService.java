package com.dragee.modules.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.base.entity.PublishLogEntity;

import java.util.Map;

/**
 * 消息发布历史
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-12-16 17:26:05
 */
public interface PublishLogService extends IService<PublishLogEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

}

