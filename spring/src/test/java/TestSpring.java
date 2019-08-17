import config.OutPut;
import config.SpringConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void test2(){

        // 通过注解的方式初始化 Spring IoC 容器
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OutPut outPut = context.getBean("helloworl", OutPut.class);
        outPut.helloworld();
    }

}
