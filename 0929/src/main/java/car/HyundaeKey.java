package car;

public class HyundaeKey implements BluetoothKey {
	HyundaeKey(){
		System.out.println("현대키 기본생성자호출");
	}


	@Override
	public void bootOn() {
		System.out.println("현대차키로 시동켜기!");
	}

	@Override
	public void bootOff() {
		System.out.println("현대차키로 시동끄기!");
	}

}
