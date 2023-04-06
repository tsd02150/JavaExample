package com.yedam.member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	// impl = service
	// 로그인이 되어 있는지 여부에 따라 나뉨
	// 로그인 : 메뉴를 이동할 때 마다 그 로그인 정보가 남아 있어야 한다.
	// 정적 멤버(static)
	// 1. login
	// login 성공
	// login -> id/pw -> 정보 조회 성공 -> 로그인
	// 로그인 -> 정적 필드에게 로그인한 정보를 입력
	// login 실패
	// 정보 조회 실패 -> 정적 필드에 데이터 안 넣어준다.
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);

	public void login() {
		// id 입력
		System.out.println("ID >");
		String id = sc.nextLine();
		System.out.println("PW >");
		String pw = sc.nextLine();

		// 1. member == null (id가 없다.)
		// 2. member != null (회원 정보가 있다.)
		Member member = MemberDAO.getInstance().login(id);
		if (member != null) {
			if (member.getPw().equals(pw)) {
				System.out.println("정상 로그인 되었습니다.");
				System.out.println(member.getName() + "님 환영합니다.");
				memberInfo = member;
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}

		} else {
			System.out.println("아이디가 존재하지 안습니다.");
		}
	}

	public void logout() {
		memberInfo = null;
		System.out.println("로그 아웃 성공.");
	}
	
	// 전체 조회
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberList();
		for(Member member : list) {
			System.out.println("ID : "+ member.getId());
			System.out.println("PW : "+ member.getPw());
			System.out.println("NM : "+ member.getName());
		}
	}
	
	// 회원 등록
	public void memberAdd() {
		int result = 0;
		String id = "";
		while(true) {
			System.out.println("ID >");
			id = sc.nextLine();
			Member member = MemberDAO.getInstance().login(id);
			if(member == null) {
				System.out.println("회원가입 가능");
				break;
			}else {
				System.out.println("ID중복, 재입력");
			}
		}
		System.out.println("PW >");
		String pw = sc.nextLine();
		System.out.println("이름 >");
		String name = sc.nextLine();
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		result = MemberDAO.getInstance().memberAdd(member);
		if(result != 0) {
			System.out.println("회원이 등록되었습니다.");
		}else {
			System.out.println("회원 등록 실패");
		}
	}
	
	// 회원 탈퇴
	public void memberDelete() {
		int result = MemberDAO.getInstance().memberDelete(memberInfo);
		if(result > 0) {
			System.out.println("회원탈퇴되였습니다.");
			memberInfo=null;
		}else {
			System.out.println("회원 탈퇴 실패");
		}
		
	}
	
	// 회원 수정
	public void memberUpdate() {
		int result =0;
		System.out.println("현재 비밀번호 >");
		String oldPw = sc.nextLine();
		if(oldPw.equals(memberInfo.getPw())) {
			System.out.println("일치합니다.");
		}else {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		System.out.println("수정할 ID >");
		String id = sc.nextLine();
		System.out.println("수정할 비밀번호 >");
		String newPw = sc.nextLine();
		Member member = new Member();
		member.setId(id);
		member.setPw(newPw);
		result = MemberDAO.getInstance().memberUpdate(member);
		if(result>0) {
			System.out.println("수정 되었습니다.");
			memberInfo=MemberDAO.getInstance().login(id);
		}else {
			System.out.println("수정 실패했습니다.");
		}
		
	}
}
