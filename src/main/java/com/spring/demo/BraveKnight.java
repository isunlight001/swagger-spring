package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BraveKnight {
	private Weapon weapon;

	public BraveKnight(Weapon weapon) {
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return weapon;
	}
	public static void main(String[] args) {
	       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	       BraveKnight knight = context.getBean(BraveKnight.class);
	       // knife
	       System.out.println(knight.getWeapon().getType());
	       context.close();
	   }
}
