package com.dragee.modules.sys.vo;

import lombok.Data;

/**
 * @author tys on 12/22/20
 */
@Data
public class RoleSubmitDataUsersVo {
    private LabelAndValue[] users;
    private String role;
    private String roleName;
}
