package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerAspect {

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始日志:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("结束日志:" + joinPoint.getSignature().getName());
        return object;
    }


}
