package org.library.physobjects;

/*
The Professor class is a subclass of Employee

Changes made to work with MyLibraryTest.java:
    The access modifier of the increaseMaxLimit method was set to public so that MyLibraryTest class can access it.

    An accessCode field was added with getter and setter methods. accessCode is initialized to 0 in the constructor.

    increaseMaxLimit was overridden to for the Professor class, we changed maxBooks in Person to be of protected type instead of private so that professor can access it
*/

public class Professor extends Employee {
    
    private int accessCode;

    // Constructor
    public Professor() {
        super();
        this.accessCode = 0;  // Initializes accessCode to 0 as instructed
    }

    // Getter for accessCode
    public int getAccessCode() {
        return accessCode;
    }

    // Setter for accessCode
    public void setAccessCode(int accessCode) {
        this.accessCode = accessCode;
    }

    // Implementing the abstract method from Employee
    @Override
    public void increaseMaxLimit(int limit) {
        this.maxBooks = limit;  // Assuming maxBooks's access modifier allows access
        System.out.println(getName() + "'s Max limit is now " + this.maxBooks);
    }

}
