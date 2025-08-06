package Aug05.com.cg.eis.pl;

import Aug05.com.cg.eis.bean.Employee;
import Aug05.com.cg.eis.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public String assignInsuranceScheme(Employee emp) {
        double salary = emp.getSalary();
        String designation = emp.getDesignation();

        if (salary >= 50000 && designation.equalsIgnoreCase("Manager")) {
            emp.setInsuranceScheme("Scheme A");
        } else if (salary >= 20000 && salary < 50000 && designation.equalsIgnoreCase("Programmer")) {
            emp.setInsuranceScheme("Scheme B");
        } else if (salary >= 5000 && salary < 20000 && designation.equalsIgnoreCase("Clerk")) {
            emp.setInsuranceScheme("Scheme C");
        } else {
            emp.setInsuranceScheme("No Scheme");
        }

        return emp.getInsuranceScheme();
    }

    @Override
    public void displayEmployeeDetails(Employee emp) {
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Salary: " + emp.getSalary());
        System.out.println("Designation: " + emp.getDesignation());
        System.out.println("Insurance Scheme: " + emp.getInsuranceScheme());
    }
}
