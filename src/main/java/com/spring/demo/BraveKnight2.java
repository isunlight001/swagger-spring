package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BraveKnight2 {
	@Autowired
	private Weapon2 weapon;
	public Weapon2 getWeapon() {
		return weapon;
	}
	
}
