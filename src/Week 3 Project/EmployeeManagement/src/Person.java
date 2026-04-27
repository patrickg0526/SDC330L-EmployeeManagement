/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Abstract base class that represents a generic person in the
 *          system. Holds the core identity data (first name, last name,
 *          email) that any human-related class will need. Employee
 *          extends Person and adds the work-related data on top.
 *          This class introduces a second layer of abstraction for
 *          Week 3, on top of the Payable interface from Week 2.
 */

// Abstraction: Person is declared abstract, which means it cannot be
// instantiated on its own. It only exists to be extended by classes
// that represent a real kind of person (an Employee, for example).
// Having this layer keeps the personal-info data in one place and
// gives every derived class a guaranteed shape to work with.
public abstract class Person {

    // Access specifiers: these fields are private so nothing outside
    // of Person can touch them directly. Subclasses go through the
    // protected getters/setters below, which keeps the data safe and
    // lets Person change how it stores things later without breaking
    // the rest of the project.
    private String firstName;
    private String lastName;
    private String email;

    /*
     * No-arg constructor. Sets safe defaults so a subclass can be
     * built up field by field if it ever needs to. Marked protected
     * because only subclasses should ever call it, never outside code.
     */
    protected Person() {
        this("Unknown", "Unknown", "unknown@company.com");
    }

    /*
     * Two-arg constructor that takes only the names. Email is filled in
     * with a placeholder. Uses constructor chaining via this(...) so
     * the three-arg constructor stays the single source of truth for
     * field initialization.
     */
    protected Person(String firstName, String lastName) {
        this(firstName, lastName, "unknown@company.com");
    }

    /*
     * Full constructor that takes every field. This is the constructor
     * the others delegate to, so every Person object goes through one
     * known initialization path no matter which constructor was called.
     */
    protected Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
    }

    /*
     * Copy constructor. Builds a new Person from an existing one.
     * Useful when a record needs to be duplicated without sharing state.
     */
    protected Person(Person other) {
        this(other.firstName, other.lastName, other.email);
    }

    /*
     * Abstract method that every concrete subclass has to implement.
     * Each kind of person describes its role in its own way. This is
     * the new abstract method introduced for Week 3 and it lives at
     * the Person level on purpose, so the role idea is independent
     * of how the pay is calculated.
     */
    public abstract String getRole();

    /*
     * Abstract display method. Each subclass decides how to print
     * itself. Person does not assume what fields the subclass adds,
     * so it leaves the actual formatting to them.
     */
    public abstract void displayInfo();

    /*
     * Helper used by subclasses when they want to print the shared
     * personal info block. Marked protected because it is only meant
     * to be called from within the inheritance chain, not from the
     * outside world.
     */
    protected void displayPersonalInfo() {
        System.out.println("  Name        : " + getFullName());
        System.out.println("  Email       : " + email);
        System.out.println("  Role        : " + getRole());
    }

    /*
     * Returns the formatted full name. Public because callers outside
     * the inheritance chain (the payroll report, for example) use it.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Access specifiers: getters are public because the rest of the
    // application reads these values. Setters are protected because
    // only subclasses should be able to change identity data, not
    // arbitrary outside code.
    public    String getFirstName() { return firstName; }
    public    String getLastName()  { return lastName;  }
    public    String getEmail()     { return email;     }

    protected void setFirstName(String firstName) { this.firstName = firstName; }
    protected void setLastName(String lastName)   { this.lastName  = lastName;  }
    protected void setEmail(String email)         { this.email     = email;     }
}
