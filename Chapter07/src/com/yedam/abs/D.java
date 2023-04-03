package com.yedam.abs;
//com.yedam.protect 실험용

import com.yedam.protect.A;

public class D extends A{
	public D() {
		super();
		super.field = "부모 필드 접근";
		super.method();
	}
}
