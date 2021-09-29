package phone;

public class GaPhone implements Phone {
	private Watch watch;
	
	public GaPhone() {
		System.out.println("갤럭시 기본생성자 호출!");
	}
	public GaPhone(Watch watch) { // 어? 나 애플워치 쓰고싶어졌어.. 하면 현재 결합도가 높은 코드여서 SmartWatch를 AppleWatch로 일일히 바꿔야함
		this.watch = watch;
		System.out.println("갤럭시 생성자 호출!");
	}
	public GaPhone(Watch watch,String name) { // 어? 나 애플워치 쓰고싶어졌어.. 하면 현재 결합도가 높은 코드여서 SmartWatch를 AppleWatch로 일일히 바꿔야함
		this.watch = watch;
		System.out.println(name+"의 갤럭시"); 
		System.out.println("갤럭시 생성자 호출!");
	}
	@Override
	public void power() {
		System.out.println("Galaxy!");
		
	}

	@Override
	public void soundUp() {
		//SmartWatch sw = new SmartWatch();
		watch.soundUp();
		//System.out.println("갤럭시 소리 ++");
	}

	@Override
	public void soundDown() {
		//SmartWatch sw = new SmartWatch();
		watch.soundDown();		
		//System.out.println("갤럭시 소리 --");
	}

}
