package com.dragee.modules.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.base.dao.DicDao;
import com.dragee.modules.base.entity.DicEntity;
import com.dragee.modules.base.service.DicService;
import com.dragee.utils.WrapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("dicService")
@Transactional(readOnly = true)
public class DicServiceImpl extends ServiceImpl<DicDao, DicEntity> implements DicService {


    @Resource
    private DicDao dicDao;

    private String business = "dic";
    /**
    * 列表
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<DicEntity> wrapper =
                WrapperUtil.getWrapper(business, params, DicEntity.class);
        int limit = params.get(CommonConstants.LIMIT) == null
                ?CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ?CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<DicEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select());
        return new PageUtils(page);
    }

    @Override
    public List<DicEntity> findDic(String enName) {
        return dicDao.findDic(enName);
    }
}