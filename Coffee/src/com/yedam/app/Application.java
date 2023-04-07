package com.yedam.app;

import java.util.Scanner;

import com.yedam.coffee.CoffeeService;

public class Application {
	public Application() {
		run();
	}

	private void run() {
		CoffeeService cs = new CoffeeService();
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while (true) {
			System.out.println("1. 메뉴 조회 | 2. 메뉴 상세 조회 | 3. 메뉴 등록 | 4. 판매 | 5. 메뉴 삭제 | 6. 매출 | 7. 종료");
			System.out.println("메뉴 입력");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				cs.viewCoffeeMenu();
			} else if (menu == 2) {
				cs.viewCoffeeInfo();
			} else if (menu == 3) {
				cs.menuAdd();
			} else if (menu == 4) {
				cs.coffeeSell();
			} else if (menu == 5) {
				cs.menuDelete();
			} else if (menu == 6) {
				cs.getSales();
			} else if (menu == 7) {
				System.out.println("end of prog");
				break;
			}
		}
	}
}
