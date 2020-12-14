package spring.model.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopAdvice {
	
	// aop 동작 순서
	// berfor -> around -> main -> around -> after
	
	public void test() {
		System.out.println("aop advice run");
	}
	
	public void after() {
		System.out.println("aop after run");
	}
	
	// around = 타겟 전/후로 동작
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("target="+jp.getTarget());
		System.out.println("args="+jp.getArgs());
		System.out.println("class="+jp.getClass());
		System.out.println("this="+jp.getThis());
		System.out.println("signature="+jp.getSignature());
		
		// 흐름을 이어주는 역할
		jp.proceed();
		return "1214/test";
	}
}
