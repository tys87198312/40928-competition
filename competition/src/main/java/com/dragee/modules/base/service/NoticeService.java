package com.dragee.modules.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.base.entity.NoticeEntity;

import java.util.Map;

/**
 * 公告表（用户公告、系统公告）
 *
 * @author 
 * @email @mail.com
 * @date 2021-01-27 15:38:12
 */
public interface NoticeService extends IService<NoticeEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

    void announceNotice(NoticeEntity noticeEntity);
}

