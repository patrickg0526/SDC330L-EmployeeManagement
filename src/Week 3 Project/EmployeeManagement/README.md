# SDC330L - Employee Management System
**Patrick Gonzalez | Week 3**

Java console application demonstrating abstraction, constructors, and access specifiers, built on top of the inheritance, composition, interface, and polymorphism work from Weeks 1 and 2.

## Files
- `src/Main.java` - Entry point. Instantiates sample data using multiple constructor styles.
- `src/Person.java` - New abstract base class for Week 3. Holds shared personal data and declares abstract methods every kind of person must supply.
- `src/Employee.java` - Abstract class. Extends Person, implements Payable, adds employee-only fields.
- `src/Department.java` - Composition target. Multiple constructors added for Week 3.
- `src/SalariedEmployee.java` - Derived class with full, convenience, no-arg, and copy constructors.
- `src/HourlyEmployee.java` - Derived class with multiple constructors and a private pay helper.
- `src/CommissionEmployee.java` - Derived class with multiple constructors and a private pay helper.
- `src/Payable.java` - Interface defining `calculatePay()` and `getPayType()`.
- `src/PayrollProcessor.java` - Uses `List<Payable>` for interface-based polymorphism.
- `src/MessageDisplay.java` - Reusable console output utility.

## Compile and Run
```bash
cd src
javac *.java
java Main
```

## Week 3 Additions
- New abstract `Person` base class. `Employee` now extends it, which adds a fresh abstraction layer above the Week 2 `Payable` interface.
- New abstract method `getRole()` declared on `Person` and supplied by every concrete employee class.
- Multiple constructors on `Person`, `Employee`, `Department`, and every concrete employee class (no-arg, partial, full, copy).
- Constructor chaining via `this(...)` and `super(...)` so each class has one source-of-truth constructor.
- Access specifier audit: personal data moved to `private` on `Person` with `protected` setters, employee-only data is `protected`, internal helpers are `private`, and only the methods the rest of the project actually needs are `public`.
