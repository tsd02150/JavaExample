package com.yedam.access;

public class Application02 {
	public static void main(String[] args) {
		// 인스턴스 생성
		Student std = new Student();

		std.setStdName("김또치");
		std.setStdGrade("2학년");
		std.setMajor("컴공");
		std.setPrograming(100);
		std.setDatabase(50);
		std.setOs(100);

		System.out.println("이름 : " + std.getStdName());
		System.out.println("학과 : " + std.getMajor());
		System.out.println("학년 : " + std.getStdGrade());
		System.out.println("프로그래밍 점수 : " + std.getPrograming());
		System.out.println("디비 점수 : " + std.getDatabase());
		System.out.println("운영체제 점수 : " + std.getOs());
		System.out.println();

		std.getInfo();
	}
}
