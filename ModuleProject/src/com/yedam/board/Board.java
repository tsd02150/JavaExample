package com.yedam.board;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int categoryNo;
	private int memberNo;
	
	private String memberId;
	private String commentId;
	private String commentContent;
	private Date commentDate;
}
