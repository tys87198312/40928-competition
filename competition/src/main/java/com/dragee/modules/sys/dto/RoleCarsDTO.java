package com.dragee.modules.sys.dto;

import lombok.Data;

/**
 * @author tys on 12/22/20
 */
@Data
public class RoleCarsDTO {
    private String license;
    private String carName;
    private boolean selected;

    public RoleCarsDTO () {}


}
