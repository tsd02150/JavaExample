package com.yedam.exception;

import java.sql.SQLException;

public class Application {
	public static void main(String[] args) {
//		try {
//			// 예외가 발생할 것 같은 실행코드
//			
//		}catch(예외) {
//			// 예외가 발생 후 처리하는 코드
//		}finally {
//			// 옵션
//			// try문 또는 catch문 실행하고나서
//			// 무조건 실행해야 하는 코드
//		}

		String data1 = null;
		String data2 = null;
		try {
//			data1 = args[0];
//			data2 = args[1];

//			double avg = 1/0;

//			String str = "자바";
//			int a = Integer.parseInt(str);

			Class clazz = Class.forName("java.lang.String2");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (NumberFormatException e) {
			System.out.println("문자열 변환 에러");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		} catch (Exception e) {
			System.out.println("위에서 처리 못하면 내가 처리한다.");
		} finally {
			System.out.println("finally 항상 실행");
		}
	}
}
