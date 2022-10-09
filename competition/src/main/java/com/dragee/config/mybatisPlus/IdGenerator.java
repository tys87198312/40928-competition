package com.dragee.config.mybatisPlus;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.dragee.utils.IdUtils;
import org.springframework.stereotype.Component;


/**
 * @author tys on 2021/5/13
 */
@Component
public class IdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        long id = IdUtils.getId();
        return id;
    }
}
