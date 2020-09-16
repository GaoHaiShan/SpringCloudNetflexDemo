package order8082.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderService {
    @GetMapping("/orders")
    public String getOrders(){
        return "ALL Orders" ;
    }
}
