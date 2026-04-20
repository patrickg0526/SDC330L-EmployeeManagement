/*
 * Author:  Patrick Gonzalez
 * Date:    April 19, 2026
 * Purpose: Utility class for reusable console output. Handles the project
 *          header, welcome message, section dividers, and closing message
 *          so the main application stays clean. Designed to be reused in
 *          future weeks as the application grows.
 */
public class MessageDisplay {

    /*
     * Prints the project header block with title, course, and author.
     */
    public void printHeader() {
        System.out.println("=======================================================");
        System.out.println("  Project Week 2 - Employee Management System");
        System.out.println("  SDC330L: Advanced Object-Oriented Programming");
        System.out.println("  Interfaces and Polymorphism");
        System.out.println("  Patrick Gonzalez");
        System.out.println("=======================================================");
    }

    /*
     * Prints the welcome block with basic instructions for the user.
     */
    public void printWelcome() {
        System.out.println();
        System.out.println("  Welcome to the Employee Management System!");
        System.out.println();
        System.out.println("  This application manages employee records across");
        System.out.println("  three employee types: Salaried, Hourly, and Commission.");
        System.out.println();
        System.out.println("  Week 2 Demo: Interfaces and Polymorphism");
        System.out.println("  ----------------------------------------");
        System.out.println("  A new Payable interface has been added. Each employee");
        System.out.println("  type now implements calculatePay() and getPayType()");
        System.out.println("  in its own way. The PayrollProcessor works off the");
        System.out.println("  Payable interface, so it can run payroll on any");
        System.out.println("  employee type without knowing the concrete class.");
        System.out.println();
        System.out.println("  In this demo, sample employees are created and");
        System.out.println("  displayed, then a payroll report is produced using");
        System.out.println("  interface-based polymorphism.");
        System.out.println("=======================================================");
    }

    /*
     * Prints a section heading so the output is easy to read.
     */
    public void printSection(String title) {
        System.out.println();
        System.out.println("  " + title);
        System.out.println();
    }

    /*
     * Prints a simple divider line used between employee blocks.
     */
    public void printDivider() {
        System.out.println("  -----------------------------------------------------");
    }

    /*
     * Prints the closing block at the end of the demo.
     */
    public void printFooter() {
        System.out.println("=======================================================");
        System.out.println("  End of Week 2 Demo. More features coming in Week 3!");
        System.out.println("=======================================================");
    }
}
