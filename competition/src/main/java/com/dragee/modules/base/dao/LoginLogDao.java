package com.dragee.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.base.entity.LoginLogEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogDao extends BaseMapper<LoginLogEntity> {
	
}
