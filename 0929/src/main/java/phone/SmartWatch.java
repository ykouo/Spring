package phone;

public class SmartWatch implements Watch {

	public SmartWatch() {
		System.out.println("����Ʈ��ġ �⺻������ ȣ��!");
	}
	
	@Override
	public void soundUp() {
		System.out.println("����Ʈ��ġ�� �Ҹ� ++");		
	}

	@Override
	public void soundDown() {
		System.out.println("����Ʈ��ġ�� �Ҹ� --");	
		
	}

}
