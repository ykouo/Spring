package phone;

public class IPhone implements Phone{
	private Watch watch;
	public IPhone() {
		System.out.println("아이폰 기본생성자 호출!");
		// watch= new AppleWatch();  코드의 결합도가 높아지니 비추 
	
	}
	public IPhone(Watch watch) {
		this.watch = watch; // 기본생성자를 사용하려고 하면 NullPointerException발생! 
							// 그렇기 때문에 setter injection 을 더 많이 사용함 
		System.out.println("아이폰 생성자 호출!");
	}
	@Override
	public void power() {
		System.out.println("Hello Apple");
		
	}

	@Override
	public void soundUp() {
		watch.soundUp();
		System.out.println("아이폰 소리 ++");
		
	}

	@Override
	public void soundDown() {
		watch.soundDown();
		System.out.println("아이폰 소리 --");
		
	}

}
