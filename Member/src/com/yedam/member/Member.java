package com.yedam.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class Member {
	private String id;
	private String pw;
	private String name;
}
