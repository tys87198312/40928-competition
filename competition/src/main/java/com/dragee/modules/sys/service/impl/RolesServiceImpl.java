package com.dragee.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.sys.dao.RolesDao;
import com.dragee.modules.sys.dto.RoleCarsDTO;
import com.dragee.modules.sys.dto.RoleFarmsDTO;
import com.dragee.modules.sys.dto.RoleMenusDTO;
import com.dragee.modules.sys.dto.RoleUsersDTO;
import com.dragee.modules.sys.entity.RolesEntity;
import com.dragee.modules.sys.service.MenusService;
import com.dragee.modules.sys.service.RolesService;
import com.dragee.modules.sys.vo.RoleSubmitDataFarmCarVo;
import com.dragee.modules.sys.vo.RoleSubmitDataMenussVo;
import com.dragee.modules.sys.vo.RoleSubmitDataUsersVo;
import com.dragee.utils.WrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service("rolesService")
public class RolesServiceImpl extends ServiceImpl<RolesDao, RolesEntity> implements RolesService {


    @Resource
    private RolesDao rolesDao;

    @Autowired
    private MenusService menusService;

    private String business = "roles";
    /**
    * 列表
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<RolesEntity> wrapper =
                WrapperUtil.getWrapper(business, params, RolesEntity.class);
        int limit = params.get(CommonConstants.LIMIT) == null
                ?CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ?CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<RolesEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select());
        return new PageUtils(page);
    }

    @Override
    public List<RoleUsersDTO> getUsers(String enName) {
        return rolesDao.getUsers(enName);
    }

    @Override
    public List<RoleMenusDTO> getMenus(String enName) {
        List<RoleMenusDTO> tops = menusService.getTopMenusByRoleBase(enName);
        for (RoleMenusDTO top : tops) {
            List<RoleMenusDTO> twos = menusService.getMenusNextBase(top.getMenuId(), enName);
            for (RoleMenusDTO two : twos) {
                List<RoleMenusDTO> threes = menusService.getMenusNextBase(two.getMenuId(), enName);
                two.setChilds(threes);
            }
            top.setChilds(twos);
        }
        return tops;
    }

    @Override
    public List<RoleFarmsDTO> getFarmsAndCars(String enName) {
        List<RoleFarmsDTO> farms = rolesDao.getFarms(enName);
        farms.forEach(f -> {
            List<RoleCarsDTO> cars = rolesDao.getCarsByFarmAndRole(f.getFarmCode(), enName);
            f.setCars(cars);
        });
        return farms;
    }

    @Override
    public RolesEntity getRoleByEnName(String enName) {
        return getOne(new QueryWrapper<RolesEntity>().eq("enName", enName));
    }

    @Override
    public void submitUsers(RoleSubmitDataUsersVo vo) {
        rolesDao.deleteUserRole(vo.getRole());
        Arrays.asList(vo.getUsers()).forEach(u -> {
            rolesDao.insertUserRole(vo.getRole(), vo.getRoleName(), u.getValue(), u.getLabel());
        });
    }

    @Override
    public void submitMenus(RoleSubmitDataMenussVo vo) {
        rolesDao.deleteMenuRole(vo.getRole());
        Arrays.asList(vo.getMenus()).forEach(u -> {
            rolesDao.insertMenuRole(vo.getRole(), vo.getRoleName(), u.getValue(), u.getLabel());
        });
    }

    @Override
    public void submitFarmCar(RoleSubmitDataFarmCarVo vo) {
        rolesDao.deleteFarmRole(vo.getRole());
        Arrays.asList(vo.getFarms()).forEach(u -> {
            rolesDao.insertFarmRole(vo.getRole(), vo.getRoleName(), u.getValue(), u.getLabel());
        });

        rolesDao.deleteCarRole(vo.getRole());
        Arrays.asList(vo.getCars()).forEach(u -> {
            rolesDao.insertCarRole(vo.getRole(), vo.getRoleName(), u.getValue(), u.getLabel());
        });
    }
}