package com.yedam.coffee;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CoffeeDAO extends DAO {
	private static CoffeeDAO coffeeDao = null;

	private CoffeeDAO() {

	}

	public static CoffeeDAO getInstance() {
		if (coffeeDao == null) {
			coffeeDao = new CoffeeDAO();
		}
		return coffeeDao;
	}

	// 메뉴 조회
	public List<Coffee> getCoffeeMenu() {
		List<Coffee> coffeeList = new ArrayList<Coffee>();
		try {
			conn();
			String sql = "SELECT coffee_menu,coffee_price FROM coffee";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Coffee coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffeeList.add(coffee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return coffeeList;
	}

	// 메뉴 상세 조회
	public Coffee getCoffeeInfo(String coffeeMenu) {
		Coffee coffee = null;
		try {
			conn();
			String sql = "SELECT coffee_menu,coffee_price,coffee_explain FROM coffee WHERE coffee_menu=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffeeMenu);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffee.setCoffeeExplain(rs.getString("coffee_explain"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return coffee;
	}

	// 메뉴 등록
	public int menuAdd(Coffee coffee) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO coffee VALUES(?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee.getCoffeeMenu());
			pstmt.setInt(2, coffee.getCoffeePrice());
			pstmt.setString(3, coffee.getCoffeeExplain());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 판매
	public int coffeeSell(String coffeeMenu) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE coffee SET coffee_sales=coffee_sales+1 WHERE coffee_menu=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffeeMenu);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 메뉴 삭제
	public int menuDelete(String coffeeMenu) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM coffee WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffeeMenu);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// 매출 확인
	public List<Coffee> getSales() {
		List<Coffee> coffeeList = new ArrayList<Coffee>();
		try {
			conn();
			String sql = "SELECT coffee_menu,coffee_sales,coffee_price FROM coffee";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Coffee coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeeSales(rs.getInt("coffee_sales"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffeeList.add(coffee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return coffeeList;
	}

}
