package xh.zero.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

    @Before("pointcut()")
    public void before() {
        System.out.println("before....");
    }

    public void after() {
        System.out.println("after....");
    }

    @Around("pointcut()")
    public Object surrounding(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("surrounding before");
        Object process = joinPoint.proceed();
        System.out.println("surrounding after");
        return process;
    }

    @Pointcut("execution(public void xh.zero.aop.Target.*())")
    public void pointcut() {

    }
}

