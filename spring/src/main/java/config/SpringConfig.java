package config;


//import org.springframework.context.annotation.ComponentScan;

import com.tutorialspoint.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ComponentScan(basePackages = {"pojo" , "aspect"})
//@ComponentScan(basePackageClasses = com.tutorialspoint.Student.class)
@Configuration
public class SpringConfig {

    @Bean(name = "helloworl")
    public OutPut impl() {
        return new OutPutImpl();
    }

}