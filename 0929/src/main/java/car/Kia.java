package car;

import java.util.List;
import java.util.Map;

public class Kia extends Car{
	// 멤버변수
	private BluetoothKey bk;
	private int num;
	private List<String> list;
	private Map<String, String> map;
	// 생성자
	Kia(){
		System.out.println("기아차 기본생성자!");
	}
	Kia(BluetoothKey bk){
		this.bk = bk;
		System.out.println("기아차 +블루투스키 생성자!");
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
	// 메서드
	@Override
	public void bootOn() {
		bk.bootOn();
		System.out.println("Kia 시동 On!");
		
	}

	@Override
	public void gearP() {
		System.out.println("Kia 기어위치 : Parking");
	}

	@Override
	public void gearN() {
		System.out.println("Kia 기어위치 : Neutral");
	}

	@Override
	public void gearR() {
		System.out.println("Kia 기어위치 : Reverse ");
	}

	@Override
	public void gearD() {
		System.out.println("Kia 기어위치 : Drive");
	}

	@Override
	public void br() {
		System.out.println("Kia 브레이크! 멈춤!!!");
	}

	@Override
	public void accelerator() {
		System.out.println("Kia 액셀레이터! 속도업업");
	}

	@Override
	public void bootOff() {
		bk.bootOff();
		System.out.println("Kia 시동 Off!");
	}

}
