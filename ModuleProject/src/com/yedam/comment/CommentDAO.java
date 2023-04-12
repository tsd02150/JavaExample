package com.yedam.comment;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;

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
	public int addComment(String content, int boardNo) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO comments VALUES(COMMENT_SEQ.nextval,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, MemberService.memberInfo.getMemberNo());
			pstmt.setInt(3, boardNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
