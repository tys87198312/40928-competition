package com.dragee.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.base.entity.MessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统消息表
 * 
 * @author 
 * @email @mail.com
 * @date 2021-01-27 15:38:12
 */
@Mapper
public interface MessageDao extends BaseMapper<MessageEntity> {
	
}
