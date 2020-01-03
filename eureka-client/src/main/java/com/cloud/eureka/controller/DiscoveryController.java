package com.cloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        //得到eureka拥有的微服务
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        //得到名称为EUREKA-CLIENT的微服务
        List<ServiceInstance> srvList = client.getInstances("EUREKA-CLIENT-8888");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }


}
