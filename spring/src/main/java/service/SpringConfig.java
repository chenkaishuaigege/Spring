package service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import pojo.Message;
import service.impl.SQLLiteServiceImpl;

@ComponentScan(basePackages = {"pojo", "service.*"})
public class SpringConfig {

    @Bean
    public Message message(){
        return new Message();
    }

    @Bean
    public SQLLiteServiceImpl SQLLiteServiceImpl(){
        return new SQLLiteServiceImpl();
    }
}
