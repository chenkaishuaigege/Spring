import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.*;
import service.ProductService;
import service.SQLLiteService;
import service.SpringConfig;
import service.StudentServiceImp;
import service.impl.SQLLiteServiceImpl;

public class TestSpring {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"}
        );

        Source source = (Source) context.getBean("source");

        System.out.println(source.getFruit());
        System.out.println(source.getSugar());
        System.out.println(source.getSize());
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"}
        );

        Source source = (Source) context.getBean("source");
        System.out.println(source.getFruit());
        System.out.println(source.getSugar());
        System.out.println(source.getSize());

        JuiceMaker juiceMaker = (JuiceMaker) context.getBean("juickMaker");
        System.out.println(juiceMaker.makeJuice());
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"}
        );
        ProductService productService = (ProductService) context.getBean("productService");
        productService.doSomeService();

    }

    @Test
    public void test4() {
        //ApplicationContext context = new ClassPathXmlApplicationContext( new String[]{"applicationContext.xml"} );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Source source = (Source) context.getBean("source");
        System.out.println(source.getFruit());
        System.out.println(source.getSugar());
        System.out.println(source.getSize());
    }

    @Test
    public void test5() {

        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        Source source = (Source) applicationContext.getBean("source");
        System.out.println(source.getFruit());
        System.out.println(source.getSugar());
        System.out.println(source.getSize());
    }

    @Test
    public void test6() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = (Student) context.getBean("student", Student.class);
        System.out.println(student.getId());
        System.out.println(student.getName());
    }

    @Test
    public void test7() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Message message = (Message) context.getBean("message", Message.class);
        System.out.println(message.getAge());
        System.out.println(message.getName());
    }


    @Test
    public void test8() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Message message = (Message) context.getBean("message", Message.class);
        System.out.println(message.getAge());
        System.out.println(message.getName());
    }

    @Test
    public void test9() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentServiceImp studentServiceImp = (StudentServiceImp) context.getBean("studentService", StudentServiceImp.class);
        studentServiceImp.printStudentInfo();
    }


    @Test
    public void test10() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SQLLiteService SQLLiteService = (SQLLiteService) context.getBean("landlord", SQLLiteService.class);
        SQLLiteService.insertService();
    }
}

