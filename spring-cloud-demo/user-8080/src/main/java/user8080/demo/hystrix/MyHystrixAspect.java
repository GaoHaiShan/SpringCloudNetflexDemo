package user8080.demo.hystrix;


import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

@Aspect
public class MyHystrixAspect {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Pointcut(value = "@annotation(MyHystrixCommand)")
    public void pointCut(){}

    @Around(value ="pointCut()&&@annotation(hystrixCommand)" )
    public Object doHystrix(ProceedingJoinPoint joinPoint , MyHystrixCommand hystrixCommand) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InvocationTargetException {
        Long timeOut = Long.valueOf(hystrixCommand.timeOut());

        Future future = executorService.submit(()->{
            try {
              return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return null;
        });
        Object result = null;
        try {
            result = future.get(timeOut, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            future.cancel(true);
            if (StringUtils.isBlank(hystrixCommand.fallback())){
                e.printStackTrace();
            }else {
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                Class[] paramType = signature.getParameterTypes();
                Method fallback = joinPoint.getTarget().getClass().getMethod(hystrixCommand.fallback(),paramType);
                fallback.setAccessible(true);
                result = fallback.invoke(joinPoint.getTarget(),joinPoint.getArgs());
            }
        }


        return result;
    }
}
