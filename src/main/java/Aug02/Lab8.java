package Aug02;

import java.util.Scanner;

public class Lab8 {
	    String firstName;
	    String lastName;
	    Gender gender;
	    String phoneNumber;

	    void acceptDetails() {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter First Name: ");
	        firstName = sc.nextLine();

	        System.out.print("Enter Last Name: ");
	        lastName = sc.nextLine();

	        System.out.print("Enter Phone Number: ");
	        phoneNumber = sc.nextLine();

	        System.out.print("Enter Gender (M/F): ");
	        String inputGender = sc.nextLine().toUpperCase();

	        if (inputGender.equals("M")) {
	            gender = Gender.M;
	        } else if (inputGender.equals("F")) {
	            gender = Gender.F;
	        } else {
	            System.out.println("Invalid gender!.");
	       
	        }

	        sc.close();
	    }

	    void displayDetails() {
	        System.out.println("\nPerson Details");
	        System.out.println("First Name : " + firstName);
	        System.out.println("Last Name  : " + lastName);
	        System.out.println("Phone No   : " + phoneNumber);
	        System.out.println("Gender     : " + gender);
	    }
	}

