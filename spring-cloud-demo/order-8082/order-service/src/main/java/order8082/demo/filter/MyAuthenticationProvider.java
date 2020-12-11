package order8082.demo.filter;

import org.checkerframework.checker.units.qual.C;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

public class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return new UsernamePasswordAuthenticationToken("haishan","haishan",new LinkedList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
