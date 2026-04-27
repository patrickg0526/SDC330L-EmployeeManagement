/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Abstract employee class. Sits between the Person base class
 *          and the concrete employee types. Adds work-related fields
 *          (employee ID, department) on top of the personal data that
 *          comes from Person. Implements the Payable interface so every
 *          derived employee type has to provide its own pay logic.
 *          Updated for Week 3 to extend the new Person abstract class
 *          and to expose multiple constructors.
 */

// Abstraction: Employee is itself abstract. It extends Person (another
// abstract class) and implements Payable (an interface). That gives
// the project two layers of abstract classes plus an interface, all
// working together. Employee adds its own abstract methods on top of
// the ones inherited from Person.
public abstract class Employee extends Person implements Payable {

    // Access specifiers:
    //  - employeeId is protected so derived classes can read it for
    //    their own displayInfo() blocks without going through a getter
    //    every time.
    //  - department is also protected for the same reason.
    // Anything that needed to be private has been pushed up into Person.
    protected int        employeeId;
    protected Department department;

    /*
     * No-arg constructor. Provides safe defaults so a partially built
     * Employee can be set up in stages. Marked protected because only
     * subclasses (or test code in the same package) should call it.
     * Calls super() to send safe defaults up to Person.
     */
    protected Employee() {
        super();
        this.employeeId = 0;
        this.department = new Department();
    }

    /*
     * Partial constructor. Useful when only the basic identity info
     * is known up front and the department gets attached later.
     */
    protected Employee(int employeeId, String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.employeeId = employeeId;
        this.department = new Department();
    }

    /*
     * Full constructor. Takes every piece of base employee data and
     * passes the personal info up to the Person constructor through
     * super(...). Marked protected so only subclasses can call it.
     */
    protected Employee(int employeeId, String firstName, String lastName,
                       String email, Department department) {
        super(firstName, lastName, email);
        this.employeeId = employeeId;
        this.department = department;
    }

    /*
     * Copy constructor. Builds a new Employee shell from another
     * Employee, including the personal data via super(other).
     * Subclasses can chain to this when they want to support copying.
     */
    protected Employee(Employee other) {
        super(other);
        this.employeeId = other.employeeId;
        // A fresh Department copy keeps the new Employee from sharing
        // the same Department object as the original one.
        this.department = new Department(other.department);
    }

    /*
     * Shared display block for any employee. Subclasses call this
     * through super.displayInfo() and then add their own specific
     * fields after it. Marked public because Main and the payroll
     * report both call it from outside the class hierarchy.
     */
    @Override
    public void displayInfo() {
        System.out.println("  Employee ID : " + employeeId);
        // Pulls in the personal info shared by every Person subclass.
        super.displayPersonalInfo();
        System.out.println("  " + department.toString());
    }

    // Abstract methods coming from the Payable interface. Employee
    // does not know how to calculate pay because that depends on the
    // concrete pay type, so it leaves them abstract on purpose. Every
    // derived class will be forced by the compiler to fill these in.
    @Override public abstract double calculatePay();
    @Override public abstract String getPayType();

    // Access specifiers: the data getters are public because outside
    // code (the payroll report, the main demo) uses them. The setters
    // for ID and department are public because the application is
    // expected to be able to update them, but the personal-info
    // setters inherited from Person stayed protected.
    public int        getEmployeeId() { return employeeId; }
    public Department getDepartment() { return department; }

    public void setEmployeeId(int employeeId)         { this.employeeId = employeeId; }
    public void setDepartment(Department department)  { this.department = department; }
}
