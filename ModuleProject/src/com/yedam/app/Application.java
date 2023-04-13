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
		String menu = null;
		boolean run = true;
		while (run) {
			// 메뉴 목록 출력 ----------------------------------------------------------------------------
			clearConsole();
			System.out.print("==================================================================");
			if(memberService.memberInfo != null) {
				for(int i = 0;i<memberService.memberInfo.getName().length()+6;i++) {
					System.out.print("=");
				}
			}
			System.out.println();
			
			System.out.print(" 1. 회원 관리   2. 팀 관리   3. 팀 매칭   4. 게시판   5. ");
			if (memberService.memberInfo == null) {
				// 로그인 상태가 아니라면
				System.out.print("로그인");
			} else {
				// 로그인 상태라면 이름도 출력
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
			
			// ---------------------------------------------------------------------------------------
			
			// 입력에 따른 기능 --------------------------------------------------------------------------
			System.out.print("메뉴 입력 > ");
			menu = sc.nextLine();
			switch (menu) {
			case "1":								// 1. 회원관리
				manageMemberAuth();
				clearConsole();
				break;
			case "2":								// 2. 팀 관리
				manageTeamAuth();
				break;
			case "3":								// 3. 팀 매칭
				clearConsole();
				teamMatchAuth();
				break;
			case "4":								// 4. 게시판
				clearConsole();
				boardMenu();
				break;
			case "5":								// 5. 로그인, 로그아웃
				clearConsole();
				logInOut();
				break;
			case "0":								// 0. 종료
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:								// 다른 입력시 알림
				clearConsole();
				System.out.println("잘못 선택 하셨습니다.");
				break;
			}
			// ---------------------------------------------------------------------------------------
		}
	}
	
	// 콘솔 비우기
	public void clearConsole() {
		for(int i=0;i<80;i++) {
			System.out.println();
		}
	}
	
	
	// 2. 회원관리
	// 로그인 상태인지와 권한을 확인하여 메소드 각각 실행
	private void manageMemberAuth() {
		clearConsole();
		if (memberService.memberInfo == null) {
			// 로그인 상태가 아니라면 로그인창으로
			System.out.println(" <!> 로그인이 필요 합니다.");
			login();
		} else {
			if (memberService.memberInfo.getGrade() == 1) {
				// 관리자용 회원 관리
				manageMemberAdmin();
			} else if (memberService.memberInfo.getGrade() == 2) {
				// 사용자용 회원 관리
				manageMemberUser();
			}
		}

	}

	// 관리자용 회원관리
	// 등록된 회원 전체조회, 특정 회원 조회, 회원 추가, 회원 정보 수정, 회원 삭제의 기능 수행
	private void manageMemberAdmin() {
		while (true) {
			String menu = null;
			System.out.println("-------------------------------------------------------------------------");
			System.out.println(" 1. 전체 조회   2. 단건 조회   3. 회원 추가   4. 정보 수정   5. 회원 삭제   0. 종료 ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = sc.nextLine();
			clearConsole();
			if (menu.equals("1")) {							// 1. 회원 전체 조회
				memberService.getAllMember();
			} else if (menu.equals("2")) {					// 2. 특정 조건 회원 조회
				memberService.getMember();
			} else if (menu.equals("3")) {					// 3. 회원 추가
				memberService.memberAdd();
			} else if (menu.equals("4")) {					// 4. 회원 정보 수정
				memberService.updateMember();
			} else if (menu.equals("5")) {					// 5. 회원 삭제
				memberService.deleteMemberAdmin();
			} else if (menu.equals("0")) {					// 0. 종료
				break;
			}else {											// 주어진 목록 외 다른 입력시
				clearConsole();
				System.out.println(" <!> 잘못 선택 하셨습니다.");
			}
		}

	}

	// 사용자용 회원 관리
	// 본인 정보 조회, 본인 정보 수정, 회원 탈퇴, 본인이 속한 팀 조회 의 기능 수행
	private void manageMemberUser() {
		while (true) {
			String menu = null;
			System.out.println("------------------------------------------------------------------");
			System.out.println(" 1. 내 정보 조회   2. 내 정보 수정   3. 회원 탈퇴   4. 내 팀 조회   0. 종료 ");
			System.out.println("------------------------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = sc.nextLine();
			clearConsole();
			if (menu.equals("1")) {							// 1. 본인 정보 조회
				memberService.getMember();
			} else if (menu.equals("2")) {					// 2. 본인 정보 수정
				memberService.updateMember();
			} else if (menu.equals("3")) {					// 3. 회원 탈퇴
				memberService.deleteMemberUser();
				break;
			} else if (menu.equals("4")) {					// 4. 본인이 속한 팀 조회
				teamService.getTeamInfo();
			} else if (menu.equals("0")) {					// 0. 종료
				break;
			}else {											// 주어진 목록 외 다른 입력시
				clearConsole();
				System.out.println(" <!> 잘못 선택 하셨습니다.");
			}
		}
	}

	// 3. 팀 관리
	// 로그인 여부를 확인, 관리자계정인지 사용자계정인지 확인, 팀의 직책여부를 확인하여 각각의 메소드 실행
	private void manageTeamAuth() {
		clearConsole();
		if (memberService.memberInfo == null) {
			// 로그인 상태가 아니라면 로그인 창으로
			System.out.println(" <!> 로그인이 필요 합니다.");
			login();
		} else {
			if (memberService.memberInfo.getGrade() == 1) {
				// 관리자용 팀관리
				manageTeamAdmin();
				clearConsole();
			} else if (memberService.memberInfo.getGrade() == 2) {
				// 사용자용 팀관리
				if (teamService.teamInfo == null) {
					// 속한 팀이 없을시 접근 통제
					System.out.println(" <!> 팀이 없습니다.");
				} else {
					if (memberService.memberInfo.getTeamGrade() == 1) {
						// 팀장일 경우
						manageTeamReader();
						clearConsole();
					} else if (memberService.memberInfo.getTeamGrade() == 2) {
						// 팀원의 경우
						manageTeamPersonal();
						clearConsole();
					} else if (memberService.memberInfo.getTeamGrade() == 99) {
						// 팀에 신청은 했으나 아직 수락 대기중인 경우
						System.out.println(" <!>아직 팀 수락이 안되었습니다.");
					}
				}
			}
		}
	}

	// 관리자용 팀관리
	// 팀 전체 조회, 특정 팀 조회, 팀 추가, 팀 수정, 팀 삭제 의 기능 수행
	private void manageTeamAdmin() {
		while (true) {
			int menu = 99;
			System.out.println("-------------------------------------------------------------------");
			System.out.println(" 1. 팀 조회   2. 단건 조회   3. 팀 추가   4. 팀 수정   5. 팀 삭제   0. 종료");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {							// 1. 팀 전체 조회
				teamService.getAllTeamInfo();
			} else if (menu == 2) {						// 2. 특정 팀 조회
				teamService.getTeamInfo();
			} else if (menu == 3) {						// 3. 팀 추가
				teamService.addTeam();
			} else if (menu == 4) {						// 4. 팀 수정
				teamService.updateTeam();
			} else if (menu == 5) {						// 5. 팀 삭제
				teamService.deleteTeam();
			} else if (menu == 0) {						// 0. 종료
				break;
			}
		}
	}

	// 팀장용 팀관리
	// 본인 팀 조회, 경기 조회, 다른 팀 조회, 팀원 대기명단 확인하여 팀원 추가, 팀 정보 수정, 팀 삭제 의 기능 수행
	// 팀장의 경기 조회의 경우 수락된 매칭 뿐만아니라, 매칭이 거절되거나 매칭 수락 대기중인 경기까지 전부 확인
	private void manageTeamReader() {
		while (true) {
			int menu = 99;
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println(" 1. 내 팀 조회   2. 경기 조회   3. 팀 조회   4. 팀원 추가   5. 팀 수정   6. 팀 삭제   0. 종료");
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.print("메뉴 입력 > ");
			menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {							// 1. 본인 팀 조회
				teamService.getTeamInfo();
			} else if (menu == 2) {						// 2. 경기 조회
				clearConsole();
				teamService.searchMatch(); 
			} else if (menu == 3) {						// 3. 다른 팀 조회
				teamService.getAllTeamInfo();
			} else if (menu == 4) {						// 4. 수락 대기명단의 팀원 확인하여 팀원 추가
				clearConsole();
				teamService.addTeamMember();
				clearConsole();
			} else if (menu == 5) {						// 5. 본인 팀 수정
				teamService.updateTeam();
			} else if (menu == 6) {						// 6. 본인 팀 삭제
				teamService.deleteTeam();
				break;
			} else if (menu == 0) {						// 0. 종료
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
	
	private void teamMatchAuth() {
		if(memberService.memberInfo==null) {
			System.out.println(" <!> 로그인이 필요합니다.");
		}else {
			teamMatching();
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
				if (memberService.memberInfo.getTeamGrade() == 1) {
					teamService.addMatch();
				} else if (memberService.memberInfo.getTeamGrade() == 2) {
					System.out.println(" <!> 팀장이 아닙니다.");
				} else {
					System.out.println(" <!> 팀이 없습니다.");
				}
			} else if (menu == 3) {
				clearConsole();
				if (memberService.memberInfo.getTeamGrade() == 1) {
					teamService.searchMatchWait();
				} else if (memberService.memberInfo.getTeamGrade() == 2) {
					System.out.println(" <!> 팀장이 아닙니다.");
				}
			} else if (menu == 0) {
				clearConsole();
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
			clearConsole();
			if (menu == 0) {
				break;
			} else if (menu > 0 && menu <= 5) {
				boardService.boardList(menu);
			}
		}
	}
	
	
	// 5. 로그인, 로그아웃
		// 로그인 상태(memberInfo)에 따라 로그인 로그아웃 구별
		private void logInOut() {
			if (memberService.memberInfo == null) {
				login();
			} else {
				memberService.logout();
			}

		}
		
		// 로그인 선택시
		// 로그인, 회원가입, ID찾기, PW찾기의 선택지 제공
		private void login() {
			while (true) {
				String menu = null;
				System.out.println("-----------------------------------------------------");
				System.out.println(" 1. 로그인   2. 회원가입   3. ID찾기   4. PW찾기   0. 종료 ");
				System.out.println("-----------------------------------------------------");
				System.out.print("메뉴 입력 > ");
				menu = sc.nextLine();
				if (menu.equals("1")) {								// 1. 로그인
					memberService.login();
					if (memberService.memberInfo != null) {
						// 로그인이 성공적으로 이루어지면 login메소드 탈출
						break;
					}
				} else if (menu.equals("2")) {						// 2. 회원가입
					memberService.memberAdd();
				} else if (menu.equals("3")) {						// 3. ID찾기
					memberService.searchId();
				} else if (menu.equals("4")) {						// 4. PW찾기
					memberService.searchPw();
				} else if (menu.equals("0")) {						// 0. 종료
					clearConsole();
					break;
				} else {
					clearConsole();
					System.out.println(" <!> 잘못 선택 하셨습니다.");
				}
			}
		}
}
