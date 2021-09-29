package phone;

public class IPhone implements Phone{
	private Watch watch;
	public IPhone() {
		System.out.println("������ �⺻������ ȣ��!");
		// watch= new AppleWatch();  �ڵ��� ���յ��� �������� ���� 
	
	}
	public IPhone(Watch watch) {
		this.watch = watch; // �⺻�����ڸ� ����Ϸ��� �ϸ� NullPointerException�߻�! 
							// �׷��� ������ setter injection �� �� ���� ����� 
		System.out.println("������ ������ ȣ��!");
	}
	@Override
	public void power() {
		System.out.println("Hello Apple");
		
	}

	@Override
	public void soundUp() {
		watch.soundUp();
		System.out.println("������ �Ҹ� ++");
		
	}

	@Override
	public void soundDown() {
		watch.soundDown();
		System.out.println("������ �Ҹ� --");
		
	}

}
