package com.yedam.homework;

public class EmpDept extends Employee{
	public String deptName;
	
	public EmpDept(String name,int salary,String deptName) {
		super(name,salary);
		this.deptName=deptName;
	}

	public String getDeptName() {
		return deptName;
	}
	
	@Override
	public void getInformation() {
		System.out.println("이름 : "+ getName()+" 연봉 : "+getSalary()+" 부서 : "+getDeptName());
	}
	@Override
	public void print(){
		System.out.println("수퍼클래스\n서브클래스");
	}
	
}
