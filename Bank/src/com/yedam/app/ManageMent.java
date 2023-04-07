package com.yedam.app;

import java.util.Scanner;

import com.yedam.account.AccountService;
import com.yedam.customer.CustomerService;

public class ManageMent {
	int menu = 0;
	Scanner sc = new Scanner(System.in);
	CustomerService cs = new CustomerService();
	AccountService as = new AccountService();

	public ManageMent() {
		bankJob();
	}

	// 은행
	// 고객 - 'C'
	// - 계좌조회, 입출금, 이체
	// 은행원 - 'B'
	// - 고객등록, 계좌개설, 계좌해지
	private void bankJob() {
		while (true) {
			menu();
			if (CustomerService.customerInfo.getCustomerGrade().equals("C")) {
				if (menu == 1) {
					as.getAccount();
				} else if (menu == 2) {
					as.updateMoney();
				} else if (menu == 3) {
					
				} else if(menu ==4) {
					cs.logout();
					break;
				}
			} else if (CustomerService.customerInfo.getCustomerGrade().equals("B")) {
				if (menu == 1) {
					cs.customerAdd();
				} else if (menu == 2) {
					as.accountAdd();
				} else if (menu == 3) {
					as.accountDelete();
				}else if(menu ==4) {
					cs.logout();
					break;
				}
			}
		}
	}

	private void menu() {
		if (CustomerService.customerInfo.getCustomerGrade().equals("C")) {
			// 고객
			System.out.println("1. 계좌조회 | 2, 입출금 | 3. 계좌이체 | 4. 로그아웃");
		} else if (CustomerService.customerInfo.getCustomerGrade().equals("B")) {
			// 은행원
			System.out.println("1. 고객등록 | 2. 계좌개설 | 3. 계좌해지 | 4. 로그아웃");
		}
		System.out.println("입력 >");
		menu = Integer.parseInt(sc.nextLine());
	}
}
