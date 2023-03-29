package com.yedam.array;

import java.util.Scanner;

public class Exam06 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택 > ");
			int selectNo = Integer.parseInt(scanner.nextLine());

			if (selectNo == 1) {
				System.out.print("학생 수 >");
				studentNum = scanner.nextInt();
				scanner.nextLine();
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "] > ");
					scores[i] = scanner.nextInt();
					scanner.nextLine();
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("socres[" + i + "] > " + scores[i]);
				}
			} else if (selectNo == 4) {
				int max = scores[0], sum = scores[0];
				double avg;

				for (int i = 1; i < scores.length; i++) {
					if (max < scores[i]) {
						max = scores[i];
					}
					sum += scores[i];
				}
				avg = (double) sum / scores.length;
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + avg);
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
