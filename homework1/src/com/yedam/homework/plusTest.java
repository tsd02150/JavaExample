package com.yedam.homework;

public class plusTest {
	public static void main(String[] args) {
		int value = 485;
		int result=0;
		int tmp1,tmp2,tmp3;
		
		tmp3=value%10;
		value/=10;
		
		tmp2=value%10;	
		value/=10;
		
		tmp1=value%10;	
		
		result=tmp1+tmp2+tmp3;
		
		System.out.println(tmp1+" + "+tmp2+" + "+tmp3+" = "+result+" 으로 결과는 "+result+"입니다.");
		
		int a=6,b=1;
		int r = a&b;
		System.out.println(r);
	}
}
