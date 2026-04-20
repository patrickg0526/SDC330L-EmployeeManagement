/*
 * Author:  Patrick Gonzalez
 * Date:    April 19, 2026
 * Purpose: Interface that defines a contract for anything in the system
 *          that can be paid. Any class that implements this interface
 *          must provide its own implementation of calculatePay() and
 *          getPayType(). This interface is the foundation for the
 *          polymorphic payroll processing added in Week 2.
 */

// Interface creation: Payable defines the required payroll-related
// behavior for any class that represents something the company pays.
public interface Payable {

    /*
     * Returns the current pay amount for this object. Each implementing
     * class calculates pay in its own way (annual salary, weekly hourly
     * pay, or base + commission).
     */
    double calculatePay();

    /*
     * Returns a short label describing the pay type, used when the
     * payroll processor prints the payroll report.
     */
    String getPayType();
}
