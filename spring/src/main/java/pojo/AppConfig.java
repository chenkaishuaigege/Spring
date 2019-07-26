package pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//也可以使用@Component
//@ComponentScan
public class AppConfig {

    @Bean
    public Source source(){
        return new Source("苹果","加糖","小杯");
    }

    @Bean
    public Student student(){
        return new Student(123 , "chenkai");
    }

    @Bean
    public Message message(){
        return new Message();
    }

}
