package Dumber;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.util.Random;

public class CustomizedContextLoader extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("[CustomizedContextLoader] Loading context");
        // this value could be read from data source, but for the simplicity reasons, we put it statically
        // number is random because we want to prove that the root context is loaded only once
        Random random = new Random();
        int version = random.nextInt(100001);
        System.out.println("Version set into servlet's context :"+version);
        event.getServletContext().setAttribute("webappVersion", version);
        super.contextInitialized(event);
    }

}
