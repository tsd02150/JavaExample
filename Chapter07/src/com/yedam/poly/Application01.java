package com.yedam.poly;

public class Application01 {
	public static void main(String[] args) {
		Child child = new Child();
		
		//자동타입 변환
//		Parent parent = child;
		/*
		 * 부모 클래스에 있는 내용을 사용을 하되,
		 * 만약 자식클래스에 부모 메소드가 재정의(오버라이딩)가 되어 있다면
		 * 부모 클래스에 메소드를 사용하지 않고! 자식클래스의 메소드를 사용한
		 * - 위에 성질(자동타입변환)을 활용해서 하나의 타입(부모타입)으로 다양한 형태,객체의 모습을 만든다
		 * - 많은 자식들이 있다면, 그 숫자만큼 다양한 형태, 객체의 모습을 만들 수가 있다.
		 * => 다형성
		 */
		
		Parent parent = new Child();
		
		parent.field="A";
		parent.method1();
		parent.method2();
		System.out.println();
		parent = new Child02();
		parent.method1();
		parent.method2();
		
	}
}
