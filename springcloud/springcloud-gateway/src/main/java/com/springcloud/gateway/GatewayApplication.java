package com.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author: yangzhang
 * @Description: 启动类
 * @Date: 2020/10/8 3:40 下午
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
        System.out.println("网关启动成功");
    }
}
