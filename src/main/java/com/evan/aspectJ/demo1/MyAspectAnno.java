package com.evan.aspectJ.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/*
切面类
 */
@Aspect
public class MyAspectAnno {

    //所有方法前置增强
    //@Before(value = "execution(* com.evan.aspectJ.demo1.ProductDao.*(..))")
    //save方法前置增强
    @Before(value = "myPointcut1()")
    // 通过joinPoint参数获得切点信息
    public void befor(JoinPoint joinPoint){
        System.out.println("前置通知============"+joinPoint);
    }

    // 通过returning属性可以获得定义方法的返回值
    // @AfterReturning(value = "execution(* com.evan.aspectJ.demo1.ProductDao.update(..))",returning = "result")
    @AfterReturning(value = "myPointcut1()", returning = "result")
    public void afterReturing(Object result){
        System.out.println("后置通知============"+result);
    }

    @Around(value = "myPointcut3()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知==========");
        Object object = joinPoint.proceed(); // 执行目标方法
        System.out.println("环绕后通知==========");
        return object;
    }

    @AfterThrowing(value = "myPointcut4()",throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println("异常抛出通知========="+e);
    }

    @After(value = "myPointcut5()")
    public void after(){
        System.out.println("最终通知============");
    }

    @Pointcut(value = "execution(* com.evan.aspectJ.demo1.ProductDao.save(..))")
    private void myPointcut1(){}

    @Pointcut(value = "execution(* com.evan.aspectJ.demo1.ProductDao.update(..))")
    private void myPointcut2(){}

    @Pointcut(value = "execution(* com.evan.aspectJ.demo1.ProductDao.delete(..))")
    private void myPointcut3(){}

    @Pointcut(value = "execution(* com.evan.aspectJ.demo1.ProductDao.findeOne(..))")
    private void myPointcut4(){}

    @Pointcut(value = "execution(* com.evan.aspectJ.demo1.ProductDao.findeAll(..))")
    private void myPointcut5(){}
}
