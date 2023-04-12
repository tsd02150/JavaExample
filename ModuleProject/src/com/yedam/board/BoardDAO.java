package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;

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
	
	public List<String> getBoardTitleList(int categoryNo){
		List<String> list = new ArrayList<String>();
		try {
			conn();
			String sql = "SELECT board_title FROM board WHERE category_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("board_title");
				list.add(title);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	public List<Board> getBoardInfo(String boardTitle) {
		List<Board> list = new ArrayList<Board>();
		try {
			conn();
			String sql = "SELECT a.board_no,board_title,board_content,board_date,board_id,comment_id,comment_content,comment_date "
					+ "FROM "
					+ "(SELECT board_title,board_content,board_date,id as board_id ,board_no "
					+ "FROM board join member USING(member_no) "
					+ "WHERE board_title = ?) a LEFT OUTER JOIN "
					+ "(SELECT id as comment_id, comment_content,comment_date,board_no "
					+ "FROM comments join member USING(member_no)) b "
					+ "ON a.board_no = b.board_no";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setBoardTitle(boardTitle);
				board.setBoardContent(rs.getString("board_content"));
				board.setBoardDate(rs.getDate("board_date"));
				board.setMemberId(rs.getString("board_id"));
				board.setCommentId(rs.getString("comment_id"));
				board.setCommentContent(rs.getString("comment_content"));
				board.setCommentDate(rs.getDate("comment_date"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	public int addBoard(String title,String content) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO board VALUES(BOARD_SEQ.nextval,?,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, BoardService.boardCategory);
			pstmt.setInt(4, MemberService.memberInfo.getMemberNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	public int updateBoard(String index, String content,int boardNo) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE board SET "+index+"=? WHERE board_no = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, boardNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	public int deleteBoard(int boardNo) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM board WHERE board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
