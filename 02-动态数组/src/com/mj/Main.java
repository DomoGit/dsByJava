package com.mj;

public class Main {

	public static void main(String[] args) {
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(12, "Jack"));
		persons.add(new Person(15, "Tom"));
		persons.add(new Person(16, "Lili"));
		
		System.out.println(persons);
		
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(10);
		ints.add(11);
		ints.add(12);
		ints.add(20);
		System.out.println(ints);
	}

}
