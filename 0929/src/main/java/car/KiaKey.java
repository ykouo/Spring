package car;

public class KiaKey implements BluetoothKey {
	
	KiaKey(){
		System.out.println("���Ű �⺻������ȣ��");
	}
	
	@Override
	public void bootOn() {
		System.out.println("�����Ű�� �õ��ѱ�!");
	}

	@Override
	public void bootOff() {
		System.out.println("�����Ű�� �õ�����!");
	}

}
