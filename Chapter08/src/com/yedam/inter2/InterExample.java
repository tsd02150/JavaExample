package com.yedam.inter2;

public class InterExample {
	public static void main(String[] args) {
		InterfaceC ic = new ImplementsC();
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		InterfaceA ia = new ImplementsC();
		ia.methodA();
		InterfaceB ib = new ImplementsC();
		ib.methodB();
	}
}
