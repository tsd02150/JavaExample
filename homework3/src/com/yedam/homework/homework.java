package com.yedam.homework;

import java.util.Scanner;

public class homework {
	public static void main(String[] args) {
		//주어진 배열을 이용하여 다음 내용을 구현하세요.
		int[] arr1 = { 10, 20, 30, 50, 3, 60, -3 };
		
		//문제1. 주어진 배열 중에서 값이 60인 곳의 인덱스를 출력해보자.
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]==60) {
				System.out.println("값 60인 곳의 인덱스 : " + i);
			}
		}
		System.out.println();
		
		//문제2. 주어진 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력해보자.
		for(int i:arr1) {
			if(i != 3) {
				System.out.print(i+"\t");
			}
		}
		System.out.println();
		System.out.println();
		
		//문제3. 주어진 배열 안의 변경하고 싶은 값의 인덱스 번호를 입력받아, 그 값을 1000으로 변경해보자.
  		//   입력) 인덱스: 3 ->   {10, 20, 30, 1000, 3, 60, -3}
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 ) 인덱스 : ");
		int changeIndex = sc.nextInt();
		arr1[changeIndex] = 1000;
		System.out.print("-> {");
		for(int i=0;i< arr1.length;i++) {
			System.out.print(arr1[i]);
			if(i==(arr1.length-1)) {
				continue;
			}
			System.out.print(",");
		}
		System.out.println("}");
		System.out.println();
		
		//문제4. 주어진 배열의 요소에서 최대값과 최소값을 구해보자.
		int max,min;
		max=min=arr1[0];
		for(int i:arr1) {
			if(i>max) {
				max=i;
			}
			if(i<min) {
				min=i;
			}
		}
		System.out.println("최대값 : "+max+" 최소값 : "+min);
		System.out.println();
		
		//문제5. 별도의 배열을 선언하여 양의 정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력해보자.
		int[] testArr = new int[10];
		System.out.println("양의 정수 10개 입력 > ");
		for(int i=0;i<testArr.length;i++) {
			testArr[i]=sc.nextInt();
		}
		for(int i=0;i<testArr.length;i++) {
			if(testArr[i]%3==0) {
				System.out.print(testArr[i]+"\t");
			}
		}
		System.out.println();
		System.out.println();
		
		//문제6.
		//아래의 내용을 확인하요 채워 넣으세요.
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] copyArray = new int[3];
		for (int i = 0; i < array.length; i++) {
			int j = (int) (Math.random() * array.length);
			int tmp = 0;
			tmp = array[i];
			array[i]=array[j];
			array[j]=tmp;
		}
		for(int i:array) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.arraycopy(array, 0, copyArray, 0, 3);
		for (int i = 0; i < copyArray.length; i++) {
			System.out.print(copyArray[i]+"\t");
		}
		System.out.println();
		System.out.println();
		
		
		//문제7.
		//알파벳 'A'-'Z'까지 반복문을 활용하여 배열에 입력하고, 하나의 문자를 입력 받아
		//그 문자가 어느위치에 있는지 출력하시오.
		char[] alpa = new char[26];
		for(int i=0;i<alpa.length;i++) {
			alpa[i]= (char)('A'+i);
		}
		System.out.println("문자를 입력 > ");
		String selec = sc.next();
		
		for(int i =0;i<alpa.length;i++) {
			if(selec.charAt(0)==alpa[i]) {
				System.out.println(selec + "은 "+(i+1)+"번재 위치에 있다.");
			}
		}
		
		
		
	}
}
