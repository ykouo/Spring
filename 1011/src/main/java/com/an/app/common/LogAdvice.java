package com.an.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Before("PointcutCommon.aPointcut()")
	public void printLog() {
		System.out.println("����Ͻ� �޼��带 �����ϱ� ���� ��µǴ� �α�!");
	}
}
