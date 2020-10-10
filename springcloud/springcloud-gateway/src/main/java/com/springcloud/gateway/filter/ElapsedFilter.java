package com.springcloud.gateway.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @program: springcloud
 * @description: 自定义过滤器单个（全局使用实现接口为GlobalFilter）
 * @author: Mr.ZhangYang
 * @create: 2020-10-10 10:42
 * Filter 之后我们将它添加到我们的 Filter Chain => RouteFunctionConfiguration 里边
 **/
public class ElapsedFilter implements GatewayFilter, Ordered {
    private static final Log log = LogFactory.getLog(GatewayFilter.class);
    private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //存入当前时间
        // 怎么来区分是“pre”还是“post”呢？其实就是chain.filter(exchange)之前的就是“pre”部分，之后的也就是then里边的是“post”部分。
        //创建好 Filter 之后我们将它添加到我们的 Filter Chain 里边
        exchange.getAttributes().put(ELAPSED_TIME_BEGIN,System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(ELAPSED_TIME_BEGIN);
                    if(startTime != null){
                        //打印请求路径和耗时时间
                        log.info(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    //优先级Ordered中的int getOrder()方法是来给过滤器设定优先级别的，值越大则优先级越低。
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
