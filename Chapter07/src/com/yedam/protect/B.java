package com.yedam.protect;

public class B {
	public void method() {
		A a = new A();
		a.field = "접근 가능";
		a.method();
	}
}
