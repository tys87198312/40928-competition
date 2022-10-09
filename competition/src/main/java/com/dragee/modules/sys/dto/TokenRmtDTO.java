package com.dragee.modules.sys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tys on 11/23/20
 */
@Data
@AllArgsConstructor
public class TokenRmtDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String key ;
    private String token;
    private String userid;
    private String userName;

}
