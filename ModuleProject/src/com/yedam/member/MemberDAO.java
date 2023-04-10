package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.team.TeamDAO;

public class MemberDAO extends DAO {
	private static MemberDAO memberDao = null;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (memberDao == null) {
			memberDao = new MemberDAO();
		}
		return memberDao;
	}

	// 로그인 기능
	// id를 매개변수로 받아 확인후 member객체에 담아 반환
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setPhoneNum(rs.getString("phone_num"));
				member.setEmail(rs.getString("email"));
				member.setTeamNo(rs.getInt("team_no"));
				member.setGrade(rs.getInt("grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return member;
	}

	// Member 객체 추가
	// 입력한 데이터를 기반으로 Member 테이블에 데이터 추가
	public int memberAdd(Member member, String teamName) {
		int result = 0;

		try {
			conn();
			int teamNo = 0;
			String sql;
			if (teamName != null) {
				teamNo = TeamDAO.getInstance().getTeamNo(teamName);
				if (teamNo != 0) {
					sql = "INSERT INTO member VALUES(MEM_SEQ.nextval,?,?,?,?,?,2,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, member.getId());
					pstmt.setString(2, member.getPw());
					pstmt.setString(3, member.getName());
					pstmt.setString(4, member.getPhoneNum());
					pstmt.setString(5, member.getEmail());
					pstmt.setInt(6, teamNo);
				} else {
					return result;
				}
			} else {
				sql = "INSERT INTO member(member_no,id,pw,name,phone_num,email,grade) VALUES(MEM_SEQ.nextval,?,?,?,?,?,2)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPw());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getPhoneNum());
				pstmt.setString(5, member.getEmail());
			}
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return result;
	}

	// ID 확인
	// 이름과 전화번호로 ID확인하여 반환
	public String searchId(String name, String phoneNum) {
		String id = null;
		try {
			conn();
			String sql = "SELECT id FROM member WHERE name = ? AND phone_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return id;
	}

	// 비밀번호 확인
	// id를 매개변수로 받아 해당하는 비밀번호 반환
	public Member searchPw(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return member;
	}

	// Member 조회
	// 관리자용으로 Member테이블의 모든 데이터 확인
	public List<Member> getAllMember() {
		List<Member> list = new ArrayList<Member>();
		try {
			conn();
			String sql = "SELECT * FROM member left outer join team USING (team_no)";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Member member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setPhoneNum(rs.getString("phone_num"));
				member.setEmail(rs.getString("email"));
				member.setTeamNo(rs.getInt("team_no"));
				member.setGrade(rs.getInt("grade"));
				member.setTeamName(rs.getString("team_name"));

				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return list;
	}

	// Member 단건 조회
	// id를 매개변수로 받아 해당 Member 반환
	public Member getMember(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT member_no,id,pw,name,phone_num,email,team_name,grade FROM member join team USING (team_no) WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberNo(rs.getInt("member_no"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setPhoneNum(rs.getString("phone_num"));
				member.setEmail(rs.getString("email"));
				member.setTeamName(rs.getString("team_name"));
				member.setGrade(rs.getInt("grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return member;
	}

	public int updateMember(String searchId, String change, Object changeObject) {
		int result = 0;
		String changeString = (String) changeObject;
		int teamNo = 0;
		if(change.equals("team_no")) {
			teamNo = TeamDAO.getInstance().getTeamNo(changeString);
			if(teamNo == 0) {
				return result;
			}
		}
		try {
			conn();
			String sql = "UPDATE member SET "+change+"= ? WHERE id = ?";
			pstmt= conn.prepareStatement(sql);
			if(teamNo != 0) {
				pstmt.setInt(1, teamNo);
			}else {
				pstmt.setString(1, changeString);
			}
			pstmt.setString(2, searchId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// Member 삭제
	// PW를 매개변수로 받아 테이블에서 제거
	public int deleteMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM member WHERE id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return result;
	}
}
