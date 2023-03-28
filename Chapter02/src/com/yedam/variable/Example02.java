package com.yedam.variable;

public class Example02 {
	public static void main(String[] args) {
		//자동 타입 변환
		char charVal = 'A'+1;
		System.out.println(charVal);
		int iVal = charVal;
		System.out.println(iVal);
		double dVal = iVal;
		System.out.println(dVal+"\n"); 
		 
		//강제 타입 변환
		iVal = (int)dVal;
		System.out.println(iVal);
		charVal = (char)iVal;
		System.out.println(charVal+"\n");
		
		double dVal2 = Math.PI;
		int iVal2 = (int)dVal2;
		System.out.println(iVal2+"\n");
		
		//자동 타입 변환을 활용한 연산
		byte result = 10+20;
		System.out.println(result + "\n");
		
		byte x = 10;
		byte y = 20;
//		int result2 = x+y;
		
		//강제타입변환
		byte result2 = (byte)(x+y);
		
		// 데이터 타입 크기에 따른 연산
		// long + int = long
		// byte + int = int
		// double + int = double
		byte bVal = 10;
		int iVal1 = 100;
		long lVal = 1000;
		long result3 = bVal + iVal1 + lVal;
		System.out.println(result3 + "\n");
		
		int iVal3 = 1;
		double dVal3 = (double)iVal3/2;
		System.out.println(dVal3);
		
		
	}
}
