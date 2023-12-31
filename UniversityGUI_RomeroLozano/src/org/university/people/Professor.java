package org.university.people;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;


public class Professor extends Employee {
    private double salary;
    private Department department;

    public Professor() {
        super();
        this.salary = 0.0;
        this.department = null;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public double earns() {
        return salary / 26;
    }

    @Override
    public void raise(double percent) {
        this.salary += this.salary * (percent / 100);
    }

    public void addCourse(CampusCourse cCourse) {
        if (detectConflict(cCourse)) {
            return;
        }
        if (cCourse.getProfessor() != null) {
            System.out.println("The professor " + getName() + "cannot be assigned to this campus course, because professor " + 
                               cCourse.getProfessor().getName()  + " is already assigned to the course " + 
                               cCourse.getName() + ".");
            return;
        }
        getCampusCourses().add(cCourse);
        cCourse.setProfessor(this);
    }

    public void addCourse(OnlineCourse oCourse) {
        if (oCourse.getProfessor() != null) {
            System.out.println("The professor cannot be assigned to this online course, because professor " + 
                               oCourse.getProfessor().getName() + " is already assigned to the online course " + 
                               oCourse.getName() + ".");
            return;
        }
        // Assuming professors can teach online courses without any restrictions
        onlineCourses.add(oCourse);
        oCourse.setProfessor(this);
    }

    // Getters and Setters for salary, department, and teachingCourses
    // ... (omitted for brevity)
    //getters and setters
    public void setDepartment(Department d) {
        this.department = d;
    }
    public Department getDepartment() {
        return department;
    }


}
