package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;
import java.util.logging.*;


@Controller
public class HelloController{


    @Autowired
    private ApplicationContext context;

    Logger logger = Logger.getLogger("LoggingDemo");

    //method = RequestMethod.GET
    @RequestMapping("/hello" )
    @ResponseBody
    public String printHello() {
        System.out.println("进入此方法");
        com.tutorialspoint.Student student = (com.tutorialspoint.Student) context.getBean("student");
        student.getName();
        student.getAge();
        //student.printThrowException();
        return student.toString();


//        logger.info("[TestController] Received application context :"+context);
//        ApplicationContext providerContext = ApplicationContextProvider.getApplicationContext();
//        logger.info("[TestController] Provider context is :"+providerContext);
//
//        if (this.context == providerContext) {
//            logger.info("[TestController] Both contextes are the same");
//        }
//
//        logger.info("[TestController] Message is :"+this.context.getMessage("testMessage", new Object[] {}, Locale.ENGLISH));
//        return "test";

    }

}
