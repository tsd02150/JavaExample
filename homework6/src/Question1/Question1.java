package Question1;

public class Question1 {
	public static void main(String[] args) {
		Keypad game = new RPGgame();
		game.leftUpButton();
		game.rightUpButton();
		game.changeMode();
		game.rightUpButton();
		game.rightDownButton();
		game.leftDownButton();
		game.changeMode();
		game.rightDownButton();
		System.out.println("====================");
		game = new ArcadeGame();
		game.leftUpButton();
		game.rightUpButton();
		game.leftDownButton();
		game.changeMode();
		game.rightUpButton();
		game.leftUpButton();
		game.rightDownButton();
	}
}
