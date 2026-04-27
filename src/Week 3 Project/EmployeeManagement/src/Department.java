/*
 * Author:  Patrick Gonzalez
 * Date:    April 26, 2026
 * Purpose: Represents a company department. Used inside Employee to
 *          demonstrate composition. Updated for Week 3 to add multiple
 *          constructors and tighten access on the internal helper.
 */
public class Department {

    // Access specifiers: every field is private. Nothing outside this
    // class needs direct access, so they are locked down and reached
    // only through the public getters below.
    private String name;
    private String location;
    private String managerName;

    /*
     * No-arg constructor. Sets placeholder values for any field that
     * has not been provided yet. Helpful when a department is created
     * before all of its info is known.
     */
    public Department() {
        this("Unassigned", "TBD", "TBD");
    }

    /*
     * Constructor that takes only the department name. The location
     * and manager get placeholder values. Uses this(...) so the
     * three-arg constructor stays the single point of truth.
     */
    public Department(String name) {
        this(name, "TBD", "TBD");
    }

    /*
     * Full constructor. Every other constructor in this class chains
     * down to this one, which means the field-assignment logic only
     * lives in one place.
     */
    public Department(String name, String location, String managerName) {
        this.name        = name;
        this.location    = location;
        this.managerName = managerName;
    }

    /*
     * Copy constructor. Builds a Department from another Department.
     */
    public Department(Department other) {
        this(other.name, other.location, other.managerName);
    }

    public String getName()        { return name;        }
    public String getLocation()    { return location;    }
    public String getManagerName() { return managerName; }

    // Access specifier choice: private helper. It is only called from
    // inside this class by toString(), so there is no reason to expose
    // it. Keeps the public surface area of the class small.
    private String formatLine() {
        return "Department: " + name + " | Location: " + location + " | Manager: " + managerName;
    }

    @Override
    public String toString() {
        return formatLine();
    }
}
