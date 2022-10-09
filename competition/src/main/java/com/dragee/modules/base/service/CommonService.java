package com.dragee.modules.base.service;


import com.dragee.modules.base.entity.DicDTO;

import java.util.List;

/**
 * 用户表
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-10-29 10:51:41
 */
public interface CommonService {

    List<DicDTO> getDic(String enName);

    List<String> getDicValues(String enName);

    List<String> getFilterField(String business);

    String getSlamPath();
    String getSlamRegion();

}

