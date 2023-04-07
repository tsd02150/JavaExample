package com.yedam.account;

import java.util.Scanner;

public class AccountService {
	public static AccountService as = null;
	Scanner sc = new Scanner(System.in);
	public void accountAdd() {
		System.out.println("계좌 번호 > ");
		int accountId = Integer.parseInt(sc.nextLine());
		System.out.println("고객 ID > ");
		int customerId = Integer.parseInt(sc.nextLine());
		System.out.println("최초 입금액 > ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = new Account();
		account.setAccountId(accountId);
		account.setCustomerId(customerId);
		account.setBalance(money);
		int result = AccountDAO.getInstance().accountAdd(account);
		if(result == 1) {
			System.out.println("계좌 개설 성공");
		}else {
			System.out.println("계좌 개설 실패");
		}
		
	}
	
	public void accountDelete() {
		System.out.println("계좌번호 >");
		int accountId = Integer.parseInt(sc.nextLine());
		int result = AccountDAO.getInstance().accountDelete(accountId);
		if(result >0) {
			System.out.println("계좌 해지 완료");
		}else {
			System.out.println("계좌 해지 실패");
		}
	}
	
	public void getAccount() {
		Account account = AccountDAO.getInstance().getAccount();
		System.out.println(account.toString());
		
	}
	
	public void updateMoney() {
		System.out.println("1. 입금 | 2. 출금");
		int cmd = Integer.parseInt(sc.nextLine());
		System.out.println("계좌번호 > ");
		int accountId = Integer.parseInt(sc.nextLine());
		if(cmd==1) {
			System.out.println("입금 금액 >");
		}else if(cmd==2) {
			System.out.println("출금 금액 >");
		}
		int money = Integer.parseInt(sc.nextLine());
		
		Account account = new Account();
		account.setAccountId(accountId);
		account.setBalance(money);
		int result = AccountDAO.getInstance().updateMoney(account, cmd);
		if(result == 1 && cmd == 1) {
			System.out.println("입금 완료");
		}else if(result == 1 && cmd == 2) {
			System.out.println("출금 완료");
		}else{
			System.out.println("실패");
		}
	}
}
