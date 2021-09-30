package car;

import java.util.List;
import java.util.Map;

public class Hyundae extends Car{
	private BluetoothKey bk;
	private int num;
	private List<String> list;
	private Map<String, String> map;

	Hyundae(){
		System.out.println("������ �⺻������!");
	}
	Hyundae(BluetoothKey bk){
		this.bk = bk;
		System.out.println("������ +�������Ű ������!");
	}	
	
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
	@Override
	public void bootOn() { 
		bk.bootOn();
		System.out.println("Hyundae �õ� On!");		
	}

	@Override
	public void gearP() {
		System.out.println("Hyundae �����ġ : Parking");
	}

	@Override
	public void gearN() {
		System.out.println("Hyundae �����ġ : Neutral");
	}

	@Override
	public void gearR() {
		System.out.println("Hyundae �����ġ : Reverse ");
	}

	@Override
	public void gearD() {
		System.out.println("Hyundae �����ġ : Drive");
	}

	@Override
	public void br() {
		System.out.println("Hyundae �극��ũ! ����!!!");
	}

	@Override
	public void accelerator() {
		System.out.println("Hyundae �׼�������! SpeedUp");
	}

	@Override
	public void bootOff() {
		bk.bootOff();
		System.out.println("Hyundae �õ� Off!");
	}
}
