package com.atractor.com.firstAOP.advice;

import com.atractor.com.firstAOP.interceptor.TransactionAudith;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class KafkaAudithory {

    @Before("@annotation(com.atractor.com.firstAOP.interceptor.TransactionAudith)")
    public void producerKafkaAudoria(JoinPoint joinPoint){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        TransactionAudith transactionAudith= method.getAnnotation(TransactionAudith.class);


        System.out.println("signature----->"+ transactionAudith.topicEndpoint());

        System.out.println("method----->"+method.toString());
    }

}
