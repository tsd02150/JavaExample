package com.yedam.array;

import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] ary;
		int no;
		
		System.out.println("배열의 크기 > ");
		no = sc.nextInt();
		sc.nextLine();
		ary = new int[no];
		
		//배열에 데이터 입력
		for(int i=0;i<ary.length;i++) {
			System.out.println("데이터 입력 > ");
			ary[i] = Integer.parseInt(sc.nextLine());
		}
		
		int max = ary[0];
		for(int i=1;i<ary.length;i++) {
			if(max<ary[i]) {
				max=ary[i];
			}
		}
		System.out.println("최대값 : " + max);
		
		int min = ary[0];
		for(int i=1;i<ary.length;i++) {
			if(min>ary[i]) {
				min=ary[i];
			}
		}
		System.out.println("최소값 : " + min);
		
		
	}
}
