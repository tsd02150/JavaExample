package com.yedam.app;

import java.util.Scanner;

import com.yedam.board.BoardService;
import com.yedam.member.MemberDAO;
import com.yedam.member.MemberService;
import com.yedam.team.TeamService;

public class Application {
	Scanner sc = new Scanner(System.in);
	BoardService boardService = new BoardService();
	MemberService memberService = new MemberService();
	TeamService teamService = new TeamService();

	public Application() {
		run();
	}

	private void run() {
		mainMenu();
	}

	private void mainMenu() {
		String menu = null;
		boolean run = true;
		while (run) {
			System.out.print("==================================================================");
			if(memberService.memberInfo != null) {
				for(int i = 0;i<memberService.memberInfo.getName().length()+6;i++) {
					System.out.print("=");
				}
			}
			System.out.println();
			
			System.out.print(" 1. 회원 관리   2. 팀 관리   3. 팀 매칭   4. 게시판   5. ");
			if (memberService.memberInfo == null) {
				System.out.print("로그인");
			} else {
				System.out.print("<" + memberService.memberInfo.getName() + ">님 로그아웃");
			}
			System.out.println("   0. 종료  ");
			
			System.out.print("==================================================================");
			if(memberService.memberInfo != null) {
				for(int i = 0;i<memberService.memberInfo.getName().length()+6;i++) {
					System.out.print("=");
				}
			}
			System.out.println();
			
			System.out.print("메뉴 입력 > ");
			menu = sc.nextLine();
			switch (menu) {
			case "1":
				manageMember();
				clearConsole();
				break;
			case "2":
				manageTeam();
				clearConsole();
				break;
			case "3":
				clearConsole();
				teamMatching();
				clearConsole();
				break;
			case "4":
				clearConsole();
				boardMenu();
				clearConsole();
				break;
			case "5":
				clearConsole();
				logInOut();
				break;
			case "0":
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				clearConsole();
				System.out.println("잘못 선택 하셨습니다.");
				break;
			}
		}
	}
	public void clearConsole() {
		for(int i=0;i<80;i++) {
			System.out.println();
		}
	}

	private void logInOut() {
		if (memberService.memberInfo == null) {
			login();
		} else {
			memberService.logout();
		}

	}

