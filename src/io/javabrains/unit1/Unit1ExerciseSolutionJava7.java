package io.javabrains.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.javabrains.common.Person;

public class Unit1ExerciseSolutionJava7 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		// Step 1: Sort list by last name
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		
		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		printAll(people);
		
		// Step 3: Create a method that prints all people that have last name beginning with C
		System.out.println("Printing all persons with last name beginning with C");
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});

		System.out.println("Printing all persons with first name beginning with C");
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("C");
			}
		});
		
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
			
		}
		
	}

	private static void printAll(List<Person> people) {
		for (Person p : people) {
			System.out.println(p);
		}
		
	}

}



interface Condition {
	boolean test(Person p);
}
