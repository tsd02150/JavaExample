package com.yedam.team;

import java.sql.Date;

import lombok.Data;

@Data
public class Team {
	private int teamNo;
	private String teamName;
	private String teamGrade;
	private int categoryNo;
	
	private String name;
	private Date calendar_date;
	

}
