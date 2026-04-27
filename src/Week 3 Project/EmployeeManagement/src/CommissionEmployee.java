/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Concrete employee type for commission-based workers. Extends
 *          Employee and supplies its own version of every abstract
 *          method inherited from Person, Employee, and Payable.
 *          Updated for Week 3 to add multiple constructors and a
 *          private helper that keeps the pay calculation in one place.
 */

// Inheritance: CommissionEmployee extends Employee. It rides on top of
// the Person personal data and the Payable interface.
public class CommissionEmployee extends Employee {

    // Access specifier: private. Each commission detail belongs only
    // to this class and is reached through the public getters/setters.
    private double baseSalary;
    private double commissionRate;
    private double salesAmount;

    /*
     * No-arg constructor. Sets safe defaults so a record can be built
     * up field by field.
     */
    public CommissionEmployee() {
        super();
        this.baseSalary     = 0.0;
        this.commissionRate = 0.0;
        this.salesAmount    = 0.0;
    }

    /*
     * Convenience constructor that uses default sales of zero. Useful
     * for new hires before they have made any sales yet. Chains to the
     * full constructor through this(...).
     */
    public CommissionEmployee(int employeeId, String firstName, String lastName,
                              String email, Department department,
                              double baseSalary, double commissionRate) {
        this(employeeId, firstName, lastName, email, department,
             baseSalary, commissionRate, 0.0);
    }

    /*
     * Full constructor. Pushes shared employee data up to the Employee
     * constructor through super(...) and sets the commission fields here.
     */
    public CommissionEmployee(int employeeId, String firstName, String lastName,
                              String email, Department department,
                              double baseSalary, double commissionRate, double salesAmount) {
        super(employeeId, firstName, lastName, email, department);
        this.baseSalary     = baseSalary;
        this.commissionRate = commissionRate;
        this.salesAmount    = salesAmount;
    }

    /*
     * Copy constructor. Sends the source up to the Employee copy
     * constructor and duplicates the commission fields here.
     */
    public CommissionEmployee(CommissionEmployee other) {
        super(other);
        this.baseSalary     = other.baseSalary;
        this.commissionRate = other.commissionRate;
        this.salesAmount    = other.salesAmount;
    }

    /*
     * Overrides displayInfo() to add commission-specific lines after
     * the shared employee block.
     */
    @Override
    public void displayInfo() {
        System.out.println("  [ Commission Employee ]");
        super.displayInfo();
        System.out.printf ("  Base Salary     : $%,.2f%n", baseSalary);
        System.out.printf ("  Commission Rate : %.0f%%%n", commissionRate * 100);
        System.out.printf ("  Total Sales     : $%,.2f%n", salesAmount);
        System.out.printf ("  Total Pay       : $%,.2f%n", totalPay());
    }

    // Access specifier choice: private helper. Pay is calculated in
    // one method that the rest of the class shares, so the formula
    // is never written twice and never exposed outside the class.
    private double totalPay() {
        return baseSalary + (commissionRate * salesAmount);
    }

    @Override
    public double calculatePay() {
        return totalPay();
    }

    @Override
    public String getPayType() {
        return "Commission (base + rate x sales)";
    }

    @Override
    public String getRole() {
        return "Commission Employee";
    }

    public double getBaseSalary()     { return baseSalary;     }
    public double getCommissionRate() { return commissionRate; }
    public double getSalesAmount()    { return salesAmount;    }
    public void   setBaseSalary(double baseSalary)         { this.baseSalary     = baseSalary;     }
    public void   setCommissionRate(double commissionRate) { this.commissionRate = commissionRate; }
    public void   setSalesAmount(double salesAmount)       { this.salesAmount    = salesAmount;    }
}
