package Dumber;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * controller拦截器
 *
 * @author chenkai
 */
public class ControllerInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger("LoggingDemo");

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        logger.info("拦截器afterCompletion:");

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view) throws Exception {
        logger.info("拦截器postHandle:" + handler.toString());
    }


    /**
     * 请求之前进行拦截 preHandle
     * 值允许GET请求,不允许POST请求
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("拦截器preHandle:");
        logger.info("requestMethod : " + request.getMethod());
        String requestMethod = request.getMethod();
        if(requestMethod.equals("GET")){
            return true;
        }else{
            return false;
        }


    }



}
