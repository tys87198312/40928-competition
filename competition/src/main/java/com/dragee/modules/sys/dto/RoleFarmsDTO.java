package com.dragee.modules.sys.dto;

import lombok.Data;

import java.util.List;

/**
 * @author tys on 12/22/20
 */
@Data
public class RoleFarmsDTO {
    private String farmCode;
    private String farmName;
    private boolean selected;
    private List<RoleCarsDTO> cars;
}
