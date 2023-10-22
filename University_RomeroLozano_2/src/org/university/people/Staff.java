package org.university.people;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;

public class Staff extends Employee {
    private Department department;
    private double payRate;
    private int hoursWorked;
    private double tuitionFee;

    public Staff() {
        super();
        this.department = null;
        this.payRate = 0.0;
        this.hoursWorked = 0;
        this.tuitionFee = 0.0;
    }

    @Override
    public double earns() {
        return hoursWorked * payRate;
    }

    @Override
    public void raise(double percent) {
        this.payRate += this.payRate * (percent / 100);
    }

    public Integer getTuitionFee() {
        int oc_size = onlineCourses.size();
        int cc_size = campusCourses.size();

        double onCampusFee = 0;
        double onlineFee = 0;
        if (oc_size != 0) {
            for (int i = 0; i < campusCourses.size(); i++) {
                if (campusCourses.get(i) != null) {
                    onCampusFee += campusCourses.get(i).getCreditUnits() * 300;
                }
            }

        }
        if (cc_size != 0) {
            for (Course course : onlineCourses) {
                int fee = (course.getCreditUnits() == 3) ? 2000 : 3000;
                onlineFee += fee;
            }
            
        }
      
        return (int) (onCampusFee + onlineFee);
    }

    public void addCourse(CampusCourse cCourse) {
        int oc_size = onlineCourses.size();
        int cc_size = campusCourses.size();

        if (oc_size != 0 ) {
            OnlineCourse enrolledCourse = onlineCourses.get(0);
            System.out.println(enrolledCourse.getNumWDepartment() + " is removed from " + getName() + "'s schedule(Staff can only take one class at a time)."
            + cCourse.getNumWDepartment() + " has been added from " + getName() + "'s Schedule.");
           

        }
        if (cc_size != 0) {
            CampusCourse enrolledCourse = campusCourses.get(0);
            System.out.println(enrolledCourse.getNumWDepartment() + " is removed from " + getName() + "'s schedule(Staff can only take one class at a time)."
            + cCourse.getNumWDepartment() + " has been added from " + getName() + "'s Schedule.");
            

        }

        if (campusCourses.size() == 0) {
            campusCourses.add(cCourse);
        }
        else {
            campusCourses.set(0, cCourse);

        }

        if (onlineCourses.size() != 0) {
            onlineCourses.remove(0);
        }
    }

    public void addCourse(OnlineCourse oCourse) {
        int oc_size = onlineCourses.size();
        int cc_size = campusCourses.size();
        
        if (oc_size != 0 ) {
            OnlineCourse enrolledCourse = onlineCourses.get(0);
            System.out.println(enrolledCourse.getNumWDepartment() + " is removed from " + getName() + "'s schedule(Staff can only take one class at a time)."
            + oCourse.getNumWDepartment() + " has been added from " + getName() + "'s Schedule.");
            
        }
        if (cc_size != 0) {
            CampusCourse enrolledCourse = campusCourses.get(0);
            System.out.println(enrolledCourse.getNumWDepartment() + " is removed from " + getName() + "'s schedule(Staff can only take one class at a time)."
            + oCourse.getNumWDepartment() + " has been added from " + getName() + "'s Schedule.");
           
        }

        if (onlineCourses.size() == 0) {
            onlineCourses.add(oCourse);
        }
        else {
            onlineCourses.set(0, oCourse);
        }

        if (campusCourses.size() != 0) {
            campusCourses.remove(0);
        }
    }

 
    
}
