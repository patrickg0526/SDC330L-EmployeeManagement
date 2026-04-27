/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Utility class for reusable console output. Handles the
 *          project header, welcome message, section dividers, and
 *          closing block, so the main class stays readable. Updated
 *          for Week 3 to show the new title and to mention what is
 *          being demonstrated this week.
 */
public class MessageDisplay {

    /*
     * No-arg constructor. There is no state to set up, but having a
     * default constructor explicit and documented makes intent clear.
     */
    public MessageDisplay() {
        // Nothing to initialize.
    }

    /*
     * Prints the project header block with the required Week 3
     * indicator, the assignment title, and the author name.
     */
    public void printHeader() {
        System.out.println("=======================================================");
        System.out.println("  Project Week 3 - Employee Management System");
        System.out.println("  SDC330L: Advanced Object-Oriented Programming");
        System.out.println("  Abstraction, Constructors, and Access Specifiers");
        System.out.println("  Patrick Gonzalez");
        System.out.println("=======================================================");
    }

    /*
     * Prints a welcome block with basic instructions for the user.
     */
    public void printWelcome() {
        System.out.println();
        System.out.println("  Welcome to the Employee Management System!");
        System.out.println();
        System.out.println("  This application manages employee records across");
        System.out.println("  three employee types: Salaried, Hourly, and Commission.");
        System.out.println();
        System.out.println("  Week 3 Demo: Abstraction, Constructors, and Access Specifiers");
        System.out.println("  -------------------------------------------------------------");
        System.out.println("  This week the project gains a new abstract base class");
        System.out.println("  called Person. Employee now extends Person, which adds a");
        System.out.println("  second layer of abstraction on top of the Payable interface");
        System.out.println("  introduced in Week 2.");
        System.out.println();
        System.out.println("  Each class also gained multiple constructors so records can");
        System.out.println("  be built up in different ways. Access specifiers were");
        System.out.println("  reviewed across the whole project so that data and helpers");
        System.out.println("  are only exposed at the level they actually need to be.");
        System.out.println();
        System.out.println("  In this demo the application will create sample employees");
        System.out.println("  using several different constructor styles, display them all,");
        System.out.println("  and finish with the polymorphic payroll report.");
        System.out.println("=======================================================");
    }

    /*
     * Prints a section heading so blocks of output are easy to read.
     */
    public void printSection(String title) {
        System.out.println();
        System.out.println("  " + title);
        System.out.println();
    }

    /*
     * Prints a divider line used between employee blocks.
     */
    public void printDivider() {
        System.out.println("  -----------------------------------------------------");
    }

    /*
     * Prints the closing block at the end of the demo.
     */
    public void printFooter() {
        System.out.println("=======================================================");
        System.out.println("  End of Week 3 Demo. More features coming in Week 4!");
        System.out.println("=======================================================");
    }
}
