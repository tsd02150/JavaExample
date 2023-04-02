package com.yedam.homework;

public class StandardWeightInfo extends Human{

	public StandardWeightInfo() {
		
	}
	public StandardWeightInfo(String name, double height,double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public void getInformation() {
		System.out.println("이름 : "+name+" 키 : "+height+" 몸무게 : "+weight+" 표준체중 : "+getStandardWeight());
	}
	
	public double getStandardWeight() {
		double standardWeight = (height-100)*0.9;
		return standardWeight;
	}
}
