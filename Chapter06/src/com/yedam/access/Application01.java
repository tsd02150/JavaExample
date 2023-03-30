package com.yedam.access;

public class Application01 {
	public static void main(String[] args) {
		Access ac = new Access();
		
		//public
		ac.free = "public";
		//protected
		ac.parent = "protected";
		//default
		ac.basic = "default";
		//private
		//ac.privacy = "private";
		
		
	}
}
