package aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectModule {

    @Pointcut("execution(* pojo.*.*(..))") // expression
    private void businessService() {}  // signature

    @Pointcut("execution(* pojo.Student.getName(..))")
    private void getname() {}

    @Before("execution(* pojo.*.*(..))")
    public void doBeforeTask(){}


}
