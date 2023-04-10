package com.yedam.comment;

import com.yedam.common.DAO;

public class CommentDAO extends DAO{
	private static CommentDAO commentDao = null;
	private CommentDAO() {
		
	}
	public static CommentDAO getInstance() {
		if(commentDao == null) {
			commentDao = new CommentDAO();
		}
		return commentDao;
	}
}
