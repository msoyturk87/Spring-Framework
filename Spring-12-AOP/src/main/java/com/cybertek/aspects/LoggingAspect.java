package com.cybertek.aspects;

import com.cybertek.controller.ProductController;
import com.cybertek.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {


Logger logger= LoggerFactory.getLogger(ProductController.class);

/*
    @Pointcut("execution(* com.cybertek.controller.ProductController.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void log(){
      logger.info("-------------");
    }
*/
    // 1===Execution
    // (Start with up methods )
    @Pointcut("execution(* com.cybertek.controller.ProductController.up*(..))")
    public void anyupdateOperation(){}

    // findById
    @Pointcut("execution(* com.cybertek.repository.ProductRepository.findById(Long))")
    public void anyProductRepositoryFindById(){}

    @Before("anyProductRepositoryFindById()")
    public void beforeProRepo(){
        logger.info("-------------");
    }
    //
    @Before("anyupdateOperation()")
    public void beforeUpdate(JoinPoint joinPoint){
        logger.info("Before -> Method {} - Arguments : {} - Target :{}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }


    // 2===Within
    // For all subpackage and class inside controller
    @Pointcut("within(com.cybertek.controller..*)")
    public void anyControllerOperation(){}

    // For all @Service annotation
    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceAnnotatedOperation(){}


    @Before("anyServiceAnnotatedOperation() || anyControllerOperation() ")
    public void beforeControllerAdvice2(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }



  /*  // 3===Annotation
    // For all subpackage and class inside controller
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void anyDeleteMapping(){}

    @Before("anyDeleteMapping()")
    public void deleteMappingAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method {} - Arguments : {} - Target :{}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }
    */






    //   ADVICE TYPES
    // 1-----  Before

    // 3===Annotation
    // For all subpackage and class inside controller
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void anyDeleteMapping(){}

    @Before("anyDeleteMapping()")
    public void deleteMappingAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method {} - Arguments : {} - Target :{}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }






    // 2-----  AfterReturning with Mono
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void anyGetMapping(){}

    @AfterReturning(pointcut = "anyGetMapping()",returning = "results")
    public void anyGetMapping(JoinPoint joinPoint, Product results){
        logger.info("After Returning(Mono Result) -> Method : {} - results : {}",joinPoint.getSignature().toShortString(),results);
    }


    // 2-----  AfterReturning with List
    @AfterReturning(pointcut = "anyGetMapping()",returning = "results")
    public void anyGetMapping2(JoinPoint joinPoint, Product results){
        logger.info("After Returning(List Result) -> Method : {} - results : {}",joinPoint.getSignature().toShortString(),results);
    }







    // 3-----  AfterThrowing
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation(){}

    @AfterThrowing(pointcut = "anyGetPutProductOperation()",throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint,RuntimeException exception){
        logger.info("After Throwing(Send Email to L2 Team) -> Method: {} - Exception : {}",joinPoint.getSignature().toShortString(),exception.getMessage());
    }






    // 4-----  After
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation2(){}

    @After("anyGetPutProductOperation2()")
    public void afterControllerAdvice(JoinPoint joinPoint){
        logger.info("After finally -> Method : {} - results :{}",joinPoint.getSignature().toShortString());
    }

    @After("anyGetPutProductOperation2()")
    public void afterControllerAdvice2(JoinPoint joinPoint){
        logger.info("After finally -> Method : {} - results :{}",joinPoint.getSignature().toShortString());
    }









    // 5-----  Around   it means Before and After it calculate execute time

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void anyPostProductOperation(){}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void anyPutProductOperation(){}

    @Around("anyPostProductOperation()")
    public Object anyPostControllerAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.info("Before(Method : {} - Parameters : {}",proceedingJoinPoint.getSignature().toShortString(),proceedingJoinPoint.getArgs());

        List<Product> results = new ArrayList<>();
//        results =(List<Product>) proceedingJoinPoint.proceed();

        logger.info("After(Method: {} - Results : {}",proceedingJoinPoint.getSignature().toShortString(),results);

        return results;
    }
}
