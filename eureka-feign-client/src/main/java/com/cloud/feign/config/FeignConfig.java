package com.cloud.feign.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.Encoder;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class FeignConfig {
    /**
     * 注入该bean之后，Feign会在远程调用失败之后重试
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }

}
