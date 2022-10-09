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
 * 异常表
 * 
 * @author zhb
 * @email zhb@mail.com
 * @date 2020-12-04 16:11:21
 */
@Data
@TableName("base_error_log")
public class ErrorLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    /**
     * 提交方式
     */
    private String method;

    /**
     * 路径
     */
    private String url;

    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 错误提示
     */
    private String errorMsg;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 操作人
     */
    private String loginUser;

    /**
     * 参数
     */
    private String params;

    /**
     * 排序值
     */
    @TableField(fill = FieldFill.INSERT)
    private Long sort;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    }