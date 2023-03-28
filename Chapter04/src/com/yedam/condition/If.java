package com.yedam.condition;

import java.util.Scanner;

public class If {
	public static void main(String[] args) {
		//랜덤 값 추출
		// Math.random() -> 0 <= Math.random() < 1 : 실수
		
		int score = (int)(Math.random()*60)+40;
		System.out.println(score);
		if(score >=60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		String pass = (score>=60) ? "합격" : "불합격";
		System.out.println(pass);
		
		if(score>=90) {
			pass = "A";
		}
		else if(score >=80) {
			pass = "B";
		}
		else if(score >=70) {
			pass="C";
		}
		else {
			pass="D";
		}
		
		int number=(int)(Math.random()*6)+1;
		if(number==1) {
			System.out.println("1번 나옴");
		}
		else if(number==2) {
			System.out.println("2번 나옴");
		}
		else if(number==2) {
			System.out.println("3번 나옴");
		}
		else if(number==2) {
			System.out.println("4번 나옴");
		}
		else if(number==2) {
			System.out.println("5번 나옴");
		}
		else {
			System.out.println("6번 나옴");
		}
		
		//Scanner 활용
		Scanner sc = new Scanner(System.in);
		System.out.println("알파벳 입력 > ");
		String alp = sc.nextLine();
		//String -> char 
		char alpabet = alp.charAt(0);
		System.out.println(alpabet);
		if(alpabet >= 65 && alpabet<=90) {
			System.out.println(alp+"는 대문자");
		}else if(alpabet >= 97 && alpabet<=122) {
			System.out.println(alp+"는 소문자");
		}else {
			System.out.println("입력한 문자는 대,소문자가 아님");
		}
	}
}
