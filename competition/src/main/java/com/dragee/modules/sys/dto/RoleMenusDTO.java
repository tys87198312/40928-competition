package com.dragee.modules.sys.dto;

import com.dragee.config.resolver.LongJsonDeserializer;
import com.dragee.config.resolver.LongJsonSerializer;
import com.dragee.modules.sys.entity.MenuTree;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

/**
 * @author tys on 12/22/20
 */
@Data
public class RoleMenusDTO {
    public RoleMenusDTO () {}
    public RoleMenusDTO (MenuTree mt) {
        this.menuId = mt.getMenuId();
        this.menuName = mt.getName();
    }
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long menuId;
    private String menuName;
    private boolean selected;
    private List<RoleMenusDTO> childs;
}
