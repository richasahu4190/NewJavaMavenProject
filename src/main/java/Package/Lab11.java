package Package;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class Lab11 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter date (yyyy-mm-dd): ");
	        String input = sc.nextLine();

	        LocalDate enteredDate = LocalDate.parse(input);
	        LocalDate currentDate = LocalDate.now();

	        Period duration = Period.between(enteredDate, currentDate);

	        System.out.println("Duration from entered date to current date:");
	        System.out.println(duration.getYears() + " years");
	        System.out.println(duration.getMonths() + " months");
	        System.out.println(duration.getDays() + " days");
	    }
	}



