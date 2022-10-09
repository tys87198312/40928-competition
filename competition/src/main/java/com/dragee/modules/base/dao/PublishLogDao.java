package com.dragee.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.base.entity.PublishLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 消息发布历史
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-12-16 17:26:05
 */
@Mapper
public interface PublishLogDao extends BaseMapper<PublishLogEntity> {
	
}
