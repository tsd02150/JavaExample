package com.yedam.oop;

public class Application {
	public static void main(String[] args) {
		SmartPhone s1 = new SmartPhone();
		//s1 객체에 정보대입
		s1.name = "아이폰";
		s1.maker = "애플";
		s1.price = 12000;
		//s1 객체의 메소드 사용
		s1.getInfo();
		System.out.println(s1.name);
		System.out.println(s1.maker);
		System.out.println(s1.price);
		
		SmartPhone s2 = new SmartPhone();
		System.out.println(s2.name);
		System.out.println(s2.maker);
		System.out.println(s2.price);

	}
}
