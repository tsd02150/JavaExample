package com.yedam.student;

import java.util.List;
import java.util.Scanner;

public class StudentService {
	public static int sumScore = 0;
	public static double avg = 0;
	Scanner sc = new Scanner(System.in);
	
	public void getStudent() {
		List<Student> stdList = StudentDAO.getInstance().getStudent();
		for(int i=0;i<stdList.size();i++) {
			System.out.print("학번 : "+stdList.get(i).getStdId());
			System.out.print("\t이름 : "+stdList.get(i).getStdName());
			System.out.print("\t전공 : "+stdList.get(i).getMajor());
			System.out.print("\t점수 : "+stdList.get(i).getScore());
			System.out.println();
		}
		System.out.print("총점 : "+sumScore);
		System.out.println("평균 : "+avg);
	}
	
	public void studentAdd() {
		Student student = new Student();
		int result = 0;
		
		System.out.println("학생 학번 > ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("학생 이름 > ");
		String name = sc.nextLine();
		System.out.println("학생 전공 > ");
		String major = sc.nextLine();
		System.out.println("학생 점수 > ");
		int score = Integer.parseInt(sc.nextLine());
		
		student.setStdId(id);
		student.setStdName(name);
		student.setMajor(major);
		student.setScore(score);
		
		result = StudentDAO.getInstance().studentAdd(student);
		if(result != 0) {
			System.out.println("학생이 등록되었습니다.");
		} else {
			System.out.println("등록 실패");
		}
	}
	
	public void studentDelete() {
		int result = 0;
		System.out.println("삭제할 학생의 학번 >");
		int id = Integer.parseInt(sc.nextLine());
		result=StudentDAO.getInstance().studentDelete(id);
		if(result>0) {
			System.out.println("삭제 되었습니다.");
		}else {
			System.out.println("삭제 실패");
		}
	}
	public void changeMajor() {
		Student student=new Student();
		int result = 0;
		System.out.println("전공을 바꿀 학생의 학번 >");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("바꿀 전공 > ");
		String major = sc.nextLine();
		
		student.setStdId(id);
		student.setMajor(major);
		
		result = StudentDAO.getInstance().changeMajor(student);
		if(result>0) {
			System.out.println("변경 되었습니다.");
		}else {
			System.out.println("변경 실패");
		}
	}
	
}
