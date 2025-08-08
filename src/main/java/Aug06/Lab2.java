package Aug06;

import java.util.Scanner;

	class InvalidAgeException extends Exception {
	    public InvalidAgeException(String message) {
	        super(message);
	    }
	}

	
	class Person {
	    String name;
	    int age;

	    Person(String name, int age) throws InvalidAgeException {
	        if (age <= 15) {
	            throw new InvalidAgeException("Age must be above 15.");
	        }
	        this.name = name;
	        this.age = age;
	    }

	    void display() {
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	    }
	}

	public class Lab2 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter age: ");
	        int age = sc.nextInt();

	        try {
	            Person p = new Person(name, age);
	            p.display();
	        } catch (InvalidAgeException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}


