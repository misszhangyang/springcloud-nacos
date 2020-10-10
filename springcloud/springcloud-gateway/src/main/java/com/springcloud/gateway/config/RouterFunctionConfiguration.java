package com.springcloud.gateway.config;

import com.springcloud.gateway.filter.ElapsedFilter;
import com.springcloud.gateway.filter.TokenGlobalFilter;
import com.springcloud.gateway.handler.HystrixFallbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @Classname RouterFunctionConfiguration
 * @Description 路由配置信息 特殊请求直接在此处理，不进行路由转发
 * @Author Created by yak
 * @Date 2019-09-04 11:54
 * @Version 1.0
 */
@Configuration
public class RouterFunctionConfiguration {

    @Autowired
    private HystrixFallbackHandler hystrixFallbackHandler;

    //熔断
    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(
                RequestPredicates.path("/fallback")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), hystrixFallbackHandler);

    }

    //自定义局部过滤器
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/api/service")
                        .filters(f -> f.stripPrefix(1)
                                .filter(new ElapsedFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://quickstart-provider")
                        .order(0)
                        .id("quickstart-provider")
                )
                .build();
        // @formatter:on
    }

    //自定义全局过滤器
    @Bean
    public TokenGlobalFilter tokenFilter(){
        return new TokenGlobalFilter();
    }


}
