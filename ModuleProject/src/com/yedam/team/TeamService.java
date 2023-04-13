package com.yedam.team;

import java.util.List;
import java.util.Scanner;

import com.yedam.calendar.Calendar;
import com.yedam.calendar.CalendarDAO;
import com.yedam.member.Member;
import com.yedam.member.MemberDAO;
import com.yedam.member.MemberService;

public class TeamService {
	Scanner sc = new Scanner(System.in);
	MemberService memberService = new MemberService();
	public static Team teamInfo = null;

	public void clearConsole() {
		for(int i=0;i<80;i++) {
			System.out.println();
		}
	}
	
	public void getAllTeamInfo() {
		List<Team> list = null;
		if(TeamService.teamInfo==null) {
			list = TeamDAO.getInstance().getAllTeamInfo();			
		} else if (memberService.memberInfo.getGrade() == 1) {
			list = TeamDAO.getInstance().getAllTeamInfo();
		} else if (memberService.memberInfo.getGrade() == 2) {
			list = TeamDAO.getInstance().getAllTeamInfo(teamInfo.getCategoryNo());
		}
		clearConsole();
		for (int i = 0; i < list.size(); i++) {
			System.out.print("팀명 : " + list.get(i).getTeamName());
			System.out.println("\t운동종류 : " + list.get(i).getCategoryName());
			if (i != list.size() - 1) {
				System.out.println("--------------------------------------------------");
			}
		}
	}

	public void getTeamInfo() {
		List<Team> team = null;
		String categoryName = null;
		String teamName = null;
		if (memberService.memberInfo.getGrade() == 1) {
			System.out.println("찾는 팀의 운동 종류를 입력하세요 > ");
			categoryName = sc.nextLine();
			System.out.println("찾을 팀명을 입력하세요 > ");
			teamName = sc.nextLine();
			team = TeamDAO.getInstance().getTeamInfo(TeamDAO.getInstance().getTeamNo(categoryName, teamName));
		} else if (memberService.memberInfo.getGrade() == 2) {
			if (teamInfo == null) {
				System.out.println("팀이 없습니다.");
				return;
			}
			team = TeamDAO.getInstance().getTeamInfo(teamInfo.getTeamNo());
		}

		clearConsole();
		System.out.print(" 팀명 : " + team.get(0).getTeamName());
		System.out.println("\t운동종류 : " + team.get(0).getCategoryName());
		System.out.println(" 팀원 :");
		if(team.get(0).getId()==null) {
			System.out.println(" \t팀원이 아직 없습니다.");
			return;
		}
		for(int i=0;i<team.size();i++) {
			System.out.print(" \tID : "+team.get(i).getId());
			System.out.print("\t이름 : "+team.get(i).getName());
			if(team.get(i).getTeamGrade()==1) {
				System.out.println("\t 팀장");
			}else {
				System.out.println("\t 팀원");
			}
		}

	}

	public void addTeam() {
		System.out.println("추가할 팀의 운동종류를 입력하세요 >");
		String categoryName = sc.nextLine();
		System.out.println("추가할 팀의 이름을 입력해주세요 >");
		String teamName = sc.nextLine();
		Team team = new Team();
		team.setCategoryName(categoryName);
		team.setTeamName(teamName);
		int result = TeamDAO.getInstance().addTeam(team);
		if (result > 0) {
			System.out.println("팀 추가 완료");
		} else {
			System.out.println("팀 추가 실패");
		}
	}

	public void updateTeam() {
		int result = 0;
		String newTeamName=null;
		if (memberService.memberInfo.getGrade() == 1) {
			System.out.println("수정할 팀의 운동 종류를 입력하세요 > ");
			String categoryName = sc.nextLine();
			System.out.println("수정할 팀의 이름을 입력해주세요 >");
			String oldTeamName = sc.nextLine();
			System.out.println("수정할 이름을 입력해주세요 > ");
			newTeamName = sc.nextLine();
			Team team = new Team();
			team.setCategoryName(categoryName);
			team.setTeamName(oldTeamName);
			result = TeamDAO.getInstance().updateTeam(team, newTeamName);
		} else if (memberService.memberInfo.getGrade() == 2) {
			System.out.println("수정할 이름을 입력해주세요 > ");
			newTeamName = sc.nextLine();
			result = TeamDAO.getInstance().updateTeam(teamInfo, newTeamName);
		}
		clearConsole();
		if (result > 0) {
			System.out.println("팀 수정 완료");
			teamInfo.setTeamName(newTeamName);
		} else {
			System.out.println("팀 수정 실패");
		}
	}

	public void deleteTeam() {
		int result = 0;
		if (memberService.memberInfo.getGrade() == 1) {
			System.out.println("삭제할 팀의 운동종류를 입력하세요 >");
			String categoryName = sc.nextLine();
			System.out.println("삭제할 팀의 이름을 입력해주세요 >");
			String teamName = sc.nextLine();
			Team team = new Team();
			team.setCategoryName(categoryName);
			team.setTeamName(teamName);
			result = TeamDAO.getInstance().deleteTeam(team);
		} else if (memberService.memberInfo.getGrade() == 2) {
			System.out.println(teamInfo);
			result = TeamDAO.getInstance().deleteTeam(teamInfo);
			teamInfo = null;
		}
		clearConsole();
		if (result > 0) {
			System.out.println("팀 삭제 완료");
		} else {
			System.out.println("팀 삭제 실패");
		}
	}

