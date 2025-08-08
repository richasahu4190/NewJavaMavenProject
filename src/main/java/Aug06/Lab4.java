package Aug06;

import java.util.Arrays;

public class Lab4 {
	
	    public static void main(String[] args) {
	     
	        String[] products = {"Laptop", "Mobile", "Tablet", "Earphones", "Charger"};

	        System.out.println("Before Sorting:");
	        for (String product : products) {
	            System.out.println(product);
	        }
	        
	        Arrays.sort(products);

	        System.out.println("\nAfter Sorting:");
	        for (String product : products) {
	            System.out.println(product);
	        }
	    }
	}



