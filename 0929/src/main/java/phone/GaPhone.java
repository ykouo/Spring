package phone;

public class GaPhone implements Phone {
	private Watch watch;
	
	public GaPhone() {
		System.out.println("������ �⺻������ ȣ��!");
	}
	public GaPhone(Watch watch) { // ��? �� ���ÿ�ġ ����;�����.. �ϸ� ���� ���յ��� ���� �ڵ忩�� SmartWatch�� AppleWatch�� ������ �ٲ����
		this.watch = watch;
		System.out.println("������ ������ ȣ��!");
	}
	public GaPhone(Watch watch,String name) { // ��? �� ���ÿ�ġ ����;�����.. �ϸ� ���� ���յ��� ���� �ڵ忩�� SmartWatch�� AppleWatch�� ������ �ٲ����
		this.watch = watch;
		System.out.println(name+"�� ������"); 
		System.out.println("������ ������ ȣ��!");
	}
	@Override
	public void power() {
		System.out.println("Galaxy!");
		
	}

	@Override
	public void soundUp() {
		//SmartWatch sw = new SmartWatch();
		watch.soundUp();
		//System.out.println("������ �Ҹ� ++");
	}

	@Override
	public void soundDown() {
		//SmartWatch sw = new SmartWatch();
		watch.soundDown();		
		//System.out.println("������ �Ҹ� --");
	}

}
