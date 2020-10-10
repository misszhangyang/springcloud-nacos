package com.springcloud.consumer.controller;

import com.springcloud.consumer.feign.FeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangzhang
 * @Description: 接口测试
 * @Date: 2020/10/3 9:51 上午
 * @Version: 1.0
 */
@RestController
@RefreshScope
public class ConsumerController{

    @Autowired

    private FeignClients consumerFeign;

    @Value("${common.eureka}")
    private String commKey;

    @GetMapping("consumer")
    public String consumerFeign(){
        System.out.println("-----远程调用开始----" + commKey);
        return consumerFeign.service();
    }

}
