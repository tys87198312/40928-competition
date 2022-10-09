package com.dragee.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.base.entity.NoticeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公告表（用户公告、系统公告）
 * 
 * @author 
 * @email @mail.com
 * @date 2021-01-27 15:38:12
 */
@Mapper
public interface NoticeDao extends BaseMapper<NoticeEntity> {
	
}
