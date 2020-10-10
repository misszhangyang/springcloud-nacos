package com.springcloud.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: yangzhang
 * @Description: feign客户端
 * @Date: 2020/10/3 10:15 上午
 * @Version: 1.0
 */
@FeignClient(value = "quickstart-provider")
public interface FeignClients {
    /**
     * 调用服务的方法
     * @return
     */
    @GetMapping("/service")
    String service();
}
