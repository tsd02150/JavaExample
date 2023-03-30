package com.yedam.oop;

public class Student {
	// 학생이름, 학번,국영수 점수
	// 기본생성자와 모든데이터를 초기화 할 수 있다
	// 학생정보를 출력하는 getInfo()
	// 추가될 내용
	// 1) 총점
	// 2) 평균
	// 이름 : 김또치
	// 학번 : 20230330
	// 총점 : 200
	// 평균 : 68.xxx
	
	String studentName;
	int studentNo;
	int kor;
	int eng;
	int mat;
	static int staticVal;

	public Student() {
		
	}

	public Student(String studentName, int studentNo, int kor, int eng, int mat) {
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	void getInfo() {
		int sum = this.kor+this.eng+this.mat;
		double avg = (double)sum/3;
		System.out.println("이름 : "+this.studentName);
		System.out.println("학번 : "+this.studentNo);
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+avg);
	}
}
