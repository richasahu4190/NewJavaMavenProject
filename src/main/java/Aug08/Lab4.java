package Aug08;

import java.io.*;
import java.util.*;

public class Lab4 {


	    public static void main(String[] args) {
	        String fileName = "src/main/java/Aug08/products.txt";

	      
	        List<String> products = new ArrayList<>();
	        products.add("Laptop");
	        products.add("Mobile");
	        products.add("Tablet");
	        products.add("Smartwatch");
	        products.add("Camera");

	        Collections.sort(products);

	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
	            for (String product : products) {
	                bw.write(product);
	                bw.newLine();
	            }
	            System.out.println("Products saved to text file.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            List<String> readProducts = new ArrayList<>();
	            while ((line = br.readLine()) != null) {
	                readProducts.add(line);
	            }

	            System.out.println("Products from file:");
	            for (String p : readProducts) {
	                System.out.println(p);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


