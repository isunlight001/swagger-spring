package com.spring.demo;

import org.springframework.beans.factory.annotation.Value;

public class Weapon2 {
	@Value("good")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
