/*
 * Author:  Patrick Gonzalez
 * Date:    April 12, 2026
 * Purpose: Derived class that extends Employee (inheritance).
 *          Represents a commission-based employee and adds base salary,
 *          commission rate, and total sales to the base employee data.
 */

// Inheritance: CommissionEmployee extends the Employee base class
public class CommissionEmployee extends Employee {

    private double baseSalary;
    private double commissionRate;
    private double salesAmount;

    /*
     * Constructor for CommissionEmployee.
     * Calls the parent constructor via super() to initialize shared fields.
     */
    public CommissionEmployee(int employeeId, String firstName, String lastName,
                              String email, Department department,
                              double baseSalary, double commissionRate, double salesAmount) {
        super(employeeId, firstName, lastName, email, department);
        this.baseSalary      = baseSalary;
        this.commissionRate  = commissionRate;
        this.salesAmount     = salesAmount;
    }

    /*
     * Overrides the base class displayInfo() to include commission-specific details.
     */
    @Override
    public void displayInfo() {
        System.out.println("  [ Commission Employee ]");
        super.displayInfo(); // calls base class method
        System.out.printf ("  Base Salary     : $%,.2f%n", baseSalary);
        System.out.printf ("  Commission Rate : %.0f%%%n", commissionRate * 100);
        System.out.printf ("  Total Sales     : $%,.2f%n", salesAmount);
        System.out.printf ("  Total Pay       : $%,.2f%n", baseSalary + (commissionRate * salesAmount));
    }

    public double getBaseSalary()     { return baseSalary; }
    public double getCommissionRate() { return commissionRate; }
    public double getSalesAmount()    { return salesAmount; }
    public void   setBaseSalary(double baseSalary)         { this.baseSalary = baseSalary; }
    public void   setCommissionRate(double commissionRate) { this.commissionRate = commissionRate; }
    public void   setSalesAmount(double salesAmount)       { this.salesAmount = salesAmount; }
}
