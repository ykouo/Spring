package day06;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("champ")
public class Champ implements ChampAction {
//public abstract class Champ implements ChampAction {
// implements ChampAction 2가지 선택이 가능
	// 1) public abstract class Champ implements ChampAction 을 하거나
	//    강제성을 자식 클래스에게 토스 할 수 있음  
	// 2) ChampAction을 오버라이딩하거나 
	
	// 멤버변수 
	private String name;
	private List<String> inven;
	//@Autowired //컨테이너는 자신이 만들어 두었던 객체의 타입을 확인!
	@Resource(name="bow") // 타입도 보고 이름도 보는 어노테이션
	private Weapon weapon;

	// Getter & Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getInven() {
		return inven;
	}
	public void setInven(List<String> inven) {
		this.inven = inven;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	@Override
	public void attack() {
		weapon.attack();
		// NullPointerException 발생우려가 있으니 new 했어야했다!
		// ==> 불필요한 객체가 생성됨
		// --> 멤버변수로 처리 후 생성자 인젝션을 했음
		// --> 세터 주입으로 변경 (기본 생성자가 필요!)
	}
	@Override
	public void print() {
		System.out.println(name);
		for(String v:inven) {
			System.out.println(v);
		}
		
	}

}
