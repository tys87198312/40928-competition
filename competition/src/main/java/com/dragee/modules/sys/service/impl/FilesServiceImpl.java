package com.dragee.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.sys.dao.FilesDao;
import com.dragee.modules.sys.entity.FilesEntity;
import com.dragee.modules.sys.service.FilesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service("filesService")
@Transactional(readOnly = true)
public class FilesServiceImpl extends ServiceImpl<FilesDao, FilesEntity> implements FilesService {


    @Resource
    private FilesDao filesDao;
    /**
    * 列表
    */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int limit = params.get(CommonConstants.LIMIT) == null
                ?CommonConstants.LIMIT_SIZE:Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ?CommonConstants.START_SIZE:Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<FilesEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, new QueryWrapper<FilesEntity>().select());
        return new PageUtils(page);
    }
}