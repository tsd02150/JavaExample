package com.yedam.access;

public class Member {
	//외부에서 접근은 못하지만 공유가 가능한 객체를 생성
	
	//외부에서 접근하지 못하게하고 단 하나만의 객체 생성
	
	private static Member member = new Member();
	//외부에서 Member클래스의 객체를 만들지 못하도록
	private Member() {
		
	}
	//member 객체를 외부에서 사용할 수 있는 접근 메소드
	public static Member getInstance() {
		return member;
	}
	
	public void getInfo() {
		System.out.println("싱글톤 내부 getInfo 메소드 실행");
		System.out.println("나이 출력 : "+age);
	}
	public int age=10;
}
