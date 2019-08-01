package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class FaviconController {

    @RequestMapping("**/favicon.ico")
    @ResponseBody
    void favicon() {}
}
