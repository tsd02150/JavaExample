package com.yedam.API;

import java.util.HashMap;

public class ObjectExample {
	public static void main(String[] args) {
		Member member1 = new Member("123");
		Member member2 = new Member("123");
		Member member3 = new Member("321");
		
		System.out.println(member1.equals(member2));
		System.out.println(member1.equals(member3));
		
		HashMap<Key,String> hashMap = new HashMap<>();
		hashMap.put(new Key(1), "홍길동");
		String value = hashMap.get(new Key(1));
		System.out.println(value);
		
		HashMap<Member,String> hashMap2 = new HashMap<>();
		hashMap2.put(new Member("열쇠"),"또치");
		String value2 = hashMap2.get(new Member("열쇠"));
		System.out.println(value2);
		
		Object obj = new Object();
		System.out.println(obj.toString());
		System.out.println(member1);
		System.out.println(member2.toString());
		System.out.println(member3.toString());
		
	}
}
