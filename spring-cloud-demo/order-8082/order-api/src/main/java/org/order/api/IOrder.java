package org.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "ORDER",fallback = IOrder.OrderFallback.class)
public interface IOrder {
    @GetMapping("/orders")
    String getOrders();

    class OrderFallback{
        public String getOrders(){
            return "服务请求超时，超时降级";
        }
    }
}
