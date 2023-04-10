package com.yedam.member;

import java.util.List;
import java.util.Scanner;

import com.yedam.team.Team;
import com.yedam.team.TeamDAO;

public class MemberService {
	Scanner sc = new Scanner(System.in);
	public static Member memberInfo = null;

	public boolean memberState() {
		boolean state = false;
		if (memberInfo == null) {
			state = true;
		}
		return state;
	}

	public void login() {
		Member member = null;
		System.out.print("ID 입력 > ");
		String id = sc.nextLine();
		System.out.print("PW 입력 > ");
		String pw = sc.nextLine();

		member = MemberDAO.getInstance().login(id);

		if (member != null) {
			if (pw.equals(member.getPw())) {
				System.out.println("로그인 성공");
				System.out.println(member.getName() + "님 반갑습니다.");
				memberInfo = member;
			} else {
				System.out.println("로그인 실패");
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("로그인 실패");
			System.out.println("없는 아이디 입니다.");
		}
	}

	public void logout() {
		if (memberInfo != null) {
			memberInfo = null;
			System.out.println("로그아웃 되었습니다.");
		}
	}

	public void memberAdd() {
		System.out.print("ID > ");
		String Id = sc.nextLine();
		System.out.print("PW > ");
		String pw = sc.nextLine();
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("이메일 > ");
		String email = sc.nextLine();
		System.out.print("전화번호 > ");
		String phoneNum = sc.nextLine();
		System.out.print("해당된 팀이 있으면 1, 없으면 2 입력 > ");
		int teamCheck = Integer.parseInt(sc.nextLine());
		String teamName = null;
		if (teamCheck == 1) {
			System.out.print("팀 이름 입력 >");
			teamName = sc.nextLine();
		}

		Member member = new Member();
		member.setId(Id);
		member.setPw(pw);
		member.setName(name);
		member.setEmail(email);
		member.setPhoneNum(phoneNum);

		int result = MemberDAO.getInstance().memberAdd(member, teamName);

		if (result > 0) {
			System.out.println("회원가입 되었습니다.");
		} else {
			System.out.println("회원가입 실패");
		}
	}

	public void searchId() {
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("전화번호 > ");
		String phoneNum = sc.nextLine();

		String id = MemberDAO.getInstance().searchId(name, phoneNum);

		if (id != null) {
			System.out.println("ID는 < " + id + " >입니다.");
		} else {
			System.out.println("해당하는 계정의 ID가 없습니다.");
		}
	}

	public void searchPw() {
		Member member = null;
		String pw;

		System.out.print("ID > ");
		String id = sc.nextLine();
		System.out.println("이름 > ");
		String name = sc.nextLine();

		member = MemberDAO.getInstance().searchPw(id);

		if (member != null) {
			if (name.equals(member.getName())) {
				pw = member.getPw();
				System.out.println("PW는 < " + pw + " >입니다.");
			} else {
				System.out.println("이름이 일치하지 않습니다.");
			}
		} else {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
	}

	public void getAllMember() {
		List<Member> list = MemberDAO.getInstance().getAllMember();
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.print("이름 : " + list.get(i).getName());
			System.out.print("\tID : " + list.get(i).getId());
			System.out.print("\tPW : " + list.get(i).getPw());
			System.out.println("\t전화번호 : " + list.get(i).getPhoneNum());
			System.out.print("e-mail : " + list.get(i).getEmail());
			if(list.get(i).getTeamName() == null) {
				System.out.print("\t팀 없음");
			}else {
				System.out.print("\t팀이름 : " + list.get(i).getTeamName());								
			}
			if (list.get(i).getGrade() == 1) {
				System.out.println("\t등급 : 관리자");
			} else if (list.get(i).getGrade() == 2) {
				System.out.println("\t등급 : 유저");
			}
			System.out.println();
			if (i != list.size() - 1) {
				System.out.println("--------------------------------------------------");
			}
		}
	}

	public void getMember() {
		Member member = null;
		if (memberInfo.getGrade() == 1) {
			System.out.print("ID 입력 > ");
			String id = sc.nextLine();
			member = MemberDAO.getInstance().getMember(id);
		} else if (memberInfo.getGrade() == 2) {
			member = MemberDAO.getInstance().getMember(memberInfo.getId());
		}

		if (member != null) {
			System.out.println();
			System.out.print("이름 : " + member.getName());
			System.out.print("\tID : " + member.getId());
			System.out.print("\tPW : " + member.getPw());
			System.out.println("\t전화번호 : " + member.getPhoneNum());
			System.out.print("e-mail : " + member.getEmail());
			System.out.print("\t팀이름 : " + member.getTeamName());
			if (memberInfo.getGrade() == 1) {
				if (member.getGrade() == 1) {
					System.out.println("\t등급 : 관리자");
				} else if (member.getGrade() == 2) {
					System.out.println("\t등급 : 유저");
				}
			} else {
				System.out.println();
			}
			System.out.println();
		} else {
			System.out.println("해당하는 이용자가 없습니다.");
		}
	}

	public void updateMember() {
		int result = 0;
		String searchId = null;
		if (memberInfo.getGrade() == 1) {
			System.out.println("수정할 ID를 입력해 주세요.");
			searchId = sc.nextLine();
		} else if (memberInfo.getGrade() == 2) {
			searchId = memberInfo.getId();
		}
		while (true) {
			int change = 99;
			System.out.println("수정할 내용을 골라주세요.");
			System.out.println("1. ID | 2. PW | 3. 이름 | 4. 전화번호 | 5. e-mail | 6. 팀 | 0. 종료");
			change = Integer.parseInt(sc.nextLine());
			if(change==1) {
				System.out.println("변경 ID > ");
				String id = sc.nextLine();
				Object chageObject = id;
				result = MemberDAO.getInstance().updateMember(searchId, "id", chageObject);
			}else if(change ==2) {
				System.out.println("변경 PW > ");
				String pw = sc.nextLine();		
				Object chageObject = pw;
				result = MemberDAO.getInstance().updateMember(searchId, "pw", chageObject);
			}else if(change ==3) {
				System.out.println("변경 이름 > ");
				String name = sc.nextLine();
				Object chageObject = name;
				result = MemberDAO.getInstance().updateMember(searchId, "name", chageObject);
			}else if(change ==4) {
				System.out.println("변경 전화번호 > ");
				String num = sc.nextLine();
				Object chageObject = num;
				result = MemberDAO.getInstance().updateMember(searchId, "phone_num", chageObject);
			}else if(change ==5) {
				System.out.println("변경 이메일 > ");
				String email = sc.nextLine();
				Object chageObject = email;
				result = MemberDAO.getInstance().updateMember(searchId, "email", chageObject);
			}else if(change ==6) {
				System.out.println("변경 팀 > ");
				String teamName = sc.nextLine();
				Object chageObject = teamName;
				result = MemberDAO.getInstance().updateMember(searchId, "team_no", chageObject);
			}else if(change ==0) {
				break;
			}
			
			if(result > 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
		}
	}

	public void deleteMemberAdmin() {
		System.out.print("삭제할 ID를 입력해주세요 > ");
		String id = sc.nextLine();
		System.out.print("PW를 입력해주세요 > ");
		String pw = sc.nextLine();
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		int result = MemberDAO.getInstance().deleteMember(member);
		if (result > 0) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("정보가 일치하지 않습니다.");
		}
	}

	public void deleteMemberUser() {
		System.out.print("PW를 입력해주세요 > ");
		String pw = sc.nextLine();
		int result = 0;
		if (memberInfo.getPw().equals(pw)) {
			result = MemberDAO.getInstance().deleteMember(memberInfo);
			if (result > 0) {
				memberInfo = null;
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제 실패");
			}
		} else {
			System.out.println("패스워드가 일치하지 않습니다.");
		}
	}
	
	public void myTeamInfo() {
		Team team = TeamDAO.getInstance().getTeamInfo(memberInfo.getTeamNo());
		System.out.print("팀명 : " + team.getTeamName());
		System.out.println("\t운동종류 : "+team.getCategoryNo());
	}

}
