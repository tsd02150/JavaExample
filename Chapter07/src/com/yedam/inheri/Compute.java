package com.yedam.inheri;

public class Compute extends Calculator{
	//자식클래스
	//메소드 재정의
		
	@Override //어노테이션 : 소스를 컴파일 할때 오버라이딩 된 메소드가 있다고 컴파일러에게 알려주기위한 용도
	double areaCircle(double r) {
		System.out.println("자식클래스의 메소드 실행");
		return Math.PI*r*r;
	}
}
