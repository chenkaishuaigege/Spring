package com.tutorialspoint;


import com.migo.scope.ShoppingCartRequest;
import com.migo.scope.ShoppingCartRequest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class ScopeTestController {

    @Autowired
    private ShoppingCartRequest shoppingCartRequest;

    @Autowired
    private ShoppingCartRequest2 shoppingCartRequest2;

    @RequestMapping(value = "/scopetest", method = RequestMethod.GET)
    public String test(HttpServletRequest request) {
        System.out.println("-------");
        System.out.println(shoppingCartRequest);
        System.out.println("-------");
        return "ScopeTestController请求完成";
    }


    @RequestMapping(value = "/scopetest2", method = RequestMethod.GET)
    public String test2(HttpServletRequest request) {
        System.out.println("-------");
        System.out.println(shoppingCartRequest2);
        System.out.println("-------");
        return "ScopeTestController-test2请求完成";
    }
}
