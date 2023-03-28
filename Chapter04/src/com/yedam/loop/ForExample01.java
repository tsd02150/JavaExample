package com.yedam.loop;

import java.util.Scanner;

public class ForExample01 {
	public static void main(String[] args) {
		int sum = 0;
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5;
		System.out.println(sum);

		sum = 0;
		for (int i = 1; i <= 5; i++) {
			sum += i;
		}
		System.out.println(sum);

		// 짝수,홀수 구하기
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i + "는 짝수");
			} else {
				System.out.println(i + "는 홀수");
			}
		}

		// 입력한 숫자에 대한 구구단 출력
		// 구구단만 출력 -> 입력 구구단 출력
		for (int i = 1; i <= 9; i++) {
			System.out.println("2 x " + i + " = " + (2 * i));
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단 입력 > ");
		int gugu = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.println(gugu + " x " + i + " = " + (gugu * i));
		}

		// 입력한 값에 대한 총합, 평균, 최대값, 데이터 받을 개수 스캐너 활용해서 데이터 입력
		// 총합 : 입력 받자마자 총합이라는 변수에 누적 합계
		// 평균 : 총합/데이터개수
		// 최대값 : 입력한 데이터와 기존에 들어있는 데이터 비교해서 더 큰거
		// 최소값 : 입력한 데이터와 기존에 들어있는 데이터 비교해서 더 작은거
		System.out.println("데이터 입력 개수 > ");
		int count = sc.nextInt();
		int data;
		int total = 0, max = 0, min = 0;
		for (int i = 0; i < count; i++) {
			System.out.println("데이터 입력 > ");
			data = sc.nextInt();
			total += data;
			if (i == 0) {
				max = data;
				min = data;
			} else {
				if (data > max) {
					max = data;
				}
				if (data < min) {
					min = data;
				}
			}
		}
		System.out.println("총합 : " + total + "\n평균 : " + (total / (double) count) + "\n최대값 : " + max + " 최소값 : " + min);

		// up & down
		// 임의 랜덤값 (1~100) 중 하나의 정수를 추출해서
		// 5번 기회 안에 해당하는 랜덤 값을 맞추는 프로그램 구현
		int number = (int) (Math.random() * 100) + 1;
//		System.out.println(number);
		int inputData;
		for (int i = 1; i <= 5; i++) {
			System.out.println("입력값 > ");
			inputData = sc.nextInt();
			if (inputData > number) {
				System.out.println("down");
			} else if (inputData < number) {
				System.out.println("up");
			} else if (inputData == number) {
				System.out.println("정답, " + i + "번의 기회만에 맞추셨습니다.");
				break;
			}
			if (i == 5) {
				System.out.println("실패 하였습니다.");
			}
		}
		
		
	}
}
