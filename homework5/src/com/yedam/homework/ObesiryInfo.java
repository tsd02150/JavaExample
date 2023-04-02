package com.yedam.homework;

public class ObesiryInfo extends StandardWeightInfo{
	public ObesiryInfo() {
		
	}
	
	public ObesiryInfo(String name, double height,double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public void getInformation() {
		if(getObesity()<=18.5) {
			System.out.println("이름 : "+name+" 키 : "+height+" 몸무게 : "+weight+" 저체중입니다");
		}else if(getObesity()>18.5&&getObesity()<=22.9) {
			System.out.println("이름 : "+name+" 키 : "+height+" 몸무게 : "+weight+" 정상체중입니다");
		}else if (getObesity()>22.9&&getObesity()<=24.9){
			System.out.println("이름 : "+name+" 키 : "+height+" 몸무게 : "+weight+" 과체중입니다");
		}else {
			System.out.println("이름 : "+name+" 키 : "+height+" 몸무게 : "+weight+" 비만입니다");
		}
		
	}
	public double getObesity() {
		double obsity = (weight-getStandardWeight())/getStandardWeight()*100;
		return obsity;
	}
}
