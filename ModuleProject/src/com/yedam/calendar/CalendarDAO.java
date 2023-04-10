package com.yedam.calendar;

import com.yedam.common.DAO;

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
}
