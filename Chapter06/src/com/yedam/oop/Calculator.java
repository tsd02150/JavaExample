package com.yedam.oop;

public class Calculator {
	// 필드

	// 생성자

	// 메소드
	void sum(int x, int y) {
		int result = x + y;
		System.out.println(x + " + " + y + " = " + result);
	}

	int sum(int x, int y, int z) {
		return x + y + z;
	}

	double sum(double x, double y) {
		return x + y;
	}

	void sum(char x, char y) {

	}

	// 정사각형 넓이
	double areaRectangle(double width) {
		return width * width;
	}

	// 직사각형 넓이
	double areaRectangle(double width, double height) {
		return width * height;
	}

	// 매개변수의 개수를 모를 경우
	int sum3(int[] intAry) {
		int result = 0;
		for (int i = 0; i < intAry.length; i++) {
			result += intAry[i];
		}
		return result;
	}

	int sum4(int... intAry) {
		int result = 0;
		for (int i = 0; i < intAry.length; i++) {
			result += intAry[i];
		}
		return result;
	}

	double avg() {
		int result = sum4(1, 2, 3, 4, 5, 6, 7);
		return (double) result / 7;
	}

}
