/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Interface that defines a contract for anything in the system
 *          that can be paid. Any class that implements this interface
 *          must provide its own implementation of calculatePay() and
 *          getPayType(). Carried over from Week 2 and still drives the
 *          interface-based polymorphism used in the payroll demo.
 */

// Abstraction: this interface is one of the abstraction layers in
// the project. It says nothing about how pay is calculated, only
// that any payable object knows how to do it.
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
