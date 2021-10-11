package com.an.app.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {
	
	// ���� �޼���
	// �����̽��� ����Ʈ���� "�ĺ�"�ϱ����� �ۼ�
	// ������ �ۼ��� �ʿ���� {}�ٵ���� �������
	
	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {}
	
	@Pointcut("execution(* model.mem.*Impl.get*(..))")
	public void cPointcut() {}
}
