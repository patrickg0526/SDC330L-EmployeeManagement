/*
 * Author:  Patrick Gonzalez
 * Date:    April 19, 2026
 * Purpose: Entry point for the Employee Management application - Week 2 Demo.
 *          Reuses the Employee hierarchy from Week 1 (inheritance and
 *          composition) and adds the Week 2 requirements: a Payable
 *          interface, a class (PayrollProcessor) that operates on the
 *          interface, and a polymorphic payroll run across all employee
 *          types. Instantiates sample employees with realistic data and
 *          displays their information before running payroll.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Reusable output helper so the main method stays readable.
        MessageDisplay display = new MessageDisplay();

        display.printHeader();
        display.printWelcome();

        // Create Department objects - composition is shown here (used inside Employee)
        Department itDept    = new Department("Information Technology", "Building A", "Sarah Johnson");
        Department salesDept = new Department("Sales",                  "Building B", "Mark Williams");
        Department hrDept    = new Department("Human Resources",        "Building C", "Lisa Chen");

        // Instantiate derived classes with realistic info - inheritance demonstrated here
        SalariedEmployee    emp1 = new SalariedEmployee(
                1001, "James", "Carter", "jcarter@company.com", itDept, 85000.00);

        HourlyEmployee      emp2 = new HourlyEmployee(
                1002, "Maria", "Lopez",  "mlopez@company.com",  salesDept, 22.50, 40.0);

        CommissionEmployee  emp3 = new CommissionEmployee(
                1003, "David", "Thompson", "dthompson@company.com", hrDept, 40000.00, 0.08, 75000.00);

        // Polymorphism: store all employees in a list typed as the base
        // class, then call displayInfo() on each. Java dispatches to the
        // correct overridden method based on the actual object type.
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        display.printSection("Displaying All Employees (polymorphism via base class reference):");

        for (Employee emp : employees) {
            display.printDivider();
            emp.displayInfo();
            display.printDivider();
            System.out.println();
        }

        // Polymorphism through the Payable interface: same three
        // objects added to a List<Payable>. PayrollProcessor does not
        // know or care which concrete type each one is, it only uses
        // the interface methods.
        List<Payable> payroll = new ArrayList<>();
        payroll.add(emp1);
        payroll.add(emp2);
        payroll.add(emp3);

        PayrollProcessor processor = new PayrollProcessor();
        processor.runPayroll(payroll);

        display.printFooter();
    }
}
