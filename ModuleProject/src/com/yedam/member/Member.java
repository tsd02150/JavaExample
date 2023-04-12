package com.yedam.member;

import lombok.Data;

@Data
public class Member {
	private int memberNo;
	private String id;
	private String pw;
	private String name;
	private String phoneNum;
	private String email;
	private int teamNo;
	private int grade;
	private int teamGrade;
	
	private String teamName;
}
