package com.yedam.app;

import java.util.Scanner;

import com.yedam.customer.CustomerService;

public class Application {
	Scanner sc = new Scanner(System.in);
	int menuNo = 0;
	CustomerService cs = new CustomerService();
	
	public Application() {
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("1. 로그인 | 2. 종료");
			menuNo = Integer.parseInt(sc.nextLine());
			if(menuNo == 1) {
				//로그인 실행 메소드
				cs.login();
				if(CustomerService.customerInfo != null) {
					new ManageMent();
				}
			}else if(menuNo == 2) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
