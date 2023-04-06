package com.yedam.exe;

import java.util.Scanner;

import com.yedam.deptarments.DeptImpl;

public class DeptResource {
	DeptImpl di = new DeptImpl();
	Scanner sc = new Scanner(System.in);
	
	public DeptResource() {
		run();
	}
	public void run() {
		while (true) {
			System.out.println("1. 전체조회 | 2. 부서 정보 조회 | 3. 부서 생성 | 4. 부서 수정 | 5. 부서 삭제 | 0. 종료");
			System.out.println("메뉴 >");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				di.getDepartmentList();
			} else if (menu == 2) {
				di.getDepartment();
			} else if (menu == 3) {
				di.deptAdd();
			} else if (menu == 4) {
				di.deptUpdate();
			} else if (menu == 5) {
				di.deptDelete();
			} else if (menu == 0) {
				System.out.println("end of program");
				break;
			} else {
				System.out.println("없는 메뉴 입니다.");
			}
			System.out.println();
		}
	}
}
