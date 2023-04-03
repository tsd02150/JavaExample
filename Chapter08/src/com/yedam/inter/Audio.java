package com.yedam.inter;

public class Audio implements RemoteControl{
	//Audio volume 측정하기 위한 변수
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		}else {
			// volume : 0 <= volume <= 10
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨 : "+this.volume);
	}
		
}
