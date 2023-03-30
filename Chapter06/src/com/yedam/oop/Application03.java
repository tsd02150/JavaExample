package com.yedam.oop;

public class Application03 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();

		cal.sum(10, 20);

		int result = cal.sum3(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println("sum3 : " + result);

		result = cal.sum4(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("sum4 : " + result);

		Bycle bycle = new Bycle();
		bycle.setGas(5);

		boolean gasState = bycle.isLeftGas();
		if (gasState) {
			System.out.println("출발");
			bycle.run();
		}
		if (bycle.isLeftGas()) {
			System.out.println("gas 주입 필요없음.");
		} else {
			System.out.println("gas 주입 필요");
		}

		double result2 = cal.avg();
		System.out.println("평균 : " + result2);

		double result3 = cal.areaRectangle(10);
		double result4 = cal.areaRectangle(10, 20);
		System.out.println("정사각형 넓이 : "+result3);
		System.out.println("직사각형 넓이 : "+result4);
		
		Book java = new Book("혼자 공부하는 자바","학습서",24000,"yedam001","한빛 미디어");
		Book html = new Book("HTML","학습서",15000,"yedam002","길벗");
		Book js = new Book("JavaScript","학습서",20000,"yedam003","길벗");
		
		java.getInfo();
		html.getInfo();
		js.getInfo();
		
		Student std1 = new Student("김또치",20230330,95,78,86);
		std1.getInfo();
		Student std2 = new Student("김둘리",20230330,95,78,86);
		std2.getInfo();

		int b = 1;

		System.out.println(System.identityHashCode(Student.staticVal)); //메소드 영역
		System.out.println(System.identityHashCode(std1)); //힙
		System.out.println(System.identityHashCode(std1.studentName)); //힙
		System.out.println(System.identityHashCode(b)); //스택

		
	}
}
