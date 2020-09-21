package user8080.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.order.api.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class User {

    @Autowired
    private IOrder order;

    //熔断降级
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000"),
                    //打开熔断降级
                    @HystrixProperty(name="circuitBreaker.enabled",value="true"),
                    //默认值为　10秒内　达到　20　次请求，并且失败次数达到　50％　则触发熔断　为　5000毫秒
                    //20 次请求
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
                    //停止服务　5 秒
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
                    //请求失败次数大于　50％
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
            }
            ,fallbackMethod ="ordersFallback"
    )
    @GetMapping("/orders/{num}")
    public String orders(@PathVariable int num) throws Exception {
        if (num == 1){
            throw new Exception();
        }
        return order.getOrders();
    }

    public String ordersFallback(int num){
        return "熔断降级";
    }

    //超时降级
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000"),
            }
            ,fallbackMethod ="ordersFallback1"
    )
    @GetMapping("/orders1")
    public String orders1() throws Exception {
        return order.getOrders();
    }
    public String ordersFallback1(){
        return "超时降级";
    }

    //线程池限流
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000"),
                    @HystrixProperty(name="execution.isolation.strategy",value="THREAD"),
            }
            ,fallbackMethod ="ordersFallback2",threadPoolKey = "default"
    )
    @GetMapping("/orders2")
    public String orders2() throws Exception {
        return order.getOrders();
    }
    public String ordersFallback2(){
        return "访问人数过多-线程";
    }
    //线程池限流
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000"),
                    @HystrixProperty(name="execution.isolation.strategy",value="SEMAPHORE"),
                    @HystrixProperty(name="execution.isolation.semaphore.maxConcurrentRequests",value="3")
            }
            ,fallbackMethod ="ordersFallback3"
    )

    @GetMapping("/orders3")
    public String orders3() throws Exception {
        return order.getOrders();
    }
    public String ordersFallback3(){
        return "访问人数过多-访问数";
    }


}
