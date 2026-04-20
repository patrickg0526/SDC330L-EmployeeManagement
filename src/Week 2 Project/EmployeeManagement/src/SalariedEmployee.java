/*
 * Author:  Patrick Gonzalez
 * Date:    April 19, 2026
 * Purpose: Derived class that extends Employee (inheritance).
 *          Represents a full-time salaried employee and adds
 *          annual salary information to the base employee data.
 *          Also provides its own implementation of the Payable
 *          interface methods, which is part of the polymorphism
 *          demonstration for Week 2.
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
        super.displayInfo();
        System.out.printf ("  Annual Salary: $%,.2f%n", annualSalary);
    }

    // Polymorphism: overridden interface method supplies the salaried
    // version of the pay calculation. Weekly pay from an annual salary.
    @Override
    public double calculatePay() {
        return annualSalary / 52.0;
    }

    // Polymorphism: overridden interface method returns the label
    // used in the payroll report for this pay type.
    @Override
    public String getPayType() {
        return "Salaried (weekly from annual)";
    }

    public double getAnnualSalary() { return annualSalary; }
    public void   setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }
}
