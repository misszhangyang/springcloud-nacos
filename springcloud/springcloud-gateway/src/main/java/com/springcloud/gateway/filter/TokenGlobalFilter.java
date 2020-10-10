package com.springcloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @program: springcloud
 * @description: 自定义全局过滤器token
 * @author: Mr.ZhangYang
 * @create: 2020-10-10 10:58
 **/
public class TokenGlobalFilter implements GlobalFilter, Ordered {
    //从请求参数中获取token字段，如果能获取到就 pass，获取不到就直接返回401错误，
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    //全局过滤器的优先级大于自定义过滤器
    @Override
    public int getOrder() {
        return -100;
    }
}
