package com.yedam.access;

public class Application03 {
	public static void main(String[] args) {
		Member obj1 = Member.getInstance();
		Member obj2 = Member.getInstance();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1==obj2);
		
		obj1.getInfo();
		System.out.println(obj1.age);
	}
}
