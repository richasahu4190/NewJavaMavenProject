package Package;
 import java.util.Scanner;
 
public class Lab10 {

	    public static boolean isPositive(String str) {
	        str = str.toUpperCase();

	        for (int i = 0; i < str.length() - 1; i++) {
	            if (str.charAt(i) >= str.charAt(i + 1)) {
	                return false;
	            }
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();

	        if (isPositive(input)) {
	            System.out.println(input + " is a positive string.");
	        } else {
	            System.out.println(input + " is NOT a positive string.");
	        }

	        scanner.close();
	    }
	}


