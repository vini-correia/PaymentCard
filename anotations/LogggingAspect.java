//package JavaClasses.anotations;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.stereotype.Component;
//
//@Component
//@EnableAspectJAutoProxy
//@Aspect
//
//public class LogggingAspect {
//
//    @Around("@annotation(logExecution)")
//    public Object logExecution(ProceedingJoinPoint joinPoint, LogExecution logExecution) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//        System.out.println("Estou logando essa iformação " + "param 1 = " + logExecution.isLog() + " parm 2 = " + logExecution.attribute());
//        return joinPoint.proceed();
//    }
//
//
//}
