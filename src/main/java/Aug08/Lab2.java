package Aug08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab2 {


	    public static void main(String[] args) {
	        String fileName = "src/main/java/Aug08/numbers.txt";

	        try (FileWriter writer = new FileWriter(fileName)) {
	            for (int i = 0; i <= 10; i++) {
	                writer.write(i + (i < 10 ? "," : "")); 
	            }
	            System.out.println("File created successfully: " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	            return;
	        }
	        try (Scanner scanner = new Scanner(new File(fileName))) {
	            scanner.useDelimiter(","); 

	            System.out.println("Even numbers from file:");
	            while (scanner.hasNext()) {
	                int number = Integer.parseInt(scanner.next().trim());
	                if (number % 2 == 0) {
	                    System.out.println(number);
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error reading from file: " + e.getMessage());
	        }
	    }
	}



