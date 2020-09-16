package org.order.config;

import org.order.api.IOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    @ConditionalOnMissingBean
    public IOrder.OrderFallback orderFallback(){
        return new IOrder.OrderFallback();
    }
}
