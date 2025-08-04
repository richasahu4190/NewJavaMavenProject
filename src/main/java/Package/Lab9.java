package Package;
import java.util.Scanner;

public class Lab9 {
	 public static String operate(String str, int choice) {
	        String result = "";

	        switch (choice) {
	            case 1:
	                result = str + str;
	                break;

	            case 2:
	                for (int i = 0; i < str.length(); i++) {
	                    if (i % 2 == 0) {
	                        result += str.charAt(i);
	                    } else {
	                        result += "#";
	                    }
	                }
	                break;

	            case 3:
	                for (int i = 0; i < str.length(); i++) {
	                    char ch = str.charAt(i);
	                    if (result.indexOf(ch) == -1) {
	                        result += ch;
	                    }
	                }
	                break;

	            case 4:
	                for (int i = 0; i < str.length(); i++) {
	                    char ch = str.charAt(i);
	                    if (i % 2 == 0) {
	                        result += Character.toUpperCase(ch);
	                    } else {
	                        result += ch;
	                    }
	                }
	                break;

	            default:
	                result = "Invalid choice!";
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String input = sc.nextLine();
	        
	        System.out.print("Enter your choice: ");
	        int choice = sc.nextInt();

	        String result = operate(input, choice);
	        System.out.println("Result: " + result);
	    }
	}


