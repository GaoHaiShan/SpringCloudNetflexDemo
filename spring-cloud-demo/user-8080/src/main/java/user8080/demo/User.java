package user8080.demo;

import org.order.api.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {

    @Autowired
    private IOrder order;

    @Autowired
    private IOrder.OrderFallback fallback;

    @GetMapping("/orders")
    public String orders(){

        return fallback.getOrders() + order.getOrders();
    }


}
