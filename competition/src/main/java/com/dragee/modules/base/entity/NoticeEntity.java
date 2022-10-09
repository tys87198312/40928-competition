package com.dragee.modules.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dragee.config.resolver.LongJsonDeserializer;
import com.dragee.config.resolver.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告表（用户公告、系统公告）
 * 
 * @author 
 * @email @mail.com
 * @date 2021-01-27 15:38:12
 */
@Data
@TableName("base_notice")
public class NoticeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    /**
     * 公告类型
     */
    private String type;

    /**
     * 
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 通知的发送状态，0:未发送，1：已发送
     */
    private Integer sent;

    /**
     * 
     */
    private String createdBy;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 
     */
    private String operator;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer sort;

    }