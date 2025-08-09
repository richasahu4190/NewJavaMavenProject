package Aug08;
import java.util.*;

	class Employees{
	    int id;
	    String name;
	    double salary;
	    String insuranceScheme;

	    Employees(int id, String name, double salary, String insuranceScheme) {
	        this.id = id;
	        this.name = name;
	        this.salary = salary;
	        this.insuranceScheme = insuranceScheme;
	    }

	    public String toString() {
	        return id + " - " + name + " - " + salary + " - " + insuranceScheme;
	    }
	}

	public class Lab5 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        Map<Integer, Employees> empMap = new HashMap<>();
	        empMap.put(101, new Employees(101, "Alice", 50000, "Gold"));
	        empMap.put(102, new Employees(102, "Bob", 60000, "Silver"));
	        empMap.put(103, new Employees(103, "Charlie", 80000, "Gold"));

	        System.out.print("Enter Insurance Scheme to search: ");
	        String scheme = sc.nextLine();
	        for (Employees e : empMap.values()) {
	            if (e.insuranceScheme.equalsIgnoreCase(scheme)) {
	                System.out.println(e);
	            }
	        }

	        System.out.print("Enter Employee ID to delete: ");
	        int delId = sc.nextInt();
	        empMap.remove(delId);

	        System.out.println("Remaining Employees:");
	        for (Employees e : empMap.values()) {
	            System.out.println(e);
	        }

	        sc.close();
	    }
	}


