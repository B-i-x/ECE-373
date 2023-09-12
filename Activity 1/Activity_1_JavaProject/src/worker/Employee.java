package worker;

public class Employee {
    private String name;
    private double salary;
    private Date hire_date;

    // Constructor
    public Employee(String name, int salary, Date hire_date) {
        this.name = name;
        this.salary = salary;
        this.hire_date = hire_date;
    }

    // Method to give a raise to the employee
    public void giveRaise(double percent_of_salary) {
        this.salary += (this.salary * percent_of_salary / 100.0);
    }

    // Method to check if two employee names are the same
    public boolean hasSameName(String name_to_compare) {
        return this.name.equals(name_to_compare);
    }

    public String printEmployee() {
        return "Name of Employee: " + this.name + "\n" +
               "Salary of Employee: " + this.salary + "\n" +
               "Start Date of Employee: " + this.hire_date.printDate() + "\n"; 
    }
}