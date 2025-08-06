package Aug04;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Lab15{

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        String dobInput = sc.nextLine();
        LocalDate dob = LocalDate.parse(dobInput);

        String fullName = getFullName(firstName, lastName);
        int age = calculateAge(dob);

        System.out.println("\nPerson Details");
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age + " years");
    }

    public static int calculateAge(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);
        return period.getYears();
    }

    public static String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
