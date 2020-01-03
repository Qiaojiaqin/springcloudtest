package com.cloud.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @GetMapping("/rest")
    public String Test() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.baidu.com/",String.class);
    }

    /**
     * 在配置文件总读取端口配置信息
     */
    @Value("${server.port}")
    String port;

    /**
     * 启动client端，使用client端口号访问路径：
     * http://localhost:8888/hi?name=qiao
     */
    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return "hi " + name +",I am from port :" + port;
    }

}
