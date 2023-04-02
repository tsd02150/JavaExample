package com.yedam.homework;

public class Question2 {
	public static void main(String[] args) {
		Human human = new StandardWeightInfo("홍길동",168,45);
		human.getInformation();
		human = new ObesiryInfo("박둘이",168,90);
		human.getInformation();
	}
}
