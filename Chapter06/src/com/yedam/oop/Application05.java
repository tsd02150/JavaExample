package com.yedam.oop;

import java.util.Scanner;

public class Application05 {
	public static void main(String[] args) {
		// 클래스 + 배열 => Student[] ary = new Student[10] -> 10개 공간에 학생 객체 저장
		// int + 배열 => int[] ary = new int[10] -> 10개 공간에 정수
		
		// 1. 학생 수 | 2. 학생들 정보 입력 | 3. 학생들의 총점 및 평균 | 4. 종료
		
		Scanner sc = new Scanner(System.in);
		int stdCnt = 0;
		Student[] stds =null;
		while(true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. 학생 수 | 2. 학생들 정보 입력 | 3. 학생들의 총점 및 평균 | 4. 종료");
			System.out.println("-------------------------------------------------------");
			System.out.println("메뉴 입력 >");
			String selectNo = sc.nextLine();
			
			if(selectNo.equals("1")) {
				System.out.println("학생수 입력");
				stdCnt=Integer.parseInt(sc.nextLine());
				
			}
			else if(selectNo.equals("2")) {
				stds=new Student[stdCnt];
				for(int i=0;i<stds.length;i++) {
					stds[i] = new Student();
					System.out.println("이름 입력 > ");
					stds[i].studentName=sc.nextLine();
					System.out.println("학번 입력 > ");
					stds[i].studentNo=Integer.parseInt(sc.nextLine());
					System.out.println("국어성적 입력 > ");
					stds[i].kor=Integer.parseInt(sc.nextLine());	
					System.out.println("영어성적 입력 > ");
					stds[i].eng=Integer.parseInt(sc.nextLine());
					System.out.println("수학성적 입력 > ");
					stds[i].mat=Integer.parseInt(sc.nextLine());
					System.out.println();
				}
			}
			else if(selectNo.equals("3")) {
				for(Student i:stds) {
					int sum=i.kor+i.eng+i.mat;
					double avg = (double)sum/3;
					System.out.println(i.studentName + "의 총점 : "+sum+"평균 : "+avg);
				}
			}
			else if(selectNo.equals("4")) {
				break;
			}else {
				System.out.println("없는 메뉴입니다. 다시입력하세요.");
			}
		}
		System.out.println("프로그램 종료");
	}
}
