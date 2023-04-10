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
}
