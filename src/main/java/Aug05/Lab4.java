package Aug05;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import java.util.Scanner;

class EmployeeServiceImplement implements EmployeeService {

    @Override
    public String assignInsuranceScheme(Employee emp) {
        double salary = emp.getSalary();
        String designation = emp.getDesignation().toLowerCase();

        if (salary >= 50000 && designation.equals("manager")) {
            return "Scheme A";
        } else if (salary >= 20000 && salary < 50000 && designation.equals("programmer")) {
            return "Scheme B";
        } else if (salary >= 5000 && salary < 20000 && designation.equals("clerk")) {
            return "Scheme C";
        } else {
            return "No Scheme";
        }
    }

    @Override
    public void displayEmployeeDetails(Employee emp) {
        System.out.println("\nEmployee Details");
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: " + emp.getSalary());
        System.out.println("Designation: " + emp.getDesignation());
        System.out.println("Insurance Scheme: " + assignInsuranceScheme(emp));
    }
}

public class Lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();  

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();  

        System.out.print("Enter Employee Designation: ");
        String designation = sc.nextLine();

        Employee emp = new Employee(id, name, salary, designation);
        EmployeeService service = new EmployeeServiceImplement();

        service.assignInsuranceScheme(emp);
        service.displayEmployeeDetails(emp);

        sc.close();
    }
}
