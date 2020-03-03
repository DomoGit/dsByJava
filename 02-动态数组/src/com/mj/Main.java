package com.mj;

public class Main {

	public static void main(String[] args) {
		ArrayList array = new ArrayList();
		array.add(99);
		array.add(88);
		array.add(77);
		System.out.println(array);
		
		array.remove(1);
		System.out.println(array);
		
		array.add(1, 0);
		array.add(1, 1);
		array.add(1, 2);
		array.add(0, 3);
		System.out.println(array);
		Assert.test(array.get(0) == 3);
		
		array.set(0, 0);
		System.out.println(array);
		
		for (int i = 0; i < 10; i++) {
			array.add(100*i);
		}
		System.out.println(array);
		
		array.clear();
		System.out.println(array);
	}

}
