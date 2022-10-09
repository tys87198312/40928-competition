package com.dragee.modules.business.dto;

import com.dragee.modules.business.entity.CompetitionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author tys on 2022/10/9
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompetitionDetailDTO {

    private CompetitionEntity competition;
    private List<Map<String, Object>> xs;
    private List<Map<String, Object>> pw;
}
