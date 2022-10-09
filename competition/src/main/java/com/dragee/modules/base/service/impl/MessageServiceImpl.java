package com.dragee.modules.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.base.dao.MessageDao;
import com.dragee.modules.base.entity.MessageEntity;
import com.dragee.modules.base.service.MessageService;
import com.dragee.utils.WrapperUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("messageService")
@Transactional(readOnly = true)
public class MessageServiceImpl extends ServiceImpl<MessageDao, MessageEntity> implements MessageService {


    private String business = "message";


    /**
     * 列表
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        QueryWrapper<MessageEntity> wrapper =
                WrapperUtil.getWrapper(business, params, MessageEntity.class);
        int limit = params.get(CommonConstants.LIMIT) == null
                ? CommonConstants.LIMIT_SIZE : Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ? CommonConstants.START_SIZE : Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<MessageEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select().ne("status", 3));
        return new PageUtils(page);

    }

    @Override
    @Transactional(readOnly = false)
    public List<MessageEntity> selectSentMessage() {
        List<MessageEntity> messageEntities = this.baseMapper.selectList(new QueryWrapper<MessageEntity>().eq("status", 0));

        return messageEntities;
    }

    @Override
    @Transactional(readOnly = false)
    public void archiveMessage(Long id) {
        MessageEntity messageEntity = this.baseMapper.selectById(id);
        MessageEntity messageEntity1 = new MessageEntity();
        BeanUtils.copyProperties(messageEntity, messageEntity1);
        messageEntity1.setStatus(3);
        messageEntity1.setArchiveTime(new Date());
        this.baseMapper.updateById(messageEntity1);
    }

    @Override
    @Transactional(readOnly = false)
    public void readMessage(Long id) {
        MessageEntity messageEntity = this.baseMapper.selectById(id);
        if (null != messageEntity) {
            MessageEntity messageEntity1 = new MessageEntity();
            BeanUtils.copyProperties(messageEntity, messageEntity1);
            messageEntity1.setStatus(2);
            messageEntity1.setReadTime(new Date());
            this.baseMapper.updateById(messageEntity1);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void readAllByUserid(Long userId) {
        QueryWrapper<MessageEntity> queryWrapper = new QueryWrapper<MessageEntity>().eq("receiverId", userId);
        queryWrapper.and(wrap -> {
            wrap.isNull("readTime");
        });
        List<MessageEntity> messageEntities = this.baseMapper.selectList(queryWrapper);
        for (MessageEntity messageEntity : messageEntities) {
            MessageEntity messageEntity1 = new MessageEntity();
            BeanUtils.copyProperties(messageEntity, messageEntity1);
            //设为已读状态，并将读时间赋值
            messageEntity1.setReceiveTime(new Date());
            messageEntity1.setStatus(2);
            messageEntity1.setReadTime(new Date());
            updateById(messageEntity1);
        }
    }

    @Override
    public void unarchiveMessage(Long id) {
        MessageEntity messageEntity = this.baseMapper.selectById(id);
        MessageEntity messageEntity1 = new MessageEntity();
        BeanUtils.copyProperties(messageEntity, messageEntity1);
        messageEntity1.setStatus(2);
        messageEntity1.setArchiveTime(null);
        this.baseMapper.updateById(messageEntity1);
    }

    @Override
    public void receiveMessage(Long id) {
        MessageEntity messageEntity = this.baseMapper.selectById(id);
        MessageEntity messageEntity1 = new MessageEntity();
        BeanUtils.copyProperties(messageEntity, messageEntity1);
        messageEntity1.setStatus(1);
        messageEntity1.setReceiveTime(new Date());
        this.baseMapper.updateById(messageEntity1);
    }
}