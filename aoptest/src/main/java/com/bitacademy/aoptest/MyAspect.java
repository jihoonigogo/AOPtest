package com.bitacademy.aoptest;



import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	
	@Before("execution(public ProductVo com.bitacademy.aoptest.ProductService.findProduct(..))")
	public void before() {
		System.out.println("call [before advice]");
	}
	
	//조건을 만족하는 메서드 실행이후
	@After("execution(* com.bitacademy.aoptest.*.findProduct(String))")
	public void after() {
		System.out.println("call [after advice]");
	}
	
	@AfterReturning(value="execution(* *..ProductService.findProduct(..))", returning="vo")
	public void afterReturning(ProductVo vo) {
		System.out.println("call [afterReturing advie]");
		System.out.println("메서드의 결과 객체" +vo);
	}
	
	//메서드 수행시 예외 발생 할때 예외 객체확인
	@AfterThrowing(value="execution(* findProduct(String))",throwing="ex")
	public void afterThrowing(Throwable ex) { //throwing="ex" 를받는다
		System.err.println("call [afterThrowing advice]");
		System.err.println("발생한 예외 정보 :"+ ex.getMessage());
	}
}
