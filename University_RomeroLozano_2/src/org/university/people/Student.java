package org.university.people;

import java.util.Arrays;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;
import org.university.software.Course;


public class Student extends Person {
    private Department department;


    private int unitsCompleted;
    private int totalUnitsNeeded;
    private int currentlyEnrolledCredits;
    private double tuitionFee;

    public Student() {
        super();
        this.unitsCompleted = 0;
        this.totalUnitsNeeded = 0;
        this.currentlyEnrolledCredits = 0;
        this.tuitionFee = 0.0;
    }

    public int calculateRemainingCredits() {
        return totalUnitsNeeded - unitsCompleted;
    }


    @Override
    public void addCourse(CampusCourse cCourse) {
        if (detectConflict(cCourse) || !cCourse.availableTo(this)) {
            
            System.out.println(getName() + " can't add Campus Course " + cCourse.getNumWDepartment() + " " + cCourse.getName() + ". Because this Campus course has enough student.");
            return;
        }
        getCampusCourses().add(cCourse);
        currentlyEnrolledCredits += cCourse.getCreditUnits();
        cCourse.addStudentToRoster(this);


    }

    @Override
    public void addCourse(OnlineCourse oCourse) {
        if (!oCourse.availableTo(this)) {
            return;
        }
        getOnlineCourses().add(oCourse);
        currentlyEnrolledCredits += oCourse.getCreditUnits();
        oCourse.addStudentToRoster(this);

    }


    public double getTuitionFee() {
        double onCampusFee = getCampusCourses().stream().mapToInt(Course::getCreditUnits).sum() * 300;
        double onlineFee = getOnlineCourses().stream().mapToInt(course -> course.getCreditUnits() == 3 ? 2000 : 3000).sum();
        return onCampusFee + onlineFee;
    }

    public void dropCourse(CampusCourse cCourse) {
        // ... (implement the logic for dropping a CampusCourse as per the requirements)
    }

    public void dropCourse(OnlineCourse oCourse) {
        // ... (implement the logic for dropping an OnlineCourse as per the requirements)
    }

    //getters and setters
    public void setDepartment(Department d) {
        this.department = d;
    }
    public Department getDepartment() {
        return department;
    }

    public int getcurrentlyEnrolledCredits() {
        return currentlyEnrolledCredits;
    }
}
