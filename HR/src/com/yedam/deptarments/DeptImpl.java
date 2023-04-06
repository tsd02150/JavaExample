package com.yedam.deptarments;

import java.util.List;
import java.util.Scanner;

public class DeptImpl {
	Scanner sc = new Scanner(System.in);

	// 1) 전체 조회
	public void getDepartmentList() {
		List<DeptDTO> list = DeptDAO.getInstance().getDepartmentList();
		for (int i = 0; i < list.size(); i++) {
			System.out.print("부서 번호 : " + list.get(i).getDepartmentId());
			System.out.print("\t부서 이름 : " + list.get(i).getDepartmentName());
			System.out.print("\t매니저 번호 : " + list.get(i).getManagerId());
			System.out.print("\t지역 번호 : " + list.get(i).getLocationId());
			System.out.println();
		}
	}

	// 2) 부서 정보 조회(단건)
	public void getDepartment() {
		System.out.println("부서번호 >");
		int deptNo = Integer.parseInt(sc.nextLine());
		DeptDTO dept = DeptDAO.getInstance().getDepartment(deptNo);
		if (dept == null) {
			System.out.println("해당 부서는 존재 하지 않습니다.");
		} else {
			System.out.print("부서 번호 : " + dept.getDepartmentId());
			System.out.print("\t부서 이름 : " + dept.getDepartmentName());
			System.out.print("\t매니저 번호 : " + dept.getManagerId());
			System.out.print("\t지역 번호 : " + dept.getLocationId());
			System.out.println();
		}
	}

	// 3) 부서 생성(id,name)
	public void deptAdd() {
		DeptDTO dept = new DeptDTO();
		System.out.println("부서번호 >");
		int deptId = Integer.parseInt(sc.nextLine());
		System.out.println("부서이름 >");
		String deptName = sc.nextLine();
		dept.setDepartmentId(deptId);
		dept.setDepartmentName(deptName);
		int result = DeptDAO.getInstance().deptAdd(dept);
		if (result == 1) {
			System.out.println("데이터 입력 성공");
		} else {
			System.out.println("데이터 입력 실패");
		}
	}

	// 4) 부서 수정(mgr)
	public void deptUpdate() {
		DeptDTO dept = new DeptDTO();
		System.out.println("부서 번호 >");
		int deptId = Integer.parseInt(sc.nextLine());
		System.out.println("매니저 번호 >");
		int managerNo = Integer.parseInt(sc.nextLine());
		dept.setDepartmentId(deptId);
		dept.setManagerId(managerNo);
		int result = DeptDAO.getInstance().deptUpdate(dept);
		if (result > 0) {
			System.out.println(result + "개의 데이터 수정 완료");
		} else {
			System.out.println("데이터 수정 실패");
		}
	}
	// 5) 부서 삭제
	public void deptDelete() {
		System.out.println("부서 번호 >");
		int deptId = Integer.parseInt(sc.nextLine());
		int result = DeptDAO.getInstance().depatDelete(deptId);
		if (result > 0) {
			System.out.println("정상 삭제");
		} else {
			System.out.println("삭제 실패");
		}
	}
}
