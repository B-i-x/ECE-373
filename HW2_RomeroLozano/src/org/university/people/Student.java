package org.university.people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Boolean conflict_flag = false;
        for (Course c : schedule) {
            for (Integer course_time: c.getSchedule()) {
                for (Integer new_course_time: aCourse.getSchedule()) {
                    // System.out.println(course_time + " " + new_course_time);
                    if (course_time.equals(new_course_time)) {
                        // System.out.println("match found with " + aCourse.getNumWDepartment());
                        System.out.println( aCourse.getNumWDepartment() + " course cannot be added to " + getName() + "'s schedule. " + aCourse.getNumWDepartment() + " conflicts with " + c.getNumWDepartment() + ". Conflicting time slot is " + Course.printIndividualSchedule(course_time) + ".");

                        if (conflict_flag != true) {
                            conflict_flag = true;
                        }
                    }

                }

            }
           
        }

        return conflict_flag;
    }

    public void addCourse(Course aCourse) {
        if (detectConflict(aCourse)) {
            // System.out.println("Schedule conflict detected. Cannot add course '" + aCourse.getName() + "'.");
        } else {
            schedule.add(aCourse);
            aCourse.addStudent(this);
            // System.out.println("Course '" + aCourse.getName() + "' added to the schedule of " + name + ".");
        }
    }

    public void dropCourse(Course aCourse) {
        boolean removed = schedule.remove(aCourse);
        if (removed) {
            aCourse.removeStudent(this);
            // System.out.println("Course '" + aCourse.getName() + "' dropped from the schedule of " + name + ".");
        } else {
            System.out.println("The course " + aCourse.getNumWDepartment() + " could not be dropped because " + name + " is not enrolled in " + aCourse.getNumWDepartment() + ".");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printSchedule() {
        Map<Integer, Course> temp_times = new HashMap<>();

        for (Course c : schedule) {
            for (Integer time: c.getSchedule()) {
                temp_times.put(time, c);
            }
        }

        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(temp_times.keySet());
 
        Collections.sort(sortedKeys);

        for (Integer x : sortedKeys) {
            System.out.println(Course.printIndividualSchedule(x) + temp_times.get(x).getNumWDepartment() + " " + temp_times.get(x).getName());
        }
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setRequiredCredits(int numOfCredits) {
        this.totalUnitsNeeded = numOfCredits;
    }

    public void setCompletedUnits(int numOfCompletedCredits) {
        this.unitsCompleted = numOfCompletedCredits;
    }

    public int requiredToGraduate() {
        return (this.totalUnitsNeeded - this.unitsCompleted);
    }
}
