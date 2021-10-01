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
	//@Autowried // Ʈ�����,�α�, ���ȵ�...
	private Weapon weapon;
	
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
