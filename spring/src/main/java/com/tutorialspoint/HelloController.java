package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController{

    //method = RequestMethod.GET
    @RequestMapping("/hello" )
    @ResponseBody
    public String printHello() {
        System.out.println("进入此方法");
        return "success";
    }

}
