package Aug06.com.cg.eis;


	public class Employee {
	    private String name;
	    private double salary;

	    public Employee(String name, double salary) throws EmployeeException {
	        if (salary < 3000) {
	            throw new EmployeeException("Salary cannot be less than 3000.");
	        }
	        this.name = name;
	        this.salary = salary;
	    }

	    public void display() {
	        System.out.println("Employee Name: " + name);
	        System.out.println("Salary: " + salary);
	    }
	}



