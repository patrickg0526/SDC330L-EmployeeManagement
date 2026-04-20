# SDC330L - Employee Management System
**Patrick Gonzalez | Week 2**

Java console application demonstrating inheritance, composition, interfaces, and polymorphism.

## Files
- `src/Main.java` - Entry point
- `src/Employee.java` - Abstract base class (inheritance + composition + implements Payable)
- `src/Department.java` - Composition class
- `src/SalariedEmployee.java` - Derived class
- `src/HourlyEmployee.java` - Derived class
- `src/CommissionEmployee.java` - Derived class
- `src/Payable.java` - Interface defining calculatePay() and getPayType()
- `src/PayrollProcessor.java` - Uses List<Payable> for interface-based polymorphism
- `src/MessageDisplay.java` - Utility class for console output

## Compile & Run
```bash
cd src
javac *.java
java Main
```

## Week 2 Additions
- Added the `Payable` interface
- `Employee` is now abstract and implements `Payable`
- Each derived employee type supplies its own `calculatePay()` and `getPayType()`
- Added `PayrollProcessor` which runs payroll on a `List<Payable>` polymorphically
- Added `MessageDisplay` utility for reusable console output
