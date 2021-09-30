package car;

import java.util.List;
import java.util.Map;

public class Car implements CarInter {
	// 멤버변수
	private BluetoothKey bk;
	private int num;
	private List<String> list;
	private Map<String, String> map;

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

	// 생성자
	Car() {
		System.out.println("차 기본생성자 호출!");
	}

	@Override
	public void bootOn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gearP() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gearN() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gearR() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gearD() {
		// TODO Auto-generated method stub

	}

	@Override
	public void br() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accelerator() {
		// TODO Auto-generated method stub

	}

	@Override
	public void bootOff() {
		// TODO Auto-generated method stub

	}

}
