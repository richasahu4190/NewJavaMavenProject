package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void assignInsuranceScheme(Employee e) {
        double salary = e.getSalary();
        String designation = e.getDesignation();

        if (salary >= 50000 && designation.equalsIgnoreCase("Manager")) {
            e.setInsuranceScheme("Scheme A");
        } else if (salary >= 20000 && salary < 50000 && designation.equalsIgnoreCase("Programmer")) {
            e.setInsuranceScheme("Scheme B");
        } else if (salary >= 5000 && salary < 20000 && designation.equalsIgnoreCase("Clerk")) {
            e.setInsuranceScheme("Scheme C");
        } else {
            e.setInsuranceScheme("No Scheme");
        }
    }

    @Override
    public void displayEmployeeDetails(Employee e) {
        System.out.println("\nEmployee Details");
        System.out.println("ID: " + e.getId());
        System.out.println("Name: " + e.getName());
        System.out.println("Salary: " + e.getSalary());
        System.out.println("Designation: " + e.getDesignation());
        System.out.println("Insurance Scheme: " + e.getInsuranceScheme());
    }
}
