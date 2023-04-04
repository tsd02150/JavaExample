package homework7;

import java.util.Scanner;

public class StringGame {
	public static final String[] words = {"Orange","Game","Phone","Smart"};
	public String word;
	public String check;
	public StringGame() {
		int random = (int)Math.random()*4;
		this.word = words[random];
		this.check = null;
	}
	Scanner sc = new Scanner(System.in);
	public void setCharData() {
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		for(int i=0;i<check.length();i++) {
			System.out.print(check.charAt(i));
		}
		System.out.println();
		
		byte data;
		System.out.print("입력값 > ");
		data = sc.nextByte();
		
		byte[] result = this.word.getBytes();
		for(byte tmp : result) {
			if(data==tmp) {
				System.out.println("문자열을 구성하는 문자입니다.");
				check=check+data+" ";
			}else {
				System.out.println("문자열을 구성하는 문자가 아닙니다.");
			}
		}
	}
	public void setStrData() {
		
	}
	public void showCharData() {
		
	}
	public void init() {
		
	}
}