	public void addTeamMember() {
		while (true) {
			List<Member> list = MemberDAO.getInstance().getAllMember(memberService.memberInfo.getTeamNo(), 99);
			for (int i = 0; i < list.size(); i++) {
				System.out.println();
				System.out.print("이름 : " + list.get(i).getName());
				System.out.print("\tID : " + list.get(i).getId());
				System.out.print("\tPW : " + list.get(i).getPw());
				System.out.print("\t전화번호 : " + list.get(i).getPhoneNum());
				System.out.println("\te-mail : " + list.get(i).getEmail());
				System.out.println();
				if (i != list.size() - 1) {
					System.out.println("--------------------------------------------------");
				}
			}
			System.out.println("1. 팀원 추가   0. 종료");
			System.out.print("선택 :");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				System.out.println("팀에 추가할 사람 ID > ");
				String addMemberID = sc.nextLine();
				TeamDAO.getInstance().addTeamMember(addMemberID);

			} else if (menu == 0) {
				break;
			}
		}
	}

	public void searchMatch() {
		while (true) {
			List<Calendar> list = CalendarDAO.getInstance().searchMatch();
			for (int i = 1; i <= list.size(); i++) {
				System.out.print(" [" + i + "]");
				System.out.print("\t홈팀 : " + list.get(i - 1).getTeamName1()+"\t원정팀 : " + list.get(i - 1).getTeamName2());
				if (memberService.memberInfo.getTeamGrade() == 1) {
					if (list.get(i - 1).getMatch().equals("o")) {
						System.out.println(" \t매칭 수락 ");
					} else if (list.get(i - 1).getMatch().equals("x")) {
						System.out.println(" \t매칭 거절 ");
					} else if (list.get(i - 1).getMatch().equals("?")) {
						System.out.println(" \t매칭 대기 중 ");
					}
				}
				System.out.println("\t일정 : " + list.get(i - 1).getCalendarDate());
				System.out.println();
			}
			System.out.println();
			if (memberService.memberInfo.getTeamGrade() == 1) {
				System.out.print("1. 매칭 결정  ");
			}
			System.out.println(" 0.종료");
			System.out.print(" 선택 : ");
			String exit = sc.nextLine();
			if (exit.equals("0")) {
				clearConsole();
				break;
			} else if (exit.equals("1") && memberService.memberInfo.getTeamGrade() == 1) {
				int index = 0;
				String match = null;
				while (true) {
					System.out.println("매칭 결정할 번호 (0.종료)>");
					index = Integer.parseInt(sc.nextLine());
					if(index==0) {
						clearConsole();
						break;
					}else if(index>list.size()) {
						System.out.println("존재하지 않는 일정의 번호입니다.");
						continue;
					}
					if (!list.get(index - 1).getMatch().equals("?")) {
						System.out.println("이미 결정이 끝난 매칭입니다.");
						continue;
					}
					if(list.get(index-1).getTeamNo1()==memberService.memberInfo.getTeamNo()) {
						System.out.println("상대방의 매칭을 기다리는 중입니다.");
						continue;
					}
					
					System.out.println("결정 내용 > o , x");
					match = sc.nextLine();
					int result = CalendarDAO.getInstance().updateCalendar(list.get(index - 1).getCalendarNo(), match);
					
					if (result > 0) {
						System.out.println("매칭 변경 완료");
						break;
					} else {
						System.out.println("매칭 변경 실패");
						break;
					}
				}
			}
		}

	}

	public void searchMatchWait() {
		while (true) {
			List<Calendar> list = CalendarDAO.getInstance().searchMatchWait();
			for (int i = 1; i <= list.size(); i++) {
				System.out.println("\t[" + i + "]");
				System.out.print("\t홈팀 : " + list.get(i - 1).getTeamName1()+"\t원정팀 : " + list.get(i - 1).getTeamName2());
				System.out.println("\t매칭 대기 중");
				System.out.println("\t일정 : " + list.get(i - 1).getCalendarDate());
				System.out.println();
			}
			System.out.println();
			if (memberService.memberInfo.getTeamGrade() == 1) {
				System.out.print("1. 매칭 결정 |");
			}
			System.out.println(" 0.종료");
			String exit = sc.nextLine();
			if (exit.equals("0")) {
				break;
			} else if (exit.equals("1")) {
				int index = 0;
				String match = null;

				System.out.println("매칭 결정할 번호 >");
				index = Integer.parseInt(sc.nextLine());

				System.out.println("결정 내용 > o , x");
				match = sc.nextLine();

				int result = CalendarDAO.getInstance().updateCalendar(list.get(index - 1).getCalendarNo(), match);

				if (result > 0) {
					System.out.println("매칭 변경 완료");
				} else {
					System.out.println("매칭 변경 실패");
				}
			}

		}
	}

	public void addMatch() {
		System.out.println("매칭을 신청할 팀을 입력 (종료 : 0)>");
		String team2 = sc.nextLine();
		if(team2.equals("0")) {
			return;
		}
		System.out.println("매칭할 날짜를 입력 (yyyy-mm-dd) >");
		String date = sc.nextLine();
		int result = CalendarDAO.getInstance().addMatch(team2, date);
		clearConsole();
		if (result > 0) {
			System.out.println("매칭 신청 완료");

		} else {
			System.out.println("매칭 신청 실패");
		}
	}

}
