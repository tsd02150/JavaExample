package com.yedam.deptarments;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class DeptDAO extends DAO{
	private static DeptDAO deptDao = null;
	private DeptDAO() {
		
	}
	public static DeptDAO getInstance() {
		if(deptDao == null) {
			deptDao = new DeptDAO();
		}
		return deptDao;
	}
	
	// 1) 전체 조회
	public List<DeptDTO> getDepartmentList() {
		List<DeptDTO> list = new ArrayList<DeptDTO>();
		try {
			conn();
			String sql = "SELECT * FROM departments";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				DeptDTO dept = new DeptDTO();
				
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
				
				list.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return list;
	}
	// 2) 부서 정보 조회(단건)
	public DeptDTO getDepartment(int departmentId) {
		DeptDTO dept =null;
		try {
			conn();
			String sql = "SELECT * FROM departments WHERE department_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dept = new DeptDTO();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return dept;
	}
	// 3) 부서 생성(id,name)
	public int deptAdd(DeptDTO dept) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO departments (department_id,department_name) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return result;
	}
	// 4) 부서 수정(mgr)
	public int deptUpdate(DeptDTO dept) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE departments SET manager_id = ? WHERE department_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getManagerId());
			pstmt.setInt(2, dept.getDepartmentId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return result;
	}
	// 5) 부서 삭제
	public int depatDelete(int departmentId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM departments WHERE department_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return result;
	}
}
