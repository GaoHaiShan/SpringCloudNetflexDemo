package user8080.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import user8080.demo.hystrix.MyHystrixAspect;
import user8080.demo.import_awre_test.ConfigTest;

@SpringBootApplication
@EnableHystrix
@EnableFeignClients(basePackages = {"org.order.api","org.example"})

public class DemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        MyHystrixAspect myHystrixAspect = applicationContext.getBean(MyHystrixAspect.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
