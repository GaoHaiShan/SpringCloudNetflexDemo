package order8082.demo;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class OrderService {
    @GetMapping("/orders")
    public String getOrders() throws InterruptedException {

//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//        Authentication authentication =
//                new TestingAuthenticationToken("username", "password", "ROLE_USER");
//        context.setAuthentication(authentication);
//        SecurityContextHolder.setContext(context);

        SecurityContext context1 = SecurityContextHolder.getContext();
        Authentication authentication1 = context1.getAuthentication();
        String username = authentication1.getName();
        Object principal = authentication1.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication1.getAuthorities();
        return "ALL Orders" ;
    }

}
