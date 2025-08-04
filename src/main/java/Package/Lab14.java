package Package;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class Lab14 {
	
	public static void main(String[] args) {
      
        String[] zones = {
            "America/New_York",
            "Europe/London",
            "Asia/Tokyo",
            "US/Pacific",
            "Africa/Cairo",
            "Australia/Sydney"
        };

        System.out.println("Select a time zone:");
        for (int i = 0; i < zones.length; i++) {
            System.out.println((i + 1) + ". " + zones[i]);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice (1-" + zones.length + "): ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= zones.length) {
            String selectedZone = zones[choice - 1];
            ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(selectedZone));
            System.out.println("Current date and time in " + selectedZone + ": " + dateTime);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}