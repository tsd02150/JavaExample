package com.yedam.customer;

import com.yedam.common.DAO;

public class CustomerDAO extends DAO{
	private static CustomerDAO customerDao = new CustomerDAO();
	private CustomerDAO() {
		
	}
	public static CustomerDAO getInstance() {
		return customerDao;
	}
	
	//로그인
	public Customer login(int id) {
		Customer customer = null;
		try {
			conn();
			String sql = "SELECT * FROM customer WHERE customer_id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerPw(rs.getString("customer_pw"));
//				customer.setAccountId(rs.getInt("account_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerGrade(rs.getString("customer_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return customer;
	}
	
	public void customerAdd(Customer customer) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO customer VALUES(?,?,?,0,'C')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer.getCustomerId());
			pstmt.setString(2, customer.getCustomerPw());
			pstmt.setString(3, customer.getCustomerName());
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("고객 등록 완료");
			}else {
				System.out.println("고객 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
	
	
}
