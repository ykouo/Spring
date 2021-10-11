package com.an.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
// AroundAdvice 메서드 수행속도 체크할때 많이 사용한다고 함
public class AroundAdvice {
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구 -1");
		System.out.println("메서드명 : "+pjp.getSignature().getName());
		StopWatch sw=new StopWatch();
		
		sw.start();
		
		Object obj=pjp.proceed();
		
		sw.stop();
		
		System.out.println("메서드 실행 소요시간 : " + sw.getTotalTimeMillis());
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구 -2");
		return obj;
	}
}
