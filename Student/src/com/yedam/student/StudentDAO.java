package com.yedam.student;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StudentDAO extends DAO {
	private static StudentDAO studentDao = null;

	private StudentDAO() {

	}

	public static StudentDAO getInstance() {
		if (studentDao == null) {
			studentDao = new StudentDAO();
		}
		return studentDao;
	}

	public List<Student> getStudent() {
		List<Student> stdList = new ArrayList<Student>();
		StudentService.sumScore = 0;
		StudentService.avg = 0;
		try {
			conn();
			String sql = "SELECT * FROM student";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student std = new Student();
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setMajor(rs.getString("major"));
				std.setScore(rs.getInt("score"));
				StudentService.sumScore += std.getScore();
				stdList.add(std);
			}
			StudentService.avg = (double) StudentService.sumScore / stdList.size();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return stdList;
	}

	public int studentAdd(Student student) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO student VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getStdId());
			pstmt.setString(2, student.getStdName());
			pstmt.setString(3, student.getMajor());
			pstmt.setInt(4, student.getScore());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	public int studentDelete(int stdId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM student WHERE std_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	public int changeMajor(Student std) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE student SET major = ? WHERE std_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getMajor());
			pstmt.setInt(2, std.getStdId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

}
