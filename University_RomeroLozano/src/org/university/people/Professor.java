package org.university.people;

import java.util.ArrayList;
import java.util.List;

import org.university.hardware.Department;
import org.university.software.Course;

public class Professor {
    private String name;
    private List<Course> schedule;
    private Department department;

    public Professor() {
        this.schedule = new ArrayList<>();
    }

    public boolean detectConflict(Course aCourse) {
        for (Course course : schedule) {
            if (course.getCourseNumber() == aCourse.getCourseNumber()) {
                return true; // Conflict detected
            }
        }

        if (aCourse.hasProfessor()) {
            return true; // Conflict detected
        }

        return false; // No conflict
    }

    public void addCourse(Course aCourse) {
        // System.out.println("is conflict detected? " + detectConflict(aCourse));
        if (detectConflict(aCourse)) {
            System.out.println("The professor cannot be assigned to this course because professor " + name + " is already assigned to the course " +  aCourse.getName() );
            // System.out.println("Schedule conflict detected. Cannot add course '" + aCourse.getName() + "'.");
            return;
        } 
        else {
            schedule.add(aCourse);
            aCourse.setProfessor(this);
            // System.out.println("Course '" + aCourse.getName() + "' added to the schedule of " + name + ".");
            return;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printSchedule() {
        return;
    }

    public Department getDepartment() {
        return department;
    }

}
