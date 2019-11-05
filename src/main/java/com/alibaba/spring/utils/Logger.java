package com.alibaba.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。1");

            rtValue = pjp.proceed(args);

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。2");

            return rtValue;

        }catch (Throwable t){
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。3");

            throw new RuntimeException(t);
        }finally {

            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。4");
        }
    }
}
