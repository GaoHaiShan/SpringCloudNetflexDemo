package user8080.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {
    @GetMapping("/user")
    public String userInfo(){
        return "user";
    }
}
