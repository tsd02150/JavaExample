package com.yedam.team;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.Member;

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
	public int getTeamNo(String categoryName, String teamName) {
		int teamNo = 0;
		try {
			conn();
			String sql = "SELECT team_no FROM team join categorys USING(category_no) WHERE team_name = ? and category_name = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, teamName);
			pstmt.setString(2, categoryName);
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
	public int getTeamNo(String teamName) {
		int teamNo = 0;
		try {
			conn();
			String sql = "SELECT team_no FROM team  WHERE team_name = ? ";
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
	
	public List<Team> getAllTeamInfo(){
		List<Team> list = new ArrayList<Team>();
		try {
			conn();
			String sql = "SELECT * FROM team join categorys USING(category_no)";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Team team= new Team();
				team.setTeamNo(rs.getInt("team_no"));
				team.setTeamName(rs.getString("team_name"));
				team.setCategoryName(rs.getString("category_name"));
				team.setCategoryNo(rs.getInt("category_no"));
				
				list.add(team);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return list;
	}
	
	public List<Team> getAllTeamInfo(int categoryNo){
		List<Team> list = new ArrayList<Team>();
		try {
			conn();
			String sql = "SELECT * FROM team join categorys USING(category_no) WHERE category_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Team team= new Team();
				team.setTeamNo(rs.getInt("team_no"));
				team.setTeamName(rs.getString("team_name"));
				team.setCategoryName(rs.getString("category_name"));
				team.setCategoryNo(rs.getInt("category_no"));
				
				list.add(team);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return list;
	}
	
	public List<Team> getTeamInfo(int teamNo) {
		List<Team> list = new ArrayList<Team>();
		
		try {
			conn();
			String sql = "select a.member_no,a.id,a.name,a.team_grade,b.team_no,b.team_name,b.category_no,b.category_name from "
					+ "(select * from team join member using(team_no)) a full outer join "
					+ "(SELECT * FROM team join categorys USING(category_no)) b "
					+ "on a.team_no = b.team_no "
					+ "where b.team_no=? order by a.team_grade, a.name asc";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, teamNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Team team = new Team();
				team.setTeamNo(rs.getInt("team_no"));
				team.setTeamName(rs.getString("team_name"));
				team.setId(rs.getString("id"));
				team.setName(rs.getString("name"));
				team.setTeamGrade(rs.getInt("team_grade"));
				team.setCategoryName(rs.getString("category_name"));
				team.setCategoryNo(rs.getInt("category_no"));
				list.add(team);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return list;
	}
	public Team getTeamInfoMem(int teamNo) {
		Team team = null;
		
		try {
			conn();
			String sql = "SELECT * FROM team join categorys USING(category_no) WHERE team_no = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, teamNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				team = new Team();
				team.setTeamNo(rs.getInt("team_no"));
				team.setTeamName(rs.getString("team_name"));
				team.setCategoryName(rs.getString("category_name"));
				team.setCategoryNo(rs.getInt("category_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return team;
	}
	
	public int addTeam(Team team) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO team(team_no,team_name,category_no) SELECT TEAM_SEQ.nextval, ?, category_no FROM categorys WHERE category_name = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, team.getTeamName());
			pstmt.setString(2, team.getCategoryName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	public int updateTeam(Team team, String newTeamName) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE team SET team_name = ? WHERE team_name = ? AND category_no = (SELECT category_no FROM categorys WHERE category_name = ?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, newTeamName);
			pstmt.setString(2, team.getTeamName());
			pstmt.setString(3, team.getCategoryName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	public int deleteTeam(Team team) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET team_no = null WHERE team_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, team.getTeamNo());
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "DELETE FROM team WHERE team_no = ? AND category_no = (SELECT category_no FROM categorys WHERE category_name = ?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, team.getTeamNo());
			pstmt.setString(2, team.getCategoryName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	public void addTeamMember(String addMemberID) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE member SET team_grade = ? WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			pstmt.setString(2, addMemberID);
			result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("팀에 "+addMemberID+"님이 추가되었습니다.");
			}else {
				System.out.println("팀에 신청하지 않은 ID입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
}
