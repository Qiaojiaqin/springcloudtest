package com.cloud.feign.inter;

import com.cloud.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//通过@FeignClient指定调用哪个服务
@FeignClient(value = "eureka-client-8888",configuration = FeignConfig.class)
public interface EurekaClientFeign {
    @GetMapping(value = "/hi")
    String sayHiFromEurekaClient(@RequestParam(value = "name") String name);
}
