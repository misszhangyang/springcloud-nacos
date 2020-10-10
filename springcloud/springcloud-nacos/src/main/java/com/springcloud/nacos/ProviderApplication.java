package com.springcloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yangzhang
 * @Description: 启动类
 * @Date: 2020/10/6 1:31 下午
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
        System.out.println("服务提供者启动成功");
    }

}
