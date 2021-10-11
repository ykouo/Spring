package com.an.app.common;

import org.aspectj.lang.JoinPoint;


public class AfterThrowingAdvice {
	public void printLog(JoinPoint jp, Exception e) {
		// ���ε� ���� jp, obj ==>
		String name = jp.getSignature().getName();
		System.out.println("�޼���� : " + name);
		System.out.println("���� : "+e);
		if(e instanceof IllegalArgumentException) {
			System.out.println("�Ű������� �������� �ʽ��ϴ�.");
			System.out.println("1. id�� PK�ε� 0 �Ǵ� �̹� �����ϴ� ������ ó���ߴ��� Ȯ��");
		}else if (e instanceof ArithmeticException) {
			System.out.println("0���� ������ �����ϴ�!");
			System.out.println("1. /0�ߴ��� Ȯ��");
			System.out.println("2. ��Ÿ���� �������� Ȯ�ο��");
		}else if(e instanceof Exception) {
			System.out.println("��Ȯ�� �����Դϴ�.");
		}


	}
}
