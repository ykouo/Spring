package test;

public class Test {
	int a;
	
	Test(){
		System.out.println("기본생성자 실행!");
	}
	
	public void print() {
		System.out.println("안녕!!! 나는 print()!");
	}
	
	public void initFunc() {
		System.out.println("멤버변수 초기화하는 함수 실행");
		a= 100;
	}
	
}
