/*
 * Author:  Patrick Gonzalez
 * Date:    April 19, 2026
 * Purpose: Base class for the Employee Management application.
 *          Serves as the parent (base) class for all employee types,
 *          establishing the foundation for inheritance. Demonstrates
 *          composition through the inclusion of a Department object
 *          as a field. In Week 2, this class also implements the
 *          Payable interface, which forces every derived employee
 *          type to provide its own calculatePay() implementation.
 */

// Employee implements the Payable interface. This is where the
// interface contract enters the inheritance chain, so every derived
// class inherits the requirement to supply a calculatePay() method.
public abstract class Employee implements Payable {

    // Fields shared across all employee types
    protected int        employeeId;
    protected String     firstName;
    protected String     lastName;
    protected String     email;

    // Composition: Employee HAS-A Department
    protected Department department;

    /*
     * Constructor for Employee (base class)
     */
    public Employee(int employeeId, String firstName, String lastName,
                    String email, Department department) {
        this.employeeId = employeeId;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.department = department;
    }

    /*
     * Displays the core employee information shared by all employee types.
     * Derived classes call super.displayInfo() to include this output.
     */
    public void displayInfo() {
        System.out.println("  Employee ID : " + employeeId);
        System.out.println("  Name        : " + firstName + " " + lastName);
        System.out.println("  Email       : " + email);
        System.out.println("  " + department.toString());
    }

    /*
     * Returns the full name for quick display in payroll reports.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Abstract interface methods from Payable are left unimplemented
    // here on purpose. Each derived class must supply its own version,
    // which is how the polymorphism happens at runtime.
    @Override public abstract double calculatePay();
    @Override public abstract String getPayType();

    public int        getEmployeeId() { return employeeId; }
    public String     getFirstName()  { return firstName; }
    public String     getLastName()   { return lastName; }
    public String     getEmail()      { return email; }
    public Department getDepartment() { return department; }
}
