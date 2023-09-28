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
        // for (Course course : schedule) {
        //     if (course.hasScheduleConflict(aCourse)) {
        //         return true; // Conflict detected
        //     }
        // }
        return false; // No conflict
    }

    public void addCourse(Course aCourse) {
        // if (detectConflict(aCourse)) {
        //     System.out.println("Schedule conflict detected. Cannot assign course '" + aCourse.getName() + "' to Professor " + name + ".");
        // } else if (aCourse.getProfessor() != null) {
        //     System.out.println("The professor cannot be assigned to this course because Professor " + aCourse.getProfessor().getName() + " is already assigned to the course '" + aCourse.getName() + "'.");
        // } else {
        //     schedule.add(aCourse);
        //     aCourse.setProfessor(this); // Assign the professor to the course
        //     System.out.println("Professor " + name + " assigned to teach course '" + aCourse.getName() + "'.");
        // }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getSchedule() {
        return schedule;
    }

    public Department getDepartment() {
        return department;
    }
}
