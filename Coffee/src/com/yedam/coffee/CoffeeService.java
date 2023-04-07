package com.yedam.coffee;

import java.util.List;
import java.util.Scanner;

public class CoffeeService {
	Scanner sc = new Scanner(System.in);

	// 메뉴 조회
	public void viewCoffeeMenu() {
		List<Coffee> coffeeList = CoffeeDAO.getInstance().getCoffeeMenu();
		for (int i = 0; i < coffeeList.size(); i++) {
			System.out.print("메뉴 : " + coffeeList.get(i).getCoffeeMenu());
			System.out.println("\t가격 : " + coffeeList.get(i).getCoffeePrice());
		}
	}

	// 메뉴 상세 조회
	public void viewCoffeeInfo() {
		System.out.println("메뉴 입력 >");
		String menu = sc.nextLine();
		Coffee coffee = CoffeeDAO.getInstance().getCoffeeInfo(menu);
		System.out.print("메뉴 : " + coffee.getCoffeeMenu());
		System.out.print("\t가격 : " + coffee.getCoffeePrice());
		System.out.println("\t설명 : " + coffee.getCoffeeExplain());
	}

	// 메뉴 등록
	public void menuAdd() {
		System.out.println("메뉴 입력 >");
		String menu = sc.nextLine();
		System.out.println("가격 입력 >");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("설명 입력 >");
		String explain = sc.nextLine();

		Coffee coffee = new Coffee();
		coffee.setCoffeeMenu(menu);
		coffee.setCoffeePrice(price);
		coffee.setCoffeeExplain(explain);

		int result = CoffeeDAO.getInstance().menuAdd(coffee);
		if (result != 0) {
			System.out.println("메뉴 등록 완료");
		} else {
			System.out.println("메뉴 등록 실패");
		}
	}

	// 판매
	public void coffeeSell() {
		System.out.println("메뉴 입력 >");
		String menu = sc.nextLine();
		int result = CoffeeDAO.getInstance().coffeeSell(menu);
		if (result > 0) {
			System.out.println("판매 완료");
		} else {
			System.out.println("판매 실패");
		}
	}

	// 메뉴 삭제
	public void menuDelete() {
		System.out.println("메뉴 입력 >");
		String menu = sc.nextLine();
		int result = CoffeeDAO.getInstance().menuDelete(menu);
		if (result > 0) {
			System.out.println("메뉴 삭제 완료");
		} else {
			System.out.println("메뉴 삭제 실패");
		}
	}

	// 매출 확인
	public void getSales() {
		List<Coffee> coffeeList = CoffeeDAO.getInstance().getSales();
		int sumSales = 0;
		for (int i = 0; i < coffeeList.size(); i++) {
			System.out.print("메뉴 : " + coffeeList.get(i).getCoffeeMenu());
			System.out.print(", 판매 개수 : " + coffeeList.get(i).getCoffeeSales());
			System.out
					.println(", 판매 금액 : " + (coffeeList.get(i).getCoffeeSales() * coffeeList.get(i).getCoffeePrice()));
			sumSales += coffeeList.get(i).getCoffeeSales() * coffeeList.get(i).getCoffeePrice();
		}
		System.out.println("총 매출액 : " + sumSales);
	}

}
