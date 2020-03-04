package com.mj;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(11);
		linkedList.add(22);
		linkedList.add(33);
		linkedList.remove(1);
		linkedList.add(0, 55);
		linkedList.add(44);
		System.out.println(linkedList);
	}

}
