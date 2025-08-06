package Aug04;

import java.util.Scanner;
import java.time.LocalDate;

public class Lab13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the purchase date (yyyy-mm-dd): ");
		String input = sc.nextLine();
		LocalDate purchaseDate = LocalDate.parse(input);
		
		System.out.print("Enter warranty period in years: ");
		int warrantyYears = sc.nextInt();
		
		System.out.print("Enter warranty period in months: ");
		int warrantyMonths =  sc.nextInt();
		
		
		LocalDate expiry = calculate(purchaseDate, warrantyYears, warrantyMonths);
		
		System.out.print("Warranty expires on :" + expiry);
	}
		public static LocalDate calculate(LocalDate purchaseDate , int years, int months) {
			return purchaseDate.plusYears(years).plusMonths(months);
		}

	}


