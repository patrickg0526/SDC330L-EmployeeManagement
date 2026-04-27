/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Processes payroll for any list of Payable objects. Does not
 *          care what concrete type each item is. Carried over from
 *          Week 2. Updated for Week 3 to make report formatting a
 *          private helper, which is a small access-specifier cleanup.
 */

import java.util.List;

public class PayrollProcessor {

    /*
     * Runs payroll on every Payable in the list and prints a report.
     * The interface-based polymorphism is the whole point: this method
     * is written against the Payable type, so it works for any class
     * that ever implements that interface.
     */
    public double runPayroll(List<Payable> payables) {

        double total = 0.0;

        printReportHeader();

        int index = 1;
        for (Payable p : payables) {

            // calculatePay() and getPayType() resolve to the correct
            // derived class implementation at runtime.
            double pay  = p.calculatePay();
            String type = p.getPayType();

            // Pull the name only when the Payable happens to be an
            // Employee. The rest of the time the report uses a
            // generic label, which keeps the code working even if a
            // non-Employee Payable is added later.
            String name = "Payable Item";
            if (p instanceof Employee) {
                name = ((Employee) p).getFullName();
            }

            System.out.printf ("  %d. %-20s  [%s]%n", index, name, type);
            System.out.printf ("     Current Pay : $%,.2f%n", pay);

            total += pay;
            index++;
        }

        printReportFooter(total);
        return total;
    }

    // Access specifier choice: private. Both helpers are only used
    // inside this class. Keeping them private documents that fact and
    // hides the formatting details from callers.
    private void printReportHeader() {
        System.out.println();
        System.out.println("  -----------------------------------------------------");
        System.out.println("  Payroll Report (processed polymorphically)");
        System.out.println("  -----------------------------------------------------");
    }

    private void printReportFooter(double total) {
        System.out.println("  -----------------------------------------------------");
        System.out.printf ("  Payroll Total: $%,.2f%n", total);
        System.out.println("  -----------------------------------------------------");
    }
}