	private void login() {
		while (true) {
			String menu = null;
			System.out.println("-----------------------------------------------------");
			System.out.println(" 1. 로그인   2. 회원가입   3. ID찾기   4. PW찾기   0. 종료 ");
			System.out.println("-----------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = sc.nextLine();
			if (menu.equals("1")) {
				memberService.login();
				if (memberService.memberInfo != null) {
					break;
				}
			} else if (menu.equals("2")) {
				memberService.memberAdd();
			} else if (menu.equals("3")) {
				memberService.searchId();
			} else if (menu.equals("4")) {
				memberService.searchPw();
			} else if (menu.equals("0")) {
				break;
			} else {
				clearConsole();
				System.out.println(" <!> 잘못 선택 하셨습니다.");
			}
		}
	}

	private void manageMember() {
		clearConsole();
		if (memberService.memberInfo == null) {
			System.out.println(" <!> 로그인이 필요 합니다.");
			login();
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
			String menu = null;
			System.out.println("-------------------------------------------------------------------------");
			System.out.println(" 1. 전체 조회   2. 단건 조회   3. 회원 추가   4. 정보 수정   5. 회원 삭제   0. 종료 ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = sc.nextLine();
			clearConsole();
			if (menu.equals("1")) {
				memberService.getAllMember();
			} else if (menu.equals("2")) {
				memberService.getMember();
			} else if (menu.equals("3")) {
				memberService.memberAdd();
			} else if (menu.equals("4")) {
				memberService.updateMember();
			} else if (menu.equals("5")) {
				memberService.deleteMemberAdmin();
			} else if (menu.equals("0")) {
				break;
			}else {
				clearConsole();
				System.out.println(" <!> 잘못 선택 하셨습니다.");
			}
		}

	}

	private void manageMemberUser() {
		while (true) {
			String menu = null;
			System.out.println("------------------------------------------------------------------");
			System.out.println(" 1. 내 정보 조회   2. 내 정보 수정   3. 회원 탈퇴   4. 내 팀 조회   0. 종료 ");
			System.out.println("------------------------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = sc.nextLine();
			clearConsole();
			if (menu.equals("1")) {
				memberService.getMember();
			} else if (menu.equals("2")) {
				memberService.updateMember();
			} else if (menu.equals("3")) {
				memberService.deleteMemberUser();
				break;
			} else if (menu.equals("4")) {
				teamService.getTeamInfo();
			} else if (menu.equals("0")) {
				break;
			}else {
				clearConsole();
				System.out.println(" <!> 잘못 선택 하셨습니다.");
			}
		}
	}

	private void manageTeam() {
		clearConsole();
		if (memberService.memberInfo == null) {
			System.out.println(" <!> 로그인이 필요 합니다.");
			login();
		} else {
			if (memberService.memberInfo.getGrade() == 1) {
				manageTeamAdmin();
			} else if (memberService.memberInfo.getGrade() == 2) {
				if (teamService.teamInfo == null) {
					System.out.println(" <!> 팀이 없습니다.");
				} else {
					if (memberService.memberInfo.getTeamGrade() == 1) {
						manageTeamReader();
					} else if (memberService.memberInfo.getTeamGrade() == 2) {
						manageTeamPersonal();
					} else if (memberService.memberInfo.getTeamGrade() == 99) {
						System.out.println(" <!>아직 팀 수락이 안되었습니다.");
					}
				}
			}
		}
	}

	private void manageTeamAdmin() {
		while (true) {
			int menu = 99;
			System.out.println("-------------------------------------------------------------------");
			System.out.println(" 1. 팀 조회   2. 단건 조회   3. 팀 추가   4. 팀 수정   5. 팀 삭제   0. 종료");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				teamService.getAllTeamInfo();
			} else if (menu == 2) {
				teamService.getTeamInfo();
			} else if (menu == 3) {
				teamService.addTeam();
			} else if (menu == 4) {
				teamService.updateTeam();
			} else if (menu == 5) {
				teamService.deleteTeam();
			} else if (menu == 0) {
				break;
			}
		}
	}

	private void manageTeamReader() {
		while (true) {
			int menu = 99;
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println(" 1. 내 팀 조회   2. 경기 조회   3. 팀 조회   4. 팀원 추가   5. 팀 수정   6. 팀 삭제   0. 종료");
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				teamService.getTeamInfo();
			} else if (menu == 2) {
				clearConsole();
				teamService.searchMatch();
			} else if (menu == 3) {
				teamService.getAllTeamInfo();
			} else if (menu == 4) {
				clearConsole();
				teamService.addTeamMember();
				clearConsole();
			} else if (menu == 5) {
				teamService.updateTeam();
			} else if (menu == 6) {
				teamService.deleteTeam();
				break;
			} else if (menu == 0) {
				break;
			}
		}
	}

	private void manageTeamPersonal() {
		while (true) {
			int menu = 99;
			System.out.println("----------------------------------------------");
			System.out.println(" 1. 내 팀 조회   2. 경기 조회   3. 팀 조회   0. 종료");
			System.out.println("----------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				teamService.getTeamInfo();
			} else if (menu == 2) {
				clearConsole();
				teamService.searchMatch();
			} else if (menu == 3) {
				teamService.getAllTeamInfo();
			} else if (menu == 0) {
				break;
			}
		}
	}

	private void boardMenu() {
		while (true) {
			int menu = 99;
			System.out.println("-----------------------------------------------------");
			System.out.println(" 1. 축구   2. 야구   3. 농구   4. 그외   5. 익명   0. 종료");
			System.out.println("-----------------------------------------------------");
			System.out.println("선택 >");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 0) {
				break;
			} else if (menu > 0 && menu <= 5) {
				boardService.boardList(menu);
			}
		}
	}

	private void teamMatching() {
		while (true) {
			int menu = 99;
			System.out.println("-------------------------------------------------");
			System.out.println(" 1. 팀 조회   2. 팀 매칭 신청   3. 팀 매칭 확인   0.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택>");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				teamService.getAllTeamInfo();
			} else if (menu == 2) {
				clearConsole();
				if(memberService.memberInfo == null) {
					System.out.println(" <!> 로그인이 필요합니다.");
				}else if (memberService.memberInfo.getTeamGrade() == 1) {
					teamService.addMatch();
				} else if (memberService.memberInfo.getTeamGrade() == 2) {
					System.out.println(" <!> 팀장이 아닙니다.");
				} else {
					System.out.println(" <!> 팀이 없습니다.");
				}
			} else if (menu == 3) {
				clearConsole();
				if(memberService.memberInfo == null) {
					System.out.println(" <!> 로그인이 필요합니다.");
				}else if (memberService.memberInfo.getTeamGrade() == 1) {
					teamService.searchMatchWait();
				} else if (memberService.memberInfo.getTeamGrade() == 2) {
					System.out.println(" <!> 팀장이 아닙니다.");
				}
			} else if (menu == 0) {
				break;
			}
		}
	}
}
