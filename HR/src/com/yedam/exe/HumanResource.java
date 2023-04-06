package com.yedam.exe;

import java.util.Scanner;

import com.yedam.deptarments.DeptImpl;
import com.yedam.employees.EmpImpl;

public class HumanResource {
	EmpImpl ei = new EmpImpl();
	DeptImpl di = new DeptImpl();
	Scanner sc = new Scanner(System.in);

	public HumanResource() {
		run();
	}

	private void run() {
		// 메뉴 - 기능
		// 1) 로그인
		// 2) 회원가입
		// 3) 등급관리
		while (true) {
			System.out.println("1. 사원관리 | 2. 부서관리 | 3. 종료");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu==1) {
				employees();
			}else if(menu==2) {
				departments();
			}else if(menu == 3) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
	}

	private void employees() {
		int menu = 99;
		while (menu != 0) {
			System.out.println("1. 전체조회 | 2. 사번 조회 | 3. 사원 등록 | 4. 급여 수정 | 5. 사원 삭제 | 0. 종료");
			System.out.println("메뉴 >");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				ei.getEmployeeList();
			} else if (menu == 2) {
				ei.getEmployee();
			} else if (menu == 3) {
				ei.empAdd();
			} else if (menu == 4) {
				ei.empUpdate();
			} else if (menu == 5) {
				ei.empDelete();
			} else if (menu == 0) {
				System.out.println("사원관리 종료");
				break;
			} else {
				System.out.println("없는 메뉴 입니다.");
			}
			System.out.println();
		}
	}

	private void departments() {
		int menu = 99;
		while (menu != 0) {
			System.out.println("1. 전체조회 | 2. 부서 정보 조회 | 3. 부서 생성 | 4. 부서 수정 | 5. 부서 삭제 | 0. 종료");
			System.out.println("메뉴 >");
			menu = Integer.parseInt(sc.nextLine());
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
				System.out.println("부서관리 종료");
				break;
			} else {
				System.out.println("없는 메뉴 입니다.");
			}
			System.out.println();
		}
	}
}
