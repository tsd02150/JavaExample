package com.yedam.app;

import java.util.Scanner;

import com.yedam.student.StudentService;

public class Application {
	Scanner sc = new Scanner(System.in);
	StudentService ss = new StudentService();
	public Application() {
		run();
	}
	
	private void run() {
		int menu=0;
		while(true) {
			System.out.println("1.학생정보조회 | 2.학생등록 | 3.학생정보삭제 | 4.전공변경 | 5.종료");
			System.out.println("메뉴 선택 >");
			menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				ss.getStudent();
			}else if(menu==2) {
				ss.studentAdd();
			}else if(menu==3) {
				ss.studentDelete();
			}else if(menu==4) {
				ss.changeMajor();
			}else if(menu==5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
