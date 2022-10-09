package com.dragee.modules.sys.entity;

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
import java.util.List;

/**
 * 菜单
 * 
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-26 14:52:45
 */
@Data
@TableName("sys_menus")
public class MenusEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long menuId;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单名
     */
    @TableField(exist = false)
    private String label;

    /**
     * 路径
     */
    private String url;

    /**
     * 图片
     */
    private String icon;

    /**
     * 父菜单
     */
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long parentId;

    /**
     * 父菜单
     */
    private String parentName;

    /**
     * 菜单类型
     */
    private int type;

    /**
     * 权限
     */
    private String perms;

    /**
     * 是否启用
     */
    private String status;

    /**
     * 排序
     */
    @TableField(fill = FieldFill.INSERT)
    private Long sort;

    @TableField(exist = false)
    private List<MenusEntity> children;

    }