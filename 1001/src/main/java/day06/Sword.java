package day06;

import org.springframework.stereotype.Component;



public class Sword implements Weapon{

	@Override
	public void attack() {
		System.out.println("검으로 공격!!");
	}

}
