package com.an.app.common;

import org.aspectj.lang.JoinPoint;

import model.mem.MemVO;

public class AfterReturningAdvice {
	
	public void printLog(JoinPoint jp, Object obj) {
						// 바인드 변수 jp, obj ==> 
		String name = jp.getSignature().getName();
		System.out.println("메서드명 : " + name);
		MemVO data = (MemVO) obj;
		if (obj instanceof MemVO) { 
		// 앞에있는 변수가 뒤에있는 타입으로 캐스팅이 되는 지 확인하는 instanceof 
			if (data.getRole().equals("admin")) {
				System.out.println("관리자로그인");
			} else {
				System.out.println("사용자로그인");
			}
		}
		System.out.println("매개변수 정보: ");
		System.out.println(" get()와 조합되는 returning");

	}
}
