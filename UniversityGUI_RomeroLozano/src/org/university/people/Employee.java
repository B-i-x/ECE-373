package org.university.people;

public abstract class Employee extends Person {
    
    public Employee() {
        super();
    }

    // Abstract method to determine how much an employee earns
    public abstract double earns();

    // Abstract method to raise the salary or pay rate of an employee by a given percentage
    public abstract void raise(double percent);

    
}
