package com.yedam.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// 문제 1
		int num1 = 10;
		double num2 = 2.0;
		System.out.println("10 + 2.0 = " + (num1 + (int) num2));
		System.out.println("10 - 2.0 = " + (num1 - (int) num2));
		System.out.println("10 * 2.0 = " + (num1 * (int) num2));
		System.out.println("10 / 2.0 = " + (num1 / (int) num2));
		System.out.println();

		// 문제 2
		// (1) false
		// (2) true
		// (3) false

		// 문제3
		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;
		System.out.println("money = " + money);
		for (int i = 0; i < coinUnit.length; i++) {
			System.out.print(coinUnit[i] + "원 : " + (money / coinUnit[i]) + "개"+((i != coinUnit.length - 1) ? ", " : ""));
			money = money % coinUnit[i];
		}
		System.out.println();
		System.out.println();

		// 문제 4
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
			System.out.println();
		}

		// 문제 5
		int[] dice = null;
		Scanner sc = new Scanner(System.in);
		int menu;
		int diceSize = 0;
		while (true) {
			System.out.println("===1.주사위 크기 2.주사위 굴리기 3.결과 보기 4.가장 많이 나온 수 5.종료===");
			System.out.println("메뉴 >");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				while (true) {
					System.out.println("주사위 크기 >");
					diceSize = Integer.parseInt(sc.nextLine());
					if (diceSize > 10 || diceSize < 5) {
						System.out.println("주사위 크기를 5~10의 수로 입력해 주세요.");
					} else {
						dice = new int[diceSize];
						break;
					}
				}
			} else if (menu == 2) {
				int diceNum;
				int diceCnt = 0;
				while (true) {
					diceNum = (int) (Math.random() * diceSize);
					diceCnt++;
					dice[diceNum]++;
					if ((diceNum + 1) == 5) {
						break;
					}
				}
				System.out.println("5가 나올 때 까지 주사위를 " + diceCnt + "번 굴렸습니다.");
			} else if (menu == 3) {
				for (int i = 1; i <= dice.length; i++) {
					System.out.println(i + "은 " + dice[i - 1] + "번 나왔습니다.");
				}
			} else if (menu == 4) {
				int max = dice[0];
				int maxIndex = 1;
				for (int i = 1; i <= dice.length; i++) {
					if (max < dice[i - 1]) {
						max = dice[i - 1];
						maxIndex = i;
					}
				}
				System.out.println("가장 많이 나온 수는 " + maxIndex + "입니다.");
			} else if (menu == 5) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
