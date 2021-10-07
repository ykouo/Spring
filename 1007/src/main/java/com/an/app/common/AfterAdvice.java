package com.an.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	public void printLog(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = jp.getSignature().getName();
		// ���� � �޼��带 ����ϴ��� �˾ƺ��� ���� ���� ����Ѵ�.
		//jp.getSignature(); // �Լ��� 3��� input, output, ��� �� �� �� �ִ�.
		System.out.println("�޼���� : "+name);
		System.out.println("�Ű���������:"+args[0]);
		System.out.println(" �ٽɰ����Ŀ� ȣ���");
	}
}
