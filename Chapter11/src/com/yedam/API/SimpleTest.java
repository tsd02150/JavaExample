package com.yedam.API;

import java.util.Scanner;

public class SimpleTest {
	public static void main(String[] args) {
		// 문제 1] 문자열 뒤집기
		// 입력되는 문자열을 뒤집어 출력하라
		// 예시 : 입력 > "12345678"
		// 출력 > "87654321"
		String input = "12345678";
		String output = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			output += input.charAt(i);
		}
		System.out.println(output);

		System.out.println("=======================================");

		// 문제 2] 문자열 개수 세기
		// 알파벳 , 숫자, 공백 의 갯수
		System.out.println("문자열입력");
		Scanner sc = new Scanner(System.in);
		String input2 = sc.nextLine();
		int alpabet = 0, num = 0, blank = 0;
		for (int i = 0; i < input2.length(); i++) {
			if ((input2.charAt(i) >= 65 && input2.charAt(i) <= 90)
					|| (input2.charAt(i) >= 97 && input2.charAt(i) <= 122)) {
				alpabet++;
			}
			if (input2.charAt(i) >= 48 && input2.charAt(i) <= 57) {
				num++;
			}
			if (input2.charAt(i) == 32) {
				blank++;
			}
		}
		System.out.println("알파벳 개수 : " + alpabet + " 숫자 개수 : " + num + " 공백 개수 : " + blank);

		System.out.println("=======================================");

		// 문제 3] 문자열 압축
		// 예시 : 입력 >"YYYEEDDDYYYMMMAAA";
//		          출력 >Y3E2D3Y3M3A3
		String data = "YYYEEDDDYYYMMMAAA";
		String result = "";
		char before = data.charAt(0);
		int cnt = 1;
		for (int i = 1; i < data.length(); i++) {
			if (data.charAt(i) == before) {
				cnt++;
			} else {
				result += before;
				result += cnt;
				cnt = 1;
			}
			before = data.charAt(i);
		}
		result += before;
		result += cnt;
		System.out.println(result);

		System.out.println("=======================================");

		// 문제 4] 생년월일 입력 후 나이 출력하기(220101 -> 2022년생, 230202 -> 1923년생)
//		        (단, 오늘 날짜 기준으로 생일이 지났으면 +1살, 안 지났으면 +0로 한다.)
//		        (올해 기준 +- 100살까지만 구한다.)
//		     예시) 
//		          입력> 950101 
//		          출력> 29
//		          입력> 001013
//		          출력> 23
		System.out.println("생년월일 입력 YYMMDD");
		String birth = sc.nextLine();
		String strYear = birth.substring(0, 2);
		int year = Integer.parseInt(strYear);
		String strmonth = birth.substring(2, 4);
		int month = Integer.parseInt(strmonth);
		String strday = birth.substring(4);
		int day = Integer.parseInt(strday);

		if (year >= 23) {
			if ((month < 4) || month == 4 && day < 4) {
				System.out.println(123-year+1);
			} else {
				System.out.println(123-year);
			}
		} else {
			if ((month < 4) || month == 4 && day < 4) {
				System.out.println(23-year+1);
			} else {
				System.out.println(23-year);
			}
		}
		
		System.out.println("=======================================");

		// 문제 5] 중복 문자 갯수 세기
//		         입력> aaabbccceedddd
//		         출력> a 3개, b 2개, c 3개, e 2개, d 4개
		String input3 = "aaabbccceedddd";
		char before2 = input3.charAt(0);
		int index = 0;
		String tmp;
		for (int i = 1; i < input3.length(); i++) {
			if (input3.charAt(i) != before2) {
				tmp = input3.substring(index, i);
				System.out.print(tmp.charAt(0) + " " + tmp.length() + "개, ");
				before2 = input3.charAt(i);
				index = i;
			}
		}
		tmp = input3.substring(index);
		System.out.print(tmp.charAt(0) + " " + tmp.length() + "개");

	}

}
