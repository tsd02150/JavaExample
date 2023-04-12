package com.yedam.calendar;

import java.sql.Date;

import lombok.Data;

@Data
public class Calendar {
//	calendar_no NUMBER PRIMARY KEY,
//	calendar_date DATE,
//	match VARCHAR(1),
//	team_no1 NUMBER REFERENCES team(team_no),
//	team_no2 NUMBER REFERENCES team(team_no));
	private int calendarNo;
	private Date calendarDate;
	private String match;
	private int teamNo1;
	private int teamNo2;
	
	private String teamName1;
	private String teamName2;
}
