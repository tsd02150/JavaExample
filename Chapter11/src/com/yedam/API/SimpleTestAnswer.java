package com.yedam.API;

import java.util.Scanner;

public class SimpleTestAnswer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 문제1
		System.out.println("문자열 입력");
		String str = sc.nextLine();
		String str2 = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			char temp = str.charAt(i);
			str2 += temp;
		}
		System.out.println(str2);

		// 문제2
		int alpha = 0;
		int number = 0;
		int blank = 0;
		System.out.println("문자열 입력");
		String str3 = sc.nextLine();
		for (int i = 0; i < str3.length(); i++) {
			char temp = str3.charAt(i);
			if (temp == ' ') {
				blank++;
			} else if (temp >= '0' && temp <= '9') {
				number++;
			} else if ((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')) {
				alpha++;
			}
		}
		System.out.println("공백 : " + blank + " 숫자 : " + number + " 알파벳 : " + alpha);

		// 문제3
		System.out.println("문자열 입력");
		String str4 = sc.nextLine();
		String str10 = "";
		char charTemp = str4.charAt(0);
		int count = 1;
		for (int i = 1; i < str4.length(); i++) {
			if (charTemp == str4.charAt(i)) {
				count++;
			} else {
				str10 = str10+ charTemp + count;
				count = 1;
			}
			charTemp = str4.charAt(i);
			if(str4.length()-1 == i) {
				str10 = str10+ charTemp+count;
			}
		}
		System.out.println(str10);

		// 문제4
		// 1. 계산식 (하드코딩)
		// 1-1) 2000년 이후 2023년 이전 출생 : 23 - 태어난년도 + 1
		// 1-2) 1922년 이후 2000년 이전 출생 : 123 - 태어난년도 + 1
		System.out.println("생년월일");
		String birth = sc.nextLine();
		int birthNo = Integer.parseInt(birth.substring(0, 2));
		if (birthNo <= 23) {
			System.out.println("나이 : " + (23 - birthNo + 1));
		} else {
			System.out.println("나이 : " + (123 - birthNo));
		}
		// 계산식 -> 일반화
		// Calendar , date(simpledateFormat)
		// 오늘의 년도를 가지고 와서 이년도를 활용해서 프로그램을 동작
		// 년 월 일 시간 나이를 측정

		// 문제5
		// 데이터를 입력 -> 중복 문자가 몇개인가
		// a~z : 26개
		// 배열 인덱스 -> 0~25개의 크기를 가지는 배열
		// 0 : a , 1 : b , ...., 25 : z
		// 아스키 코드 a = 97
		// a-97 = 0 -> 인덱스
		System.out.println("문자열 입력");
		String str5 = sc.nextLine().toLowerCase();
		int charAry[] = new int[26];
		for (int i = 0; i < str5.length(); i++) {
			char temp = str5.charAt(i);
			charAry[temp - 'a']++;
		}
		for (int i = 0; i < charAry.length; i++) {
			if (charAry[i] != 0) {
				System.out.println((char) (97 + i) + " " + charAry[i] + "개 ");
			}
		}
	}
}
