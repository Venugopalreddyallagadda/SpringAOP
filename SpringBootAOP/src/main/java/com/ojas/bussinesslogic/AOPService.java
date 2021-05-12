package com.ojas.bussinesslogic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPService {
	
	@Pointcut("execution(public void com.ojas.bussinesslogic.BussinessLogic.saveEmployee())")
	public void p1() {
		
	}
	
	@Before("p1()")
	public void tx() {
		System.out.println("Begin Tx");
	}
	
	@After("p1()") 
	public void commit() {
		System.out.println("Tx commited");
	}

	@AfterReturning("p1()")
	public void commitAr() {
		System.out.println("AfterReturning demo");
	}
	
	@AfterThrowing(value ="p1()",throwing ="th") 
	public void commitTh(Throwable th) {
		System.out.println("After Throwing Demo"+th.getMessage());
}
	
//	@Around("p1()")
//	public void aroundDemo(ProceedingJoinPoint jp) {
//		System.out.println("Before business method");
//		
//		try {
//			jp.proceed();
//		}
//		catch(Throwable e) {
//			e.printStackTrace();
//		}
//		System.out.println("After bussiness method");
//	}
	
}
