package com.an.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	public void printLog(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = jp.getSignature().getName();
		// 현재 어떤 메서드를 사용하는지 알아보기 위해 많이 사용한다.
		//jp.getSignature(); // 함수의 3요소 input, output, 기능 을 알 수 있다.
		System.out.println("메서드명 : "+name);
		System.out.println("매개변수정보:"+args[0]);
		System.out.println(" 핵심관심후에 호출됨");
	}
}
