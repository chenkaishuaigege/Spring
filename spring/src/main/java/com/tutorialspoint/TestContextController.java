package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class TestContextController {

    Logger LOGGER = Logger.getLogger("LoggingDemo");

    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "/test.chtml", method = RequestMethod.GET)
    @ResponseBody
    public String test(HttpServletRequest request) {
        LOGGER.info("[TestController] Webapp version from servlet's context :"+request.getServletContext().getAttribute("webappVersion"));
        LOGGER.info("[TestController] Found secretData bean :"+context.getBean("student"));
        return "test";
    }

    @RequestMapping(value = "/test.html", method = RequestMethod.GET)
    @ResponseBody
    public String guestTest(HttpServletRequest request) {
        ServletContext asf = request.getServletContext();

        LOGGER.info("[TestController] Webapp version from servlet's context :"+request.getServletContext().getAttribute("webappVersion"));
        LOGGER.info("[TestController] Found secretData bean :"+context.getBean("student"));
        return "test";
    }

}
