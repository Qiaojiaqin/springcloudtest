package com.cloud.ribbon.controller;

import com.cloud.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "qiao") String name) {
        return ribbonService.hi(name);
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance instance = loadBalancer.choose("eureka-client-8888");
        return instance.getHost() + ":" + instance.getPort();
    }
}
