package com.springcloud.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: yangzhang
 * @Description: 启动类
 * @Date: 2020/10/1 11:31 下午
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class InterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterfaceApplication.class,args);
    }

}
