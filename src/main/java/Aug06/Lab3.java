package Aug06;

import Aug06.com.cg.eis.EmployeeException;
import Aug06.com.cg.eis.Employee;

public class Lab3 {
	    public static void main(String[] args) {
	        try {
	            
	            Employee emp1 = new Employee("Richa", 5000);
	            emp1.display();
	            
	            Employee emp2 = new Employee("John", 2000); 
	            emp2.display();

	        } catch (EmployeeException e) {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
}
	



