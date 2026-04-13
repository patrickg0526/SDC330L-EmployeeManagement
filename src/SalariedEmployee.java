/*
 * Author:  Patrick Gonzalez
 * Date:    April 12, 2026
 * Purpose: Derived class that extends Employee (inheritance).
 *          Represents a full-time salaried employee and adds
 *          annual salary information to the base employee data.
 */

// Inheritance: SalariedEmployee extends the Employee base class
public class SalariedEmployee extends Employee {

    private double annualSalary;

    /*
     * Constructor for SalariedEmployee.
     * Calls the parent constructor via super() to initialize shared fields.
     */
    public SalariedEmployee(int employeeId, String firstName, String lastName,
                            String email, Department department, double annualSalary) {
        super(employeeId, firstName, lastName, email, department);
        this.annualSalary = annualSalary;
    }

    /*
     * Overrides the base class displayInfo() to include salaried-specific details.
     */
    @Override
    public void displayInfo() {
        System.out.println("  [ Salaried Employee ]");
        super.displayInfo(); // calls base class method
        System.out.printf ("  Annual Salary: $%,.2f%n", annualSalary);
    }

    public double getAnnualSalary() { return annualSalary; }
    public void   setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }
}
