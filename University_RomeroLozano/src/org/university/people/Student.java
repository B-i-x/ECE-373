package org.university.people;

import java.util.ArrayList;
import java.util.List;

import org.university.hardware.Department;
import org.university.software.Course;

public class Student {
    private String name;
    private List<Course> schedule;
    private Department department;
    private int unitsCompleted;
    private int totalUnitsNeeded;

    public Student() {
        this.schedule = new ArrayList<>();
        this.unitsCompleted = 0;
        this.totalUnitsNeeded = 0;
    }

    public void setUnitsCompleted(int unitsCompleted) {
        this.unitsCompleted = unitsCompleted;
    }

    public void setTotalUnitsNeeded(int totalUnitsNeeded) {
        this.totalUnitsNeeded = totalUnitsNeeded;
    }

    public int calculateRemainingCredits() {
        return totalUnitsNeeded - unitsCompleted;
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
        //     System.out.println("Schedule conflict detected. Cannot add course '" + aCourse.getName() + "'.");
        // } else {
        //     schedule.add(aCourse);
        //     System.out.println("Course '" + aCourse.getName() + "' added to the schedule of " + name + ".");
        // }
    }

    public void dropCourse(Course aCourse) {
        // boolean removed = schedule.remove(aCourse);
        // if (removed) {
        //     System.out.println("Course '" + aCourse.getName() + "' dropped from the schedule of " + name + ".");
        // } else {
        //     System.out.println("The course '" + aCourse.getName() + "' could not be dropped because '" + name + "' is not enrolled in '" + aCourse.getName() + "'.");
        // }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Course> getSchedule() {
        return schedule;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
