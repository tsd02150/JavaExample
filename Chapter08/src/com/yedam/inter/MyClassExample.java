package com.yedam.inter;

public class MyClassExample {
	public static void main(String[] args) {
		// 클래스 내부에 인터페이스를 활용해서 필드로 선언
		System.out.println("1)-------");
		MyClass myClass1 = new MyClass();
		myClass1.rc.turnOn();
		myClass1.rc.turnOff();
		
		// 생성자 매개변수로 넣어서 활용
		System.out.println("2)-------");
		MyClass myClass2 = new MyClass(new Audio());
		
		// 메소드
		System.out.println("3)-------");
		MyClass myClass3 = new MyClass();
		myClass3.mehtodA();
		
		System.out.println("4)-------");
		MyClass myClass4 = new MyClass();
		myClass4.methodB(new Television());
		myClass4.methodB(new Audio());
	}
}
