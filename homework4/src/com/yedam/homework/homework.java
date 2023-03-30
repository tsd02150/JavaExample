package com.yedam.homework;

import java.util.Scanner;

public class homework {
	public static void main(String[] args) {
		// 문제2) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		// 출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		Scanner sc = new Scanner(System.in);
		int productCnt = 0;
		Product[] products = null;
		while (true) {
			System.out.println("----------------------------------------------------");
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------------");
			System.out.println("메뉴를 입력하세요:");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				System.out.println("상품 수를 입력하세요.");
				productCnt = Integer.parseInt(sc.nextLine());
			} else if (menu == 2) {
				products = new Product[productCnt];
				for (int i = 0; i < products.length; i++) {
					products[i] = new Product();
					System.out.println("상품명 입력 > ");
					products[i].productName = sc.nextLine();
					System.out.println("가격 입력 > ");
					products[i].price = Integer.parseInt(sc.nextLine());
				}
			} else if (menu == 3) {
				for (Product i : products) {
					System.out.println(i.productName + " : " + i.price + "원");
				}
			} else if (menu == 4) {
				int max = products[0].price;
				int maxIndex = 0;
				int total = 0;
				for (int i = 0; i < products.length; i++) {
					if (max < products[i].price) {
						maxIndex = i;
					}
				}
				System.out.println("최고가격 제품 [" + products[maxIndex].productName + "]의 가격 : " + products[maxIndex].price);
				for (int i = 0; i < products.length; i++) {
					if (i != maxIndex) {
						total += products[i].price;
					}
				}
				System.out.println("최고 가격 제외 다른제품 가격의 총합 : " + total);
			} else if (menu == 5) {
				break;
			} else {
				System.out.println("메뉴를 잘못 고르셨습니다.");
			}
		}
		System.out.println("프로그램 종료");
	}
}
