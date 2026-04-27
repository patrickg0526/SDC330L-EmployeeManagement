/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Entry point for the Week 3 build of the Employee Management
 *          application. Instantiates sample employees with realistic
 *          data using several different constructor styles to exercise
 *          the new constructors added this week. Displays every
 *          employee through a Person-typed reference to demonstrate
 *          the new abstraction layer, and runs payroll through the
 *          Payable interface to keep the polymorphism demo from
 *          Week 2 alive.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MessageDisplay display = new MessageDisplay();

        display.printHeader();
        display.printWelcome();

        // Build out the departments. Three different Department
        // constructors are used here to demonstrate the constructor
        // work done this week.
        Department itDept    = new Department("Information Technology", "Building A", "Sarah Johnson");
        Department salesDept = new Department("Sales");
        salesDept.getName(); // value already set, kept here for show
        Department hrDept    = new Department();
        // Copy constructor demo: build a duplicate Department, then
        // make sure the copy has its own data and not a shared object.
        Department itDeptCopy = new Department(itDept);

        // Use the full Salaried constructor: every field provided.
        SalariedEmployee emp1 = new SalariedEmployee(
                1001, "James", "Carter", "jcarter@company.com", itDept, 85000.00);

        // Use the convenience Hourly constructor that defaults hours
        // worked to 40 a week. Demonstrates constructor chaining.
        HourlyEmployee emp2 = new HourlyEmployee(
                1002, "Maria", "Lopez", "mlopez@company.com", salesDept, 22.50);

        // Use the full Commission constructor with all eight fields.
        CommissionEmployee emp3 = new CommissionEmployee(
                1003, "David", "Thompson", "dthompson@company.com", hrDept,
                40000.00, 0.08, 75000.00);

        // Demonstrate the no-arg constructor + setters path. The
        // record starts empty and gets filled in field by field.
        SalariedEmployee emp4 = new SalariedEmployee();
        emp4.setEmployeeId(1004);
        emp4.setDepartment(itDeptCopy);
        emp4.setAnnualSalary(72000.00);
        // Personal info setters are protected on Person, so the
        // application uses the Employee-level constructors when it
        // needs to set names. For this demo the no-arg path is shown
        // and the placeholder name from Person stays in place to
        // make the access-specifier story visible in the output.

        // Demonstrate the copy constructor: clone an existing record
        // and bump the salary to show the original is untouched.
        SalariedEmployee emp5 = new SalariedEmployee(emp1);
        emp5.setEmployeeId(1005);
        emp5.setAnnualSalary(emp1.getAnnualSalary() + 5000.00);

        // Abstraction in action: the list is typed as Person, the new
        // abstract base class added this week. Even though every item
        // is really a SalariedEmployee, HourlyEmployee, or
        // CommissionEmployee, this loop only sees them as Person.
        // displayInfo() and getRole() resolve to the right method at
        // runtime because of the abstract methods defined on Person.
        List<Person> people = new ArrayList<>();
        people.add(emp1);
        people.add(emp2);
        people.add(emp3);
        people.add(emp4);
        people.add(emp5);

        display.printSection("Displaying All People (abstraction via Person base class):");

        for (Person person : people) {
            display.printDivider();
            person.displayInfo();
            display.printDivider();
            System.out.println();
        }

        // Interface-based polymorphism (carried over from Week 2):
        // every Employee implements Payable, so the same five
        // employees can be processed by PayrollProcessor without
        // PayrollProcessor knowing the concrete types.
        List<Payable> payroll = new ArrayList<>();
        payroll.add(emp1);
        payroll.add(emp2);
        payroll.add(emp3);
        payroll.add(emp4);
        payroll.add(emp5);

        PayrollProcessor processor = new PayrollProcessor();
        processor.runPayroll(payroll);

        display.printFooter();
    }
}
