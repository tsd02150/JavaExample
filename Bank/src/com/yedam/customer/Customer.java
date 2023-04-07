package com.yedam.customer;

import lombok.Data;

@Data
public class Customer {
	private int customerId;
	private String customerPw;
	private String customerName;
//	private int accountId;
	private String customerGrade;
}
