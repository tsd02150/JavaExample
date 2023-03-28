package com.yedam.homework;

public class test5 {
	public static void main(String[] args) {
		int intValue1 = 24;
		int intValue2 = 3;
		int intValue3 = 8;
		int intValue4 = 10;
		char charValue = 'A';
		String strValue = "번지";
		String num=intValue1+intValue2+String.valueOf(intValue3);
		double var4 = intValue4;
		
		System.out.println(charValue+num+strValue+var4);
		System.out.printf("%c%d%d%s%.1f",charValue,intValue1+intValue2,intValue3,strValue,var4);
	}
}
