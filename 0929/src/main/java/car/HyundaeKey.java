package car;

public class HyundaeKey implements BluetoothKey {
	HyundaeKey(){
		System.out.println("����Ű �⺻������ȣ��");
	}


	@Override
	public void bootOn() {
		System.out.println("������Ű�� �õ��ѱ�!");
	}

	@Override
	public void bootOff() {
		System.out.println("������Ű�� �õ�����!");
	}

}
