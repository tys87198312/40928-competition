package com.dragee.config.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * @author tys on 11/2/20
 */
@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean
    public ExecutorService executorService() {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                corePoolSize * 10,
                corePoolSize * 20,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        poolExecutor.allowCoreThreadTimeOut(true);
        return poolExecutor;
    }

}
