package com.dragee.config.mybatisPlus;


import com.baomidou.mybatisplus.extension.p6spy.P6SpyLogger;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tys on 11/2/20
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public P6SpyLogger p6SpyLogger() {
        return  new P6SpyLogger();
    }
}
