package car;

public class KiaKey implements BluetoothKey {
	
	KiaKey(){
		System.out.println("기아키 기본생성자호출");
	}
	
	@Override
	public void bootOn() {
		System.out.println("기아차키로 시동켜기!");
	}

	@Override
	public void bootOff() {
		System.out.println("기아차키로 시동끄기!");
	}

}
