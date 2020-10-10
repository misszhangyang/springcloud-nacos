package com.springcloud.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangzhang
 * @Description: 测试接口
 * @Date: 2020/10/2 9:05 下午
 * @Version: 1.0
 */
@RestController
public class ProviderController {

    @GetMapping("/service")
    public String service(){
        System.out.println("------接受到请求------");
        return "provider invoke";
    }

}
