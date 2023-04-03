package Question3;

import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) {
		Keypad game;
		if(Math.random()>0.5) {
			game = new RPGgame();
		}else {
			game = new ArcadeGame();
		}
		
		Scanner sc = new Scanner(System.in);
		int choice ;

		while(true) {
			System.out.println("============================================================================================");
			System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
			System.out.println("============================================================================================");
			System.out.print("choice >> ");
			choice = Integer.parseInt(sc.nextLine());
			
			if(choice==1) {
				game.leftUpButton();
			}else if (choice == 2) {
				game.leftDownButton();
			}else if (choice == 3) {
				game.rightUpButton();
			}else if (choice == 4) {
				game.rightDownButton();
			}else if (choice == 5) {
				game.changeMode();
			}else if (choice == 0) {
				if(game.hashCode()==0) {
					game = new ArcadeGame();
				}else if(game.hashCode()==1) {
					game = new RPGgame();
				}
			}else if (choice == 9) {
				System.out.println("EXIT");
				break;
			}
		}
	}
}
