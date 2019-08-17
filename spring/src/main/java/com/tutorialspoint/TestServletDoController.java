package com.tutorialspoint;


import Dumber.DumberRequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestServletDoController {

    @DumberRequestMapping(value = "/testController")
    @ResponseBody
    public String testController(HttpServletRequest request) {
        return ".controller";
    }


    @DumberRequestMapping(value = "/testController.do")
    @ResponseBody
    public String testControllerDo(HttpServletRequest request) {
        return ".doController";
    }

    @DumberRequestMapping(value = "/testController.v")
    @ResponseBody
    public String testControllerV(HttpServletRequest request) {
        return ".VController";
    }

    @DumberRequestMapping(value = "/testController.x")
    @ResponseBody
    public String testControllerX(HttpServletRequest request) {
        return ".XController";
    }



}
