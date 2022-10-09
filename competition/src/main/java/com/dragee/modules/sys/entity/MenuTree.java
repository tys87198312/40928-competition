package com.dragee.modules.sys.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author tys on 11/23/20
 */
@Data
@ToString
public class MenuTree {
    private Long menuId;
    private String name;
    private String url;
    private String icon;
    private List<MenuTree> children;

    public MenuTree(MenusEntity e) {
        this.name = e.getMenuName();
        this.url = e.getUrl();
        this.icon = e.getIcon();
        this.menuId = e.getMenuId();
    }
    public MenuTree() {}
}
