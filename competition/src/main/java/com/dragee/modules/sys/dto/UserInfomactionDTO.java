package com.dragee.modules.sys.dto;

import com.dragee.modules.sys.entity.MenuTree;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 用户信息 菜单 权限等
 *
 * @author tys on 11/25/20
 */
@Data
@Accessors(chain = true)
public class UserInfomactionDTO {
    List<String> perms;
    List<MenuTree> menus;
    private Long userId;
    private String name;
}

