package Aug02;
import java.util.Scanner;

public class Lab7 {
	

	    private String firstName;
	    private String lastName;
	    private char gender;
	    private String phoneNumber; 
        
	    public Lab7() {
	      
	    }

	   
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public char getGender() {
	        return gender;
	    }
	    public void setGender(char gender) {
	        this.gender = gender;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }
	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public void acceptPhoneNumber() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter Phone Number: ");
	        phoneNumber = scanner.nextLine();
	    }

	    public void displayDetails() {
	        System.out.println("First Name: " + firstName);
	        System.out.println("Last Name: " + lastName);
	        System.out.println("Gender: " + gender);
	        System.out.println("Phone Number: " + phoneNumber);
	    }
	}


