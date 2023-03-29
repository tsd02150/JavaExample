package com.yedam.array;

import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {
		// 한 학생의 국어 , 영어, 수학 점수를 배열에 담아서 성적 관리
		//{국어,영어,수학}
		Scanner sc = new Scanner(System.in);
		int[] point = new int[3];
		int sum = 0;
		double avg;
		// 학생의 성적 입력
		for(int i=0;i<point.length;i++) {
			System.out.println("성적 입력 > ");
			point[i] = sc.nextInt();
			sum+=point[i];
		}
		avg = (double)sum/point.length;
		System.out.println("점수 총 합계 : "+sum);
		System.out.println("성적 평균 : "+avg);
		
	}
}
