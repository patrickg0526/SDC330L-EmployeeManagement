/*
 * Author:  Patrick Gonzalez
 * Date:    April 12, 2026
 * Purpose: Entry point for the Employee Management application - Week 1 Demo.
 *          Demonstrates inheritance using a base Employee class and three
 *          derived types: SalariedEmployee, HourlyEmployee, and CommissionEmployee.
 *          Demonstrates composition through the Department object held within Employee.
 *          Instantiates sample employees with realistic data and displays their info.
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Project header
        System.out.println("=======================================================");
        System.out.println("  Project Week 1 - Employee Management System");
        System.out.println("  SDC330L: Advanced Object-Oriented Programming");
        System.out.println("  Patrick Gonzalez");
        System.out.println("=======================================================");

        // Welcome message and instructions
        System.out.println();
        System.out.println("  Welcome to the Employee Management System!");
        System.out.println();
        System.out.println("  This application manages employee records across");
        System.out.println("  three employee types: Salaried, Hourly, and Commission.");
        System.out.println();
        System.out.println("  Week 1 Demo: Inheritance and Composition");
        System.out.println("  ----------------------------------------");
        System.out.println("  The Employee base class demonstrates composition");
        System.out.println("  by containing a Department object. Derived classes");
        System.out.println("  (SalariedEmployee, HourlyEmployee, CommissionEmployee)");
        System.out.println("  demonstrate inheritance by extending Employee.");
        System.out.println();
        System.out.println("  In future releases, you will be able to add, remove,");
        System.out.println("  update, and search employee records from a menu.");
        System.out.println("=======================================================");

        // Create Department objects - composition is shown here (used inside Employee)
        Department itDept    = new Department("Information Technology", "Building A", "Sarah Johnson");
        Department salesDept = new Department("Sales",                  "Building B", "Mark Williams");
        Department hrDept    = new Department("Human Resources",        "Building C", "Lisa Chen");

        // Instantiate derived classes - inheritance demonstrated here
        SalariedEmployee    emp1 = new SalariedEmployee(
                1001, "James", "Carter", "jcarter@company.com", itDept, 85000.00);

        HourlyEmployee      emp2 = new HourlyEmployee(
                1002, "Maria", "Lopez",  "mlopez@company.com",  salesDept, 22.50, 40.0);

        CommissionEmployee  emp3 = new CommissionEmployee(
                1003, "David", "Thompson", "dthompson@company.com", hrDept, 40000.00, 0.08, 75000.00);

        // Store all employees in a list using the base class type (polymorphism-ready)
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        // Display all employees
        System.out.println();
        System.out.println("  Displaying All Employees:");
        System.out.println();

        for (Employee emp : employees) {
            System.out.println("  -----------------------------------------------------");
            emp.displayInfo();
            System.out.println("  -----------------------------------------------------");
            System.out.println();
        }

        System.out.println("=======================================================");
        System.out.println("  End of Week 1 Demo. More features coming in Week 2!");
        System.out.println("=======================================================");
    }
}
