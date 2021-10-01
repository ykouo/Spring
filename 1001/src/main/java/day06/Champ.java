package day06;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("champ")
public class Champ implements ChampAction {
//public abstract class Champ implements ChampAction {
// implements ChampAction 2���� ������ ����
	// 1) public abstract class Champ implements ChampAction �� �ϰų�
	//    �������� �ڽ� Ŭ�������� �佺 �� �� ����  
	// 2) ChampAction�� �������̵��ϰų� 
	
	// ������� 
	private String name;
	private List<String> inven;
	//@Autowired //�����̳ʴ� �ڽ��� ����� �ξ��� ��ü�� Ÿ���� Ȯ��!
	@Resource(name="bow") // Ÿ�Ե� ���� �̸��� ���� ������̼�
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
		// NullPointerException �߻������ ������ new �߾���ߴ�!
		// ==> ���ʿ��� ��ü�� ������
		// --> ��������� ó�� �� ������ �������� ����
		// --> ���� �������� ���� (�⺻ �����ڰ� �ʿ�!)
	}
	@Override
	public void print() {
		System.out.println(name);
		for(String v:inven) {
			System.out.println(v);
		}
		
	}

}
