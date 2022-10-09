package com.dragee.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dragee.common.PageUtils;
import com.dragee.modules.sys.dto.RoleFarmsDTO;
import com.dragee.modules.sys.dto.RoleMenusDTO;
import com.dragee.modules.sys.dto.RoleUsersDTO;
import com.dragee.modules.sys.entity.RolesEntity;
import com.dragee.modules.sys.vo.RoleSubmitDataFarmCarVo;
import com.dragee.modules.sys.vo.RoleSubmitDataMenussVo;
import com.dragee.modules.sys.vo.RoleSubmitDataUsersVo;

import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-12 09:36:29
 */
public interface RolesService extends IService<RolesEntity> {

    /**
    * 列表
    */
    PageUtils queryPage(Map<String, Object> params);

    List<RoleUsersDTO> getUsers(String enName);

    List<RoleMenusDTO> getMenus(String enName);

    List<RoleFarmsDTO> getFarmsAndCars(String enName);

    RolesEntity getRoleByEnName(String enName);

    void submitUsers(RoleSubmitDataUsersVo vo);

    void submitMenus(RoleSubmitDataMenussVo vo);

    void submitFarmCar(RoleSubmitDataFarmCarVo vo);


}

