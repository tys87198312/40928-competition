package com.dragee.modules.base.dao;

import com.dragee.modules.base.entity.DicDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-10-29 10:51:41
 */
@Mapper
public interface CommonDao{
    List<DicDTO> getDic(String enName);

    List<DicDTO> getFarmsDic(Long userId);

    List<DicDTO> getCarsDic(Long userId);

    List<DicDTO> getCarAll();

    List<String> getDicValues(String enName);

    List<String> getFilterField(String business);

    String getSlamPath();
    String getSlamRegion();

}
