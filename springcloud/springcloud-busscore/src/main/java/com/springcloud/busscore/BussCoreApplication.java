package com.springcloud.busscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: yangzhang
 * @Description: 启动类
 * @Date: 2020/10/1 11:20 下午
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class BussCoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(BussCoreApplication.class,args);
    }

}
