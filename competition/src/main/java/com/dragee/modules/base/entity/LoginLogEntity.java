package com.dragee.modules.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("base_login_log")
public class LoginLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date operatorTime;

    /**
     * 排序值
     */
    @TableField(fill = FieldFill.INSERT)
    private Long sort;

}