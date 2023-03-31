package com.yedam.inheri;

public class Application04 {
	public static void main(String[] args) {
		SuperSonicAirPlane sa = new SuperSonicAirPlane();
		// sa -> flyMode normal 상태로 객체 생성
		
		sa.takeOff();
		sa.fly();
		sa.flyMode=SuperSonicAirPlane.SUPERSONIC;
		sa.fly();
		sa.flyMode=SuperSonicAirPlane.NORMAL;
		sa.fly();
		sa.land();
	}
}
