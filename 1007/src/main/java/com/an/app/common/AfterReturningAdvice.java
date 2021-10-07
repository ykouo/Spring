package com.an.app.common;

import org.aspectj.lang.JoinPoint;

import model.mem.MemVO;

public class AfterReturningAdvice {
	
	public void printLog(JoinPoint jp, Object obj) {
						// ���ε� ���� jp, obj ==> 
		String name = jp.getSignature().getName();
		System.out.println("�޼���� : " + name);
		MemVO data = (MemVO) obj;
		if (obj instanceof MemVO) { 
		// �տ��ִ� ������ �ڿ��ִ� Ÿ������ ĳ������ �Ǵ� �� Ȯ���ϴ� instanceof 
			if (data.getRole().equals("admin")) {
				System.out.println("�����ڷα���");
			} else {
				System.out.println("����ڷα���");
			}
		}
		System.out.println("�Ű����� ����: ");
		System.out.println(" get()�� ���յǴ� returning");

	}
}
