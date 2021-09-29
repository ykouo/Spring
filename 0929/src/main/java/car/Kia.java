package car;

public class Kia implements Car{
	// �������
	private BluetoothKey bk;

	// ������
	Kia(){
		System.out.println("����� �⺻������!");
	}
	Kia(BluetoothKey bk){
		this.bk = bk;
		System.out.println("����� +�������Ű ������!");
	}	
	 
	// �޼���
	@Override
	public void bootOn() {
		bk.bootOn();
		System.out.println("Kia �õ� On!");
		
	}

	@Override
	public void gearP() {
		System.out.println("Kia �����ġ : Parking");
	}

	@Override
	public void gearN() {
		System.out.println("Kia �����ġ : Neutral");
	}

	@Override
	public void gearR() {
		System.out.println("Kia �����ġ : Reverse ");
	}

	@Override
	public void gearD() {
		System.out.println("Kia �����ġ : Drive");
	}

	@Override
	public void br() {
		System.out.println("Kia �극��ũ! ����!!!");
	}

	@Override
	public void accelerator() {
		System.out.println("Kia �׼�������! �ӵ�����");
	}

	@Override
	public void bootOff() {
		bk.bootOff();
		System.out.println("Kia �õ� Off!");
	}

}
