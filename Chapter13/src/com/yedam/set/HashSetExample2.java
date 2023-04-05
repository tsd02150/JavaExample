package com.yedam.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		// new -> 서로 같은 내용이지만 서로 다른 객체
		set.add(new Member("또치",10));
		set.add(new Member("또치",10));
		
		System.out.println("총 객체 수 : "+set.size());
	}
}
