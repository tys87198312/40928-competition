package com.dragee.modules.sys.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class UserDTO {
    /**
     * userId
     */
    @TableId
    private Long userId;

    /**
     * 名字
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像
     */
    private String photo;

    /**
     * 地区
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

    /**
      角色
     */
   private String roleNames;

}
