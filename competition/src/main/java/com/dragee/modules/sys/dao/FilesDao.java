package com.dragee.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.sys.entity.FilesEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件信息
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-26 15:41:41
 */
@Mapper
public interface FilesDao extends BaseMapper<FilesEntity> {
	
}
