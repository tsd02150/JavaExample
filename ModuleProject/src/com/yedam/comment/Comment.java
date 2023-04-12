package com.yedam.comment;

import java.sql.Date;

import lombok.Data;

@Data
public class Comment {
	private int comment_no;
	private String comment_content;
	private Date comment_date;
	private int member_no;
	private int board_no;
}
