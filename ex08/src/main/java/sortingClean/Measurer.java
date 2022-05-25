package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Measurer {
    @Pointcut("@annotation(Measurable) && execution(* *(..))")
    private void selectMeasurable(){}

    @Before("selectMeasurable()")
    public void beforeMeasurable(JoinPoint jp){
        System.out.println("Calling loggable function " + jp.getSignature().getName() + " from "+jp.getThis() +"\n");
    }


}
