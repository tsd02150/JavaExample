package com.yedam.abs;

public class PhoneExample {
	public static void main(String[] args) {
		Phone p1 = new SmartPhone("박또치"); 
		System.out.println(p1.owner);
		p1.turnOn();
		p1.turnOff();
	}
}
