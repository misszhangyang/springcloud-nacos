package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yangzhang
 * @Description: 启动类
 * @Date: 2020/10/2 12:23 上午
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
        System.out.println("服务提供者启动成功");
    }

}
