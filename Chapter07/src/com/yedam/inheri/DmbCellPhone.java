package com.yedam.inheri;

public class DmbCellPhone extends CellPhone {
	// 자식 클래스
	// 필드
	int channel;
	// 생성자
	public DmbCellPhone() {
		
	}
	public DmbCellPhone(int channel,String color,String model) {
		super(model,color);
		this.channel = channel;
	}
	// 메소드
	public void turnOnDmb() {
		System.out.println("채널 : "+channel+"번 DMB 방송 수신");
	}
	public void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}
