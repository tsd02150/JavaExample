package com.yedam.array;

public class Exam05 {
	public static void main(String[] args) {
		//최대값의 인덱스 구하기
		int[] array = {10,50,70,20,30,80,40};
		int index=0,max=array[0];
		for(int i=1;i<array.length;i++) {
			if(max<array[i]) {
				index=i;
				max=array[i];
			}
		}
		System.out.println(index+"번째 위치의 최대값 : "+max);
		
		
	}
}
