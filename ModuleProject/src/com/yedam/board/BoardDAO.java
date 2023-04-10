package com.yedam.board;

import com.yedam.common.DAO;

public class BoardDAO extends DAO{
	private static BoardDAO boardDao = null;
	private BoardDAO() {
		
	}
	public static BoardDAO getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDAO();
		}
		return boardDao;
	}
}
