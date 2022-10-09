package com.dragee.modules.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.base.entity.MessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统消息表
 *
 * @author 
 * @email @mail.com
 * @date 2021-01-27 15:38:12
 */
public interface MessageService extends IService<MessageEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

    List<MessageEntity> selectSentMessage();

    void archiveMessage(Long id);

    void readMessage(Long id);

    void readAllByUserid(Long userId);

    void unarchiveMessage(Long ids);

    void receiveMessage(Long id);
}

