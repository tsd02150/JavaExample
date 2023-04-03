package Question1;

public class RPGgame implements Keypad{
	public int mode;
	public RPGgame() {
		this.mode = Keypad.NORMAL_MODE;
		System.out.println("RPGgame 실행");
	}
	
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다");
	}

	@Override
	public void rightUpButton() {
		if(this.mode==Keypad.NORMAL_MODE) {
			System.out.println("캐릭터가 한칸단위로 점프한다");
		}else if(this.mode == Keypad.HARD_MODE) {
			System.out.println("캐릭터가 두칸단위로 점프한다.");
		}
	}

	@Override
	public void rightDownButton() {
		if(this.mode==Keypad.NORMAL_MODE) {
			System.out.println("캐릭터가 일반공격");
		}else if(this.mode == Keypad.HARD_MODE) {
			System.out.println("캐릭터가 HIT 공격.");
		}	
	}

	@Override
	public void changeMode() {
		if(this.mode==Keypad.NORMAL_MODE) {
			this.mode = Keypad.HARD_MODE;
			System.out.println("현재 모드 : HARD_MODE");
		}else if(this.mode == Keypad.HARD_MODE) {
			this.mode = Keypad.NORMAL_MODE;
			System.out.println("현재 모드 : NORMAR_MODE");
		}
	}
	
}
