package com.yedam.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoApp {
	private Scanner sc = new Scanner(System.in);
	int menu = 0;
	int price = 0;
	int[] lotto;
	List<int[]> list = new ArrayList<int[]>();

	public LottoApp() {
		run();
	}

	// 메뉴선택 로또 프로그램
	private void run() {
		while (menu != 99) {
			System.out.println("1. 로또 생성 2. 로또 조회 99. 프로그램 종료");
			System.out.println("메뉴를 선택해 주세요.");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 로또 번호 생성
				makeLotto();
				break;
			case 2:
				// 로또 번호 조회
				showInfo();
				break;
			case 99:
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	private void makeLotto() {
		// 1. 입력한 금액만큼 로또 번호 생성
		// ex) 10000원 -> 6개짜리 번호 10개
		// list에 저장
		System.out.println("금액을 투입해주세요.");
		price = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < (price / 1000); i++) {
			list.add(makeNumber());
		}
	}

	private void showInfo() {
		System.out.println("구매한 금액 > " + price);
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i % 5 + 1) + "번> ");
			for (int j = 0; j < list.get(i).length; j++) {
				System.out.print(list.get(i)[j] + " ");
			}
			System.out.println();
			if ((i + 1) % 5 == 0) {
				System.out.println("-----------------------");
			}
		}
		System.out.println();
	}

	private int[] makeNumber() {
		// 로또 번호 6개 만드는거
		// 단, 중복 발생 x
		// 정렬 안해도 됨
		lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}
			}
		}
		return lotto;
	}
}
