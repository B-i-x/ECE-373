package org.university.people;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;

public class Staff extends Employee {
    private Department department;
    private double payRate;
    private int hoursWorked;
    private double tuitionFee;
    private CampusCourse enrolledCourse; // Assuming a staff can enroll in only one campus course at a time

    public Staff() {
        super();
        this.department = null;
        this.payRate = 0.0;
        this.hoursWorked = 0;
        this.tuitionFee = 0.0;
        this.enrolledCourse = null;
    }

    @Override
    public double earns() {
        return hoursWorked * payRate;
    }

    @Override
    public void raise(double percent) {
        this.payRate += this.payRate * (percent / 100);
    }

    public double getTuitionFee() {
        double onCampusFee = (enrolledCourse != null) ? enrolledCourse.getCreditUnits() * 300 : 0;
        double onlineFee = getOnlineCourses().stream().mapToInt(course -> course.getCreditUnits() == 3 ? 2000 : 3000).sum();
        return onCampusFee + onlineFee;
    }

    public void addCourse(CampusCourse cCourse) {
        if (enrolledCourse != null) {
            System.out.println("Warning: Overwriting previously enrolled course " + enrolledCourse.getName());
        }
        enrolledCourse = cCourse;
    }

    public void addCourse(OnlineCourse oCourse) {
        if (enrolledCourse != null) {
            System.out.println("Warning: Overwriting previously enrolled course " + enrolledCourse.getName());
        }
    }

    // Getters and Setters for department, payRate, hoursWorked, tuitionFee, and enrolledCourse
    // ... (omitted for brevity)
}
