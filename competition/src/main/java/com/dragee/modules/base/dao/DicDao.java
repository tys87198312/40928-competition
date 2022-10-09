package com.dragee.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.base.entity.DicEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-12-01 17:00:35
 */
@Mapper
public interface DicDao extends BaseMapper<DicEntity> {

    List<DicEntity> findDic(String enName);
}
