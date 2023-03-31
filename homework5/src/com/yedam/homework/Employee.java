package com.yedam.homework;

public class Employee {
	public String name;
	public int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}

	
	public void getInformation() {
		System.out.println("이름 : "+ getName()+" 연봉"+getSalary());
	}
	
	public void print(){
		System.out.println("수퍼클래스");
	}
}
