package com.yedam.account;

import com.yedam.common.DAO;
import com.yedam.customer.CustomerService;

public class AccountDAO extends DAO {
	private static AccountDAO accountDao = null;

	private AccountDAO() {

	}

	public static AccountDAO getInstance() {
		if (accountDao == null) {
			accountDao = new AccountDAO();
		}
		return accountDao;
	}

	// 계좌 개설 - insert
	public int accountAdd(Account account) {
		int result = 0;
		try {
			conn();
			// 시퀀스도 가능
			String sql = "INSERT INTO account VALUES(?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getAccountId());
			pstmt.setInt(2, account.getCustomerId());
			pstmt.setInt(3, account.getBalance());

			result = pstmt.executeUpdate();

			// sql 하나 더
//			if(result == 1) {
//				String sql2 ="UPDATE customer SET account_id = ? WHERE customer_id = ?";
//				pstmt = conn.prepareStatement(sql2);
//				pstmt.setInt(1, account.getAccountId());
//				pstmt.setInt(2, account.getCustomerId());
//				int result2 = pstmt.executeUpdate();
//				if(result2 == 1) {
//					System.out.println("고객 계좌 등록 완료");
//				}else {
//					System.out.println("고객 계좌 등록 실패");
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 계좌 해지 - update, delete
	// 계좌를 당장 삭제 X -> 3개월 뒤에 삭제 또는 해지한 히스토리를 관리 : update
	// update -> column 활성화/사용유무 -> Y,N,L
	public int accountDelete(int accountId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM account WHERE account_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return result;
	}

	// 계좌 조회 - JOIN 활용
	public Account getAccount() {
		Account account = null;
		try {
			conn();
			String sql = "select c.customer_id,c.customer_name,a.account_id,a.balance,a.credate\r\n"
					+ "from customer c join account a\r\n" + "on (c.customer_id=a.customer_id)\r\n"
					+ "where c.customer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, CustomerService.customerInfo.getCustomerId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				account = new Account();
				account.setAccountId(rs.getInt("account_id"));
				account.setCustomerName(rs.getString("customer_name"));
				account.setCustomerId(rs.getInt("customer_id"));
				account.setBalance(rs.getInt("balance"));
				account.setCredate(rs.getDate("credate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return account;
	}

	// 입출금
	public int updateMoney(Account account, int cmd) {
		int result = 0;
		int balance = 0;
		try {
			conn();
			// 현재 잔고를 가져오는 쿼리문
			String sql = "SELECT balance FROM account WHERE account_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getAccountId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				balance = rs.getInt("balance");
			}

			if (cmd == 1) { // 입금
				// balance = 현재잔고
				// 현재잔고 + 입금액 = 통장잔고
				// account.getbalance() + balance
//				account.setBalance(balance + account.getBalance());
//				String sql2 = "UPDATE account SET balance = ? WHERE account_id = ?";	
				String sql2 = "UPDATE account SET balance = balance+ ? WHERE account_id = ?";
				pstmt=conn.prepareStatement(sql2);
				pstmt.setInt(1, account.getBalance());
				pstmt.setInt(2, account.getAccountId());
				
				result = pstmt.executeUpdate();
			} else if (cmd == 2) { // 출금
				if(balance > account.getBalance()) {
					String sql2 = "UPDATE account SET balance = balance-? WHERE account_id = ?";
					pstmt = conn.prepareStatement(sql2);
					pstmt.setInt(1, account.getBalance());
					pstmt.setInt(2, account.getAccountId());
					
					result = pstmt.executeUpdate();
				}else {
					System.out.println("잔고보다 출금액이 많습니다.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return result;
	}
}
