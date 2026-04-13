/*
 * Author:  Patrick Gonzalez
 * Date:    April 12, 2026
 * Purpose: Represents a company department. This class is used to demonstrate
 *          composition by being included as a field within the Employee class.
 */
public class Department {

    private String name;
    private String location;
    private String managerName;

    /*
     * Constructor for Department
     */
    public Department(String name, String location, String managerName) {
        this.name        = name;
        this.location    = location;
        this.managerName = managerName;
    }

    public String getName()        { return name; }
    public String getLocation()    { return location; }
    public String getManagerName() { return managerName; }

    @Override
    public String toString() {
        return "Department: " + name + " | Location: " + location + " | Manager: " + managerName;
    }
}
