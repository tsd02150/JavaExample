package com.yedam.oop;

public class Book {
	// book이라는 클래스는 아래의 정보를 가집니다.
	// 책이름, 책종류, 가격, 도서번호, 출판사
	String bookName;
	String bookCategory;
	int bookPrice;
	String bookNo;
	String publisher;
	
	// 생성자는 3개정도 생성
	//1) 기본생성자
	public Book() {
		
	}
	//2) 모든데이터 초기화 할수 있는 생성자
	public Book(String bookName,String bookCategory,int bookPrice,String bookNo,String publisher) {
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.bookPrice = bookPrice;
		this.bookNo = bookNo;
		this.publisher = publisher;
	}
	//3) 책이름,책가격,도서번호를 받아오는 생성자
	public Book(String bookName,String bookCategory,String bookNo) {
		this.bookName = bookName;
		this.bookCategory = bookCategory;
		this.bookNo = bookNo;
	}
	
	// 메소드는 getInfo() 메소드를가짐.
	// getInfo() 메소드를 클래스 외부에서 실행하였을때,
	// 다음과 같은 출력물이 나오도록 구현
	// 객체.getInfo()
	public void getInfo() {
		System.out.println("#책이름 : "+this.bookName);
		System.out.println("#내용");
		System.out.println("1) 종류 : "+this.bookCategory);
		System.out.println("2) 가격 : "+this.bookPrice+"원");
		System.out.println("3) 출판사 : "+this.publisher);
		System.out.println("4) 도서번호 : "+this.bookNo);
		System.out.println();
	}
	// #책이름 : 혼자 공부하는 자바
	// #내용
	// 1) 종류 : 학습서
	// 2) 가격 : 24000원
	// 3) 출판사 : 한빛미디어
	// 4) 도서번호 : yedam001
	
	// #책이름 : HTML
	// #내용
	// 1) 종류 : 학습서
	// 2) 가격 : 15000원
	// 3) 출판사 : 길벗
	// 4) 도서번호 : yedam002
	
	// #책이름 : JavaScript
	// #내용
	// 1) 종류 : 학습서
	// 2) 가격 : 20000원
	// 3) 출판사 : 길벗
	// 4) 도서번호 : yedam003
}
