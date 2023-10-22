package org.university.people;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;
import org.university.software.Course;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private Department department;
    
    private List<Course> schedule;
    private List<CampusCourse> cc_schedule;
    private List<OnlineCourse> oc_schedule;

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

    @Override
    public void addCourse(CampusCourse cCourse) {
        if (detectConflict(cCourse) || !cCourse.availableTo(this)) {
            return;
        }
        getCampusCourses().add(cCourse);
        currentlyEnrolledCredits += cCourse.getCreditUnits();
    }

    @Override
    public void addCourse(OnlineCourse oCourse) {
        if (!oCourse.availableTo(this)) {
            return;
        }
        getOnlineCourses().add(oCourse);
        currentlyEnrolledCredits += oCourse.getCreditUnits();
    }

    public double calculateTuition() {
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
}
