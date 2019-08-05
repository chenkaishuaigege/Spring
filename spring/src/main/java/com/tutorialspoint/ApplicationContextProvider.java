package com.tutorialspoint;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// context provider, ApplicationContextProvider.java
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext c) throws BeansException {
        context = c;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

}