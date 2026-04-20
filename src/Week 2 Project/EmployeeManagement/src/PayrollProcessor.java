/*
 * Author:  Patrick Gonzalez
 * Date:    April 19, 2026
 * Purpose: Processes payroll for any list of Payable objects. Does not
 *          care what the concrete type is. This class is the main
 *          polymorphism demonstration for Week 2: it works off the
 *          Payable interface type, so any class that implements
 *          Payable can be added to the list and processed here.
 */

import java.util.List;

public class PayrollProcessor {

    /*
     * Runs payroll on every Payable in the list and prints a report.
     * Polymorphism in action: even though the list contains different
     * concrete Employee types, this method only sees them as Payable.
     * At runtime, Java calls the correct calculatePay() and getPayType()
     * for the actual object.
     */
    public double runPayroll(List<Payable> payables) {

        double total = 0.0;

        System.out.println();
        System.out.println("  -----------------------------------------------------");
        System.out.println("  Payroll Report (processed polymorphically)");
        System.out.println("  -----------------------------------------------------");

        int index = 1;
        for (Payable p : payables) {

            // Polymorphism: calculatePay() and getPayType() resolve
            // to the correct derived class implementation at runtime.
            double pay = p.calculatePay();
            String type = p.getPayType();

            // Pull the name only if the Payable is actually an Employee,
            // demonstrating how we can check and use concrete info when
            // needed while still treating the object as Payable.
            String name = "Payable Item";
            if (p instanceof Employee) {
                name = ((Employee) p).getFullName();
            }

            System.out.printf ("  %d. %-20s  [%s]%n", index, name, type);
            System.out.printf ("     Current Pay : $%,.2f%n", pay);

            total += pay;
            index++;
        }

        System.out.println("  -----------------------------------------------------");
        System.out.printf ("  Payroll Total: $%,.2f%n", total);
        System.out.println("  -----------------------------------------------------");

        return total;
    }
}
