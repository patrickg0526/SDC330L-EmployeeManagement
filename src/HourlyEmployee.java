/*
 * Author:  Patrick Gonzalez
 * Date:    April 12, 2026
 * Purpose: Derived class that extends Employee (inheritance).
 *          Represents an hourly employee and adds hourly rate and
 *          hours worked to the base employee data.
 */

// Inheritance: HourlyEmployee extends the Employee base class
public class HourlyEmployee extends Employee {

    private double hourlyRate;
    private double hoursWorked;

    /*
     * Constructor for HourlyEmployee.
     * Calls the parent constructor via super() to initialize shared fields.
     */
    public HourlyEmployee(int employeeId, String firstName, String lastName,
                          String email, Department department,
                          double hourlyRate, double hoursWorked) {
        super(employeeId, firstName, lastName, email, department);
        this.hourlyRate   = hourlyRate;
        this.hoursWorked  = hoursWorked;
    }

    /*
     * Overrides the base class displayInfo() to include hourly-specific details.
     */
    @Override
    public void displayInfo() {
        System.out.println("  [ Hourly Employee ]");
        super.displayInfo(); // calls base class method
        System.out.printf ("  Hourly Rate  : $%.2f/hr%n", hourlyRate);
        System.out.printf ("  Hours Worked : %.1f hrs%n", hoursWorked);
        System.out.printf ("  Weekly Pay   : $%,.2f%n", hourlyRate * hoursWorked);
    }

    public double getHourlyRate()   { return hourlyRate; }
    public double getHoursWorked()  { return hoursWorked; }
    public void   setHourlyRate(double hourlyRate)   { this.hourlyRate = hourlyRate; }
    public void   setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
}
