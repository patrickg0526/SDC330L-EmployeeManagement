/*
 * Author:  Patrick Gonzalez
 * Date:    April 12, 2026
 * Purpose: Base class for the Employee Management application.
 *          Serves as the parent (base) class for all employee types,
 *          establishing the foundation for inheritance.
 *          Also demonstrates composition through the inclusion of
 *          a Department object as a field.
 */
public class Employee {

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
        this.department = department; // composition - Employee contains a Department object
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

    public int        getEmployeeId() { return employeeId; }
    public String     getFirstName()  { return firstName; }
    public String     getLastName()   { return lastName; }
    public String     getEmail()      { return email; }
    public Department getDepartment() { return department; }
}
