package Package;
import java.util.Scanner;

public class Lab5 {
	
	    public static void main(String[] args) {
	   
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a number: ");
	     
	        int num = scanner.nextInt();

	        if (num > 0) {
	            System.out.println("The no is positive.");
	        } else if (num < 0) {
	            System.out.println("The no is negative.");
	        } else {
	            System.out.println("The n0 is zero.");
	        }

	        scanner.close();
	    }
	}



