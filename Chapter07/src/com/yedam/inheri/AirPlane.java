package com.yedam.inheri;

public /* final */ class AirPlane {
	//부모클래스
	public void land() {
		System.out.println("착륙합니다.");
	}
	
	public /* final */ void fly() {
		System.out.println("일반 비행입니다.");
	}
	public void takeOff() {
		System.out.println("이륙합니다.");
	}
}
