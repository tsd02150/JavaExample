package com.yedam.array;

public class Exam09 {
	public static void main(String[] args) {
		int[][] intAry = { { 1, 2 }, { 1, 2, 3 } };

		int[][] mathScore = new int[2][3];
		
		
		for(int i=0;i<mathScore.length;i++) {
//			System.out.println("mathScore의 길이 : "+mathScore.length);
			for(int j=0;j<mathScore[i].length;j++) {
				System.out.print("mathScore["+i+"]["+j+"]");
			}
			System.out.println();
		}
	}
}
