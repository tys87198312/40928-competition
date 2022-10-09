package com.dragee.modules.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragee.common.PageUtils;
import com.dragee.constants.CommonConstants;
import com.dragee.modules.base.dao.NoticeDao;
import com.dragee.modules.base.entity.NoticeEntity;
import com.dragee.modules.base.service.MessageService;
import com.dragee.modules.base.service.NoticeService;
import com.dragee.modules.sys.service.UserService;
import com.dragee.utils.WrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("noticeService")
@Transactional(readOnly = true)
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {




    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    private String business = "notice";

    /**
     * 列表
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        QueryWrapper<NoticeEntity> wrapper =
                WrapperUtil.getWrapper(business, params, NoticeEntity.class);
        int limit = params.get(CommonConstants.LIMIT) == null
                ? CommonConstants.LIMIT_SIZE : Integer.parseInt(params.get(CommonConstants.LIMIT).toString());
        int start = params.get(CommonConstants.START) == null
                ? CommonConstants.START_SIZE : Integer.parseInt(params.get(CommonConstants.START).toString());
        IPage<NoticeEntity> page = new Page<>(start, limit);
        page = baseMapper.selectPage(page, wrapper.select());
        return new PageUtils(page);
    }

    /**
     * 发布公告分为两步进行：
     * 1、更新表base_notice&base_message
     * 1.1、将base_notice表中的sent状态改为已发送（0->1）
     * 1.2、将这条noticeEntity插入到base_message表中
     * 2、发送topic
     */
    @Override
    @Transactional(readOnly = false)
    public void announceNotice(NoticeEntity noticeEntity) {
//        if (noticeEntity.getSent().equals(CommonConstants.NOT_SEND)) {
//            noticeEntity.setSent(CommonConstants.HAVE_SENT);
//            this.baseMapper.updateById(noticeEntity);
//            List<UserEntity> list = userService.list();
//            Optional.ofNullable(list).ifPresent(userEntities -> {
//                userEntities.forEach(
//                    userEntity -> {
//                        MessageEntity messageEntity = new MessageEntity();
//                        messageEntity.setDataId(noticeEntity.getId().toString());
//                        messageEntity.setType("sys_notice");//noticeEntity.getType()
//                        messageEntity.setTitle(noticeEntity.getTitle());
//                        messageEntity.setContent(noticeEntity.getContent());
//                        messageEntity.setSenderId(LoginUserUtil.getLoginUser().getUserId().toString());
//                        messageEntity.setSenderName(LoginUserUtil.getLoginUser().getUsername());
//                        messageEntity.setReceiverId(userEntity.getUserId().toString());
//                        messageEntity.setReceiverName(userEntity.getUsername());
//                        Date currentDate = new Date();
//                        messageEntity.setSendTime(currentDate);
//                        messageEntity.setCreateTime(currentDate);
//                        messageService.save(messageEntity);
//                        noticeEntity.setType("sys_notice");
//                        MqttMessage mqttMessage = new MqttMessage();
//                        String jsonStr = JSONUtil.toJsonStr(noticeEntity);
//                        mqttMessage.setPayload(jsonStr.getBytes());
//                        mqttClient.pub(Topic.FMS_NOTICE.addPath(userEntity.getUserId().toString()), mqttMessage, true);
//                    }
//                );
//            });
//        }
    }

}