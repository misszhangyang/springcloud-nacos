package com.springcloud.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @program: springcloud
 * @description: redis动态限流
 * @author: Mr.ZhangYang
 * @create: 2020-10-09 15:48
 **/
@Configuration
public class RateLimiterConfig {

    //请求的ip限流，这里的bean名称需要在配置文件中对应起来配置，不然起不到效果
    @Bean(value = "remoteAddrKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    //请求的接口限流
//    @Bean(value = "remoteInterfaceResolver")
//    public KeyResolver apiKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getPath().value());
//    }
//
//    //用户限流，需要请求的的路径中携带userId参数
//    @Bean(value = "remoteUserIdResolver")
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
//    }
}
