package com.an.app.common;

import org.aspectj.lang.JoinPoint;


public class AfterThrowingAdvice {
	public void printLog(JoinPoint jp, Exception e) {
		// 바인드 변수 jp, obj ==>
		String name = jp.getSignature().getName();
		System.out.println("메서드명 : " + name);
		System.out.println("예외 : "+e);
		if(e instanceof IllegalArgumentException) {
			System.out.println("매개변수로 적절하지 않습니다.");
			System.out.println("1. id가 PK인데 0 또는 이미 존재하는 값으로 처리했는지 확인");
		}else if (e instanceof ArithmeticException) {
			System.out.println("0으로 나눌수 없습니다!");
			System.out.println("1. /0했는지 확인");
			System.out.println("2. 오타나는 구역있음 확인요망");
		}else if(e instanceof Exception) {
			System.out.println("미확인 예외입니다.");
		}


	}
}
