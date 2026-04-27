/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Concrete employee type for hourly workers. Extends Employee
 *          and provides its own implementation of every abstract method
 *          inherited from the Person, Employee, and Payable layers.
 *          Updated for Week 3 to add multiple constructors and tighten
 *          access on the internal helper.
 */

// Inheritance: HourlyEmployee plugs into the Employee chain and gets
// the personal info from Person and the payroll contract from Payable.
public class HourlyEmployee extends Employee {

    // Access specifier: private. Both fields are internal to the
    // hourly logic, so nothing outside the class touches them directly.
    private double hourlyRate;
    private double hoursWorked;

    /*
     * No-arg constructor. Sets defaults so the record can be built up
     * field by field.
     */
    public HourlyEmployee() {
        super();
        this.hourlyRate  = 0.0;
        this.hoursWorked = 0.0;
    }

    /*
     * Convenience constructor that defaults hours worked to a standard
     * 40-hour week. Chains to the full constructor through this(...).
     */
    public HourlyEmployee(int employeeId, String firstName, String lastName,
                          String email, Department department, double hourlyRate) {
        this(employeeId, firstName, lastName, email, department, hourlyRate, 40.0);
    }

    /*
     * Full constructor. Hands the personal/work data up to the Employee
     * constructor through super(...) and sets the hourly fields here.
     */
    public HourlyEmployee(int employeeId, String firstName, String lastName,
                          String email, Department department,
                          double hourlyRate, double hoursWorked) {
        super(employeeId, firstName, lastName, email, department);
        this.hourlyRate  = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    /*
     * Copy constructor. Pushes the source up to the Employee copy
     * constructor and then duplicates the hourly fields.
     */
    public HourlyEmployee(HourlyEmployee other) {
        super(other);
        this.hourlyRate  = other.hourlyRate;
        this.hoursWorked = other.hoursWorked;
    }

    /*
     * Overrides displayInfo() to add hourly-specific lines after the
     * shared employee block.
     */
    @Override
    public void displayInfo() {
        System.out.println("  [ Hourly Employee ]");
        super.displayInfo();
        System.out.printf ("  Hourly Rate  : $%.2f/hr%n", hourlyRate);
        System.out.printf ("  Hours Worked : %.1f hrs%n", hoursWorked);
        System.out.printf ("  Weekly Pay   : $%,.2f%n",   weeklyPay());
    }

    // Access specifier choice: this helper is private because it is
    // only used by the methods inside this class. Hiding it keeps the
    // public surface area of HourlyEmployee small and on-purpose.
    private double weeklyPay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculatePay() {
        return weeklyPay();
    }

    @Override
    public String getPayType() {
        return "Hourly (rate x hours)";
    }

    @Override
    public String getRole() {
        return "Hourly Employee";
    }

    public double getHourlyRate()  { return hourlyRate;  }
    public double getHoursWorked() { return hoursWorked; }
    public void   setHourlyRate(double hourlyRate)   { this.hourlyRate  = hourlyRate;  }
    public void   setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
}
