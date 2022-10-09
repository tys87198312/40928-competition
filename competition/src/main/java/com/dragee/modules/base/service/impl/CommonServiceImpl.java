package com.dragee.modules.base.service.impl;

import com.dragee.modules.base.dao.CommonDao;
import com.dragee.modules.base.entity.DicDTO;
import com.dragee.modules.base.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service("commonService")
@Transactional(readOnly = true)
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonDao commonDao;


    @Override
    public List<DicDTO> getDic(String enName) {

        return commonDao.getDic(enName);
    }

    @Override
    public List<String> getDicValues(String enName) {
        return commonDao.getDicValues(enName);
    }

    @Override
    public List<String> getFilterField(String business) {
        return commonDao.getFilterField(business);
    }

    @Override
    public String getSlamPath() {
        return commonDao.getSlamPath();
    }

    @Override
    public String getSlamRegion() {
        return commonDao.getSlamRegion();
    }
}