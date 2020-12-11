package user8080.demo.hystrix;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyHystrixCommand {

    String timeOut() default "1000";

    String fallback() default "";
}
