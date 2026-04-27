/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Concrete employee type for full-time salaried workers.
 *          Extends Employee and supplies its own version of every
 *          abstract method inherited from Employee, Person, and
 *          Payable. Updated for Week 3 to include multiple
 *          constructors and tighter access modifiers.
 */

// Inheritance: SalariedEmployee extends Employee, which itself extends
// Person and implements Payable. That gives this class three layers of
// behavior to plug into through the abstract methods.
public class SalariedEmployee extends Employee {

    // Access specifier: private. The annual salary is owned by this
    // class only, so nothing outside should reach in to change it
    // without going through the public setter.
    private double annualSalary;

    /*
     * No-arg constructor. Builds a salaried employee with safe defaults.
     * Useful when records are filled in piece by piece.
     */
    public SalariedEmployee() {
        super();
        this.annualSalary = 0.0;
    }

    /*
     * Convenience constructor that uses a sensible default annual salary.
     * Chains to the full constructor through this(...) so all of the
     * field setup still happens in one place.
     */
    public SalariedEmployee(int employeeId, String firstName, String lastName,
                            String email, Department department) {
        this(employeeId, firstName, lastName, email, department, 50000.00);
    }

    /*
     * Full constructor. Hands the shared employee data up to the
     * Employee constructor with super(...) and sets the salary here.
     */
    public SalariedEmployee(int employeeId, String firstName, String lastName,
                            String email, Department department, double annualSalary) {
        super(employeeId, firstName, lastName, email, department);
        this.annualSalary = annualSalary;
    }

    /*
     * Copy constructor. Useful for promoting/duplicating a record.
     * Sends the source object up to the Employee copy constructor.
     */
    public SalariedEmployee(SalariedEmployee other) {
        super(other);
        this.annualSalary = other.annualSalary;
    }

    /*
     * Overrides the base displayInfo() to add salaried-specific data
     * after the shared employee block.
     */
    @Override
    public void displayInfo() {
        System.out.println("  [ Salaried Employee ]");
        super.displayInfo();
        System.out.printf ("  Annual Salary: $%,.2f%n", annualSalary);
    }

    // Provides the salaried implementation of the Payable contract.
    // Weekly pay is the annual salary divided by 52 weeks.
    @Override
    public double calculatePay() {
        return annualSalary / 52.0;
    }

    @Override
    public String getPayType() {
        return "Salaried (weekly from annual)";
    }

    // Provides the role label demanded by the new abstract method
    // on Person. Each concrete employee class reports its own role.
    @Override
    public String getRole() {
        return "Salaried Employee";
    }

    public double getAnnualSalary() { return annualSalary; }
    public void   setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }
}
