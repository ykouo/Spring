package com.an.app.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("pjp���ڸ� ���� �޼��忡�� ����ϴ� ���� -1");
		Object obj=pjp.proceed();
		System.out.println("pjp���ڸ� ���� �޼��忡�� ����ϴ� ���� -2");
		return obj;
	}
}
