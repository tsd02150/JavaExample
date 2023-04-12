package com.yedam.calendar;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;
import com.yedam.team.TeamService;

public class CalendarDAO extends DAO{
	private static CalendarDAO calendarDao = null;
	private CalendarDAO() {
		
	}
	public static CalendarDAO getInstance() {
		if(calendarDao == null) {
			calendarDao = new CalendarDAO();
		}
		return calendarDao;
	}
	
	public List<Calendar> searchMatch(){
		List<Calendar> list = new ArrayList<Calendar>();
		try {
			conn();
			String sql = "select a.calendar_no,a.calendar_date,a.team_no1,a.team_name team_name1,b.team_no2, b.team_name team_name2,a.match "
					+ "from "
					+ "(select * from calendar join team on team_no = ?) a join "
					+ "(select * from calendar join team on team_no = team_no2) b "
					+ "on a.calendar_no = b.calendar_no ";
			if(MemberService.memberInfo.getTeamGrade() == 2) {
				sql += "where a.match = 'o'";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, TeamService.teamInfo.getTeamNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Calendar calendar = new Calendar();
				calendar.setCalendarNo(rs.getInt("calendar_no"));
				calendar.setCalendarDate(rs.getDate("calendar_date"));
				calendar.setTeamNo1(rs.getInt("team_no1"));
				calendar.setTeamName1(rs.getString("team_name1"));
				calendar.setTeamNo2(rs.getInt("team_no2"));
				calendar.setTeamName2(rs.getString("team_name2"));
				calendar.setMatch(rs.getString("match"));
				list.add(calendar);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	public List<Calendar> searchMatchWait(){
		List<Calendar> list = new ArrayList<Calendar>();
		try {
			conn();
			String sql = "select a.calendar_no,a.calendar_date,a.team_no1,a.team_name team_name1,b.team_no2, b.team_name team_name2,a.match "
					+ "from "
					+ "(select * from calendar join team on team_no = ?) a join "
					+ "(select * from calendar join team on team_no = team_no2) b "
					+ "on a.calendar_no = b.calendar_no "
					+ "where a.match = '?'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, TeamService.teamInfo.getTeamNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Calendar calendar = new Calendar();
				calendar.setCalendarNo(rs.getInt("calendar_no"));
				calendar.setCalendarDate(rs.getDate("calendar_date"));
				calendar.setTeamNo1(rs.getInt("team_no1"));
				calendar.setTeamName1(rs.getString("team_name1"));
				calendar.setTeamNo2(rs.getInt("team_no2"));
				calendar.setTeamName2(rs.getString("team_name2"));
				calendar.setMatch(rs.getString("match"));
				list.add(calendar);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	public int updateCalendar(int calendarNo, String match) {
		int result=0;
		try {
			conn();
			String sql = "UPDATE calendar SET match = ? WHERE calendar_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, match);
			pstmt.setInt(2, calendarNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	public int addMatch(String team2,String date) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO calendar VALUES(CALENDAR_SEQ.nextval,?,'?',?,"
					+ "(SELECT team_no FROM team WHERE team_name = ?))";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, date);
			pstmt.setInt(2, TeamService.teamInfo.getTeamNo());
			pstmt.setString(3, team2);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
