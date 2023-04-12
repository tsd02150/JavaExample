package com.yedam.categorys;

import com.yedam.common.DAO;

public class CategorysDAO extends DAO{
	private static CategorysDAO categorysDao = null;
	private CategorysDAO() {
		
	}
	public static CategorysDAO getInstance() {
		if(categorysDao == null) {
			categorysDao = new CategorysDAO();
		}
		return categorysDao;
	}
	
	public String getCategoryName(int categoryNo) {
		String result=null;
		try {
			conn();
			String sql = "SELECT category_name FROM categorys WHERE category_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("category_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
