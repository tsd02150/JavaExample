package homework7;

import java.util.Scanner;

public class StringGame {
	public static final String[] randomWords = {"Orange","Game","Phone","Smart"};
	public String word;
	public String check;
	Scanner sc = new Scanner(System.in);

	public StringGame() {
		int random = (int)(Math.random()*4);
		this.word = randomWords[random].toLowerCase();
		this.check = "";
	}
	
	private void checking() {
		System.out.println("현재까지 확인된 문자열의 문자들은 다음과 같습니다.");
		for(int i=0;i<check.length();i++) {
			System.out.print(check.charAt(i));
		}
		System.out.println();
	}
	
	public void setCharData() {	
		checking();
		if(check.length()==word.length()*2) {
			System.out.println("문자열을 구성하는 문자를 다 입력하셨습니다.");
			return;
		}
		
		String data;
		System.out.print("입력값 > ");
		data = sc.nextLine();
		
		if(check.indexOf(data)>=0) {
			System.out.println("이미 찾은 문자 입니다.");
			return;
		}
		
		if(word.indexOf(data)>=0) {
			System.out.println("문자열을 구성하는 문자입니다.");
			check=check+data+" ";			
		}else {
			System.out.println("문자열을 구성하는 문자가 아닙니다.");			
		}
	}
	public void setStrData() {
		checking();
		
		String data;
		System.out.print("입력값 > ");
		data = sc.nextLine();
		if(data.length()>word.length()) {
			System.out.println("입력된 문자열의 길이가 정답과 다릅니다.");
			return;
		}
		if(data.equals(word)) {
			System.out.println("정답입니다.");
			return;
		}
		for(int i=0;i<data.length();i++) {
			if(data.charAt(i)==word.charAt(i)) {
				System.out.print("O");
			}else {
				System.out.print("X");
			}
			System.out.print(" ");
		}
		System.out.println();
	}
	public void showCharData() {
		checking();
	}
	public void init() {
		int random = (int)(Math.random()*4);
		this.word = randomWords[random].toLowerCase();
		this.check = "";
	}
}