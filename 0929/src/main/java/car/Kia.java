package car;

import java.util.List;
import java.util.Map;

public class Kia extends Car{
	// �������
	private BluetoothKey bk;
	private int num;
	private List<String> list;
	private Map<String, String> map;
	// ������
	Kia(){
		System.out.println("����� �⺻������!");
	}
	Kia(BluetoothKey bk){
		this.bk = bk;
		System.out.println("����� +�������Ű ������!");
	}		
	// Getter & Setter
	public BluetoothKey getBk() {
		return bk;
	}
	public void setBk(BluetoothKey bk) {
		this.bk = bk;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	 
	public List<String> getList() {
		return list;
	} 
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
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
