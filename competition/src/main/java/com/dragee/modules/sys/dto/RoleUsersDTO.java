package com.dragee.modules.sys.dto;

import lombok.Data;

/**
 * @author tys on 12/22/20
 */
@Data
public class RoleUsersDTO {
    private String userId;
    private String userName;
    private boolean selected;
}
