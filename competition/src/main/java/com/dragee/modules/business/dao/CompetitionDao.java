package com.dragee.modules.business.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragee.modules.business.entity.CompetitionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-11 17:46:45
 */
@Mapper
public interface CompetitionDao extends BaseMapper<CompetitionEntity> {

    List<CompetitionEntity> listXS (@Param("userId") Long userId, @Param("filter") String filter);

    List<CompetitionEntity> listPW (@Param("userId") Long userId, @Param("filter") String filter);

}
