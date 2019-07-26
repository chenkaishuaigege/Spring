package service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SQLLiteTransaction {

    @Before("execution(* service.*(..))")
    public void before(){
        System.out.println("开起连接");
    }

    @After("execution(* service.*(..))")
    public void after(){
        System.out.println("提交事务");
        System.out.println("关闭连接");
    }

}
