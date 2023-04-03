package Question1;

public class Question1 {
	public static void main(String[] args) {
		RPGgame rpg = new RPGgame();
		rpg.leftUpButton();
		rpg.rightUpButton();
		rpg.changeMode();
		rpg.rightUpButton();
		rpg.rightDownButton();
		rpg.leftDownButton();
		rpg.changeMode();
		rpg.rightDownButton();
		System.out.println("====================");
		ArcadeGame arc = new ArcadeGame();
		arc.leftUpButton();
		arc.rightUpButton();
		arc.leftDownButton();
		arc.changeMode();
		arc.rightUpButton();
		arc.leftUpButton();
		arc.rightDownButton();
	}
}
