package com.dragee.modules.vo;

import com.dragee.config.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author tys on 2022/10/9
 */
@Data
public class MakeScoreVO {
    private String competitionId;
    private List<Map<String, Object>> xs;
    private String scoreStandard;
}
