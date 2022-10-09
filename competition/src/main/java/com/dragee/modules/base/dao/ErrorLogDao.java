package com.dragee.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.base.entity.ErrorLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 异常表
 * 
 * @author zhb
 * @email zhb@mail.com
 * @date 2020-12-04 16:11:21
 */
@Mapper
public interface ErrorLogDao extends BaseMapper<ErrorLogEntity> {
	
}
