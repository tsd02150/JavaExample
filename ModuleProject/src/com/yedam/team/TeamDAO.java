package com.yedam.team;

import com.yedam.common.DAO;

public class TeamDAO extends DAO{
	private static TeamDAO teamDao = null;
	private TeamDAO() {
		
	}
	public static TeamDAO getInstance() {
		if(teamDao == null) {
			teamDao = new TeamDAO();
		}
		return teamDao;
	}
	
	// 팀넘버 찾기
	// 팀이름으로 TeamNo 찾아 반환
	public int getTeamNo(String teamName) {
		int teamNo = 0;
		try {
			conn();
			String sql = "SELECT team_no FROM team WHERE team_name = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, teamName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				teamNo = rs.getInt("team_no");
			}else {
				System.out.println("존재하지 않는 팀입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return teamNo;
	}
	
	// 팀이름 찾기
	// teamNo로 팀이름 반환
	public String getTeamName(int teamNo) {
		String teamName="";
		try {
			conn();
			String sql = "SELECT team_name FROM team WHERE team_no = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, teamNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				teamName = rs.getString("team_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return teamName;
	}
	
	public Team getTeamInfo(int teamNo) {
		Team team = null;
		
		try {
			conn();
			String sql = "SELECT * FROM team WHERE team_no = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, teamNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				team = new Team();
				team.setTeamNo(rs.getInt("team_no"));
				team.setTeamName(rs.getString("team_name"));
				team.setTeamGrade(rs.getString("team_grade"));
				team.setCategoryNo(rs.getInt("category_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return team;
	}
	
	
}
