package com.tutorialspoint;

import Dumber.DumberRequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class TestController {

    Logger LOGGER = Logger.getLogger("LoggingDemo");
    
    @DumberRequestMapping(value = "/test")
    @ResponseBody
    public String testSession(HttpServletRequest request) {
        LOGGER.info("Is dumber request ?"+request.getAttribute("isDumber"));
        LOGGER.info("Handled time ?"+request.getAttribute("handledTime"));
        return "testTemplate";
    }

    @DumberRequestMapping()
    @ResponseBody
    public String testSession2(HttpServletRequest request) {
        LOGGER.info("Is dumber request ?"+request.getAttribute("isDumber"));
        LOGGER.info("Handled time ?"+request.getAttribute("handledTime"));
        return "testTemplate2";
    }

}