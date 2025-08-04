package Package;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class Lab12 {
public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first date (yyyy-mm-dd): ");
	        String first = sc.nextLine();
	        LocalDate firstDate = LocalDate.parse(first);

	        System.out.print("Enter second date (yyyy-mm-dd): ");
	        String second = sc.nextLine();
	        LocalDate secondDate = LocalDate.parse(second);

	        Period duration = Period.between(firstDate, secondDate);

	        
	        System.out.println("Duration b/w the two dates:");
	        System.out.println(duration.getYears() + " years");
	        System.out.println(duration.getMonths() + " months");
	        System.out.println(duration.getDays() + " days");
	    }
	}


