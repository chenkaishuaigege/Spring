package com.tutorialspoint;

import config.OutPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Locale;
import java.util.logging.*;


@Controller
public class HelloController{


    @Autowired
    private ApplicationContext context;

    Logger logger = Logger.getLogger("LoggingDemo");

    @RequestMapping("/hello" )
    @ResponseBody
    public String printHello() {

//        com.tutorialspoint.Student student = (com.tutorialspoint.Student) context.getBean("student");
//        student.getName();
//        student.getAge();
//        ApplicationContext providerContext = ApplicationContextProvider.getApplicationContext();
//        logger.info("[TestController] Received application context :"+context);
//        logger.info("[TestController] Provider context is :"+providerContext);
//
//        if (this.context == providerContext) {
//            logger.info("[TestController] Both contextes are the same");
//        }
        OutPut fsad = (OutPut) context.getBean("helloworl");
        fsad.helloworld();
        return "3123";
    }

}
