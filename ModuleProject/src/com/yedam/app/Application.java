package com.yedam.app;

import java.util.Scanner;

import com.yedam.board.BoardService;
import com.yedam.calendar.CalendarService;
import com.yedam.categorys.CategorysService;
import com.yedam.comment.CommentService;
import com.yedam.member.MemberDAO;
import com.yedam.member.MemberService;
import com.yedam.team.TeamService;

public class Application {
	Scanner sc = new Scanner(System.in);
	BoardService boardService = new BoardService();
	CalendarService calendarService = new CalendarService();
	CategorysService categorysService = new CategorysService();
	CommentService commentService = new CommentService();
	MemberService memberService = new MemberService();
	TeamService teamService = new TeamService();

	public Application() {
		run();
	}

	private void run() {
		mainMenu();
	}

	private void mainMenu() {
		int menu = 99;
		boolean run = true;
		while (run) {
			System.out.print("|1. 회원 관리 | 2. 팀 관리 | 3. 팀 매칭 | 4. 게시판 | 5. ");
			if (memberService.memberState()) {
				System.out.print("로그인");
			} else {
				System.out.print("<" + memberService.memberInfo.getName() + ">님 로그아웃");
			}
			System.out.println(" | 0. 종료 |");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				manageMember();
				break;
			case 2:
				manageTeam();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				logInOut();
				break;
			case 0:
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
		}
	}

	private void logInOut() {
		if (memberService.memberState()) {
			login();
		} else {
			memberService.logout();
		}
	}

	private void login() {
		int menu = 99;
		while (true) {
			System.out.println("1. 로그인 | 2. 회원가입 | 3. ID찾기 | 4. PW찾기 | 0. 종료");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				memberService.login();
				if(memberService.memberInfo!=null) {
					break;
				}
			} else if (menu == 2) {
				memberService.memberAdd();
			} else if (menu == 3) {
				memberService.searchId();
			} else if (menu == 4) {
				memberService.searchPw();
			} else if (menu == 0) {
				break;
			}
		}
	}

	private void manageMember() {
		if (memberService.memberInfo == null) {
			System.out.println("로그인이 필요 합니다.");
		} else {
			if (memberService.memberInfo.getGrade() == 1) {
				manageMemberAdmin();
			} else if (memberService.memberInfo.getGrade() == 2) {
				manageMemberUser();
			}
		}

	}

	private void manageMemberAdmin() {
		while (true) {
			int menu = 99;
			System.out.println("1. 전체 조회 | 2. 단건 조회 | 3. 회원 추가 | 4. 정보 수정 | 5. 회원 삭제 | 0. 종료");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				memberService.getAllMember();
			} else if (menu == 2) {
				memberService.getMember();
			} else if (menu == 3) {
				memberService.memberAdd();
			} else if (menu == 4) {
				memberService.updateMember();
			} else if (menu == 5) {
				memberService.deleteMemberAdmin();
			} else if (menu == 0) {
				break;
			}
		}

	}

	private void manageMemberUser() {
		while (true) {
			int menu = 99;
			System.out.println("1. 내 정보 조회 | 2. 내 정보 수정 | 3. 회원 탈퇴 | 4. 내팀 조회 | 0. 종료");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				memberService.getMember();
			} else if (menu == 2) {
				memberService.updateMember();
			} else if (menu == 3) {
				memberService.deleteMemberUser();
			} else if (menu == 4) {
				memberService.myTeamInfo();
			} else if (menu == 0) {
				break;
			}
		}
	}

	private void manageTeam() {
		boolean run = true;
		while (run) {
			if (memberService.memberInfo == null) {
				System.out.println("로그인이 필요 합니다.");
				break;
			}
			if (memberService.memberInfo.getGrade() == 1) {
				run = manageTeamAdmin();
			} else if (memberService.memberInfo.getGrade() == 2) {
				if (teamService.getTeamGrade() == 1) {
					run = manageTeamReader();
				} else if (teamService.getTeamGrade() == 2) {
					run = manageTeamPersonal();
				}
			}
		}
	}

	private boolean manageTeamAdmin() {
		int menu = 99;
		System.out.println("1. 팀 조회 | 2. 단건 조회 | 3. 팀 추가 | 4. 팀 수정 | 5. 팀 삭제 | 0. 종료");
		System.out.print("메뉴 입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		if (menu == 1) {

		} else if (menu == 2) {

		} else if (menu == 3) {

		} else if (menu == 4) {

		} else if (menu == 5) {

		} else if (menu == 0) {
			return false;
		}
		return true;
	}

	private boolean manageTeamReader() {

		return true;
	}

	private boolean manageTeamPersonal() {

		return true;
	}
}
