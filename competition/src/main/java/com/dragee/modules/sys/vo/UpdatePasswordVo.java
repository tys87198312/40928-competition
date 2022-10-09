package com.dragee.modules.sys.vo;

import com.dragee.config.resolver.LongJsonDeserializer;
import com.dragee.config.resolver.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class UpdatePasswordVo {

    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long userId;

    private String username;
    private String oldPassword;
    private String newPassword;
}
