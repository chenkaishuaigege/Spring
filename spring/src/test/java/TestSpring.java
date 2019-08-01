import config.SpringConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Landlord;
import pojo.Student;
import pojo.Student2;
import pojo.Student3;

public class TestSpring {

//    @Autowired
//    Landlord landlord = null;
//
//    @Test
//    public void test1(){
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Landlord landlord = (Landlord) context.getBean("landlord", Landlord.class);
//        landlord.service();
//    }
//
//    @Test
//    public void test2(){
//
//        // 通过注解的方式初始化 Spring IoC 容器
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Landlord landlord = context.getBean("landlord", Landlord.class);
//        landlord.service();
//    }
//
//
//    //BeanTest1
//    @Test
//    public void BeanTest1(){
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = (Student) context.getBean("student", Student.class);
//        System.out.println(student.toString());
//    }
//
//    //BeanTest2
//    @Test
//    public void BeanTest2(){
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student2 student2 = (Student2) context.getBean("student2", Student2.class);
//        System.out.println(student2.toString());
//    }
//
//    //BeanTest3
//    @Test
//    public void BeanTest3(){
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student3 student3 = (Student3) context.getBean("student3", Student3.class);
//        System.out.println("Name : " + student3.getName() );
//        System.out.println("Age : " + student3.getAge() );
//
//    }
//
//    //BeanTest3
//    @Test
//    public void BeanTest4(){
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//        com.tutorialspoint.Student student = (com.tutorialspoint.Student) context.getBean("student4");
//        student.getName();
//        student.getAge();
//        student.printThrowException();
//    }
}

