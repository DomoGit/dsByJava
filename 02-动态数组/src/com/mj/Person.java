package com.mj;

public class Person {
	private int age;
	private String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	// 这个方法相当于这个对象在死之前的遗言，最后可以做的事情
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		
		System.out.println(this.toString() + ": finalize");
	}
}
