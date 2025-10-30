package org.university.people;

import org.university.hardware.Department;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;
import org.university.software.Course;


public class Student extends Person {
    private Department department;


    private int unitsCompleted;
    private int totalUnitsNeeded;
    private int currentlyEnrolledCredits;
    private int tuitionFee;

    public Student() {
        
    }

    public int requiredToGraduate() {
        return totalUnitsNeeded - unitsCompleted - currentlyEnrolledCredits;
    }


    @Override
    public void addCourse(CampusCourse cCourse) {
        if (!cCourse.availableTo(this)) {
            
            System.out.println(getName() + " can't add Campus Course " + cCourse.getNumWDepartment() + " " + cCourse.getName() + ". Because this Campus course has enough student.");
            return;
        }
        if(detectConflict(cCourse)) {
            return;
        }
        getCampusCourses().add(cCourse);
        currentlyEnrolledCredits += cCourse.getCreditUnits();
        cCourse.addStudentToRoster(this);


    }

    @Override
    public void addCourse(OnlineCourse oCourse) {
        if (!oCourse.availableTo(this)) {

            System.out.println(getName() + " can't add online Course " + oCourse.getNumWDepartment() + " " + oCourse.getName() + ". Because this student doesn't have enough Campus course credit.");

            return;
        }
        
        getOnlineCourses().add(oCourse);
        currentlyEnrolledCredits += oCourse.getCreditUnits();
        oCourse.addStudentToRoster(this);

    }


    public Integer getTuitionFee() {
        double onCampusFee = getCampusCourses().stream().mapToInt(Course::getCreditUnits).sum() * 300;
        double onlineFee = getOnlineCourses().stream().mapToInt(course -> course.getCreditUnits() == 3 ? 2000 : 3000).sum();
        this.tuitionFee = (int) (onCampusFee + onlineFee);
        return  tuitionFee;
    }

    public void dropCourse(CampusCourse cCourse) {
        // ... (implement the logic for dropping a CampusCourse as per the requirements)
        if (!getCampusCourses().contains(cCourse)) {
            System.out.println("The course " + cCourse.getNumWDepartment() + " could not be dropped because " + getName() + " is not enrolled in " + cCourse.getNumWDepartment()  + ".");
            return;
        }
    
        int totalCampusCreditsAfterDrop = getCampusCourses().stream().mapToInt(Course::getCreditUnits).sum() - cCourse.getCreditUnits();
    
        if (getOnlineCourses().size() > 0 && totalCampusCreditsAfterDrop < 6) {
            System.out.println(getName() + " can't drop this CampusCourse, because student doesn't have enough campus course credit to hold online courses.");
            return;
        }
    
        getCampusCourses().remove(cCourse);
        currentlyEnrolledCredits -= cCourse.getCreditUnits();
        cCourse.removeStudent(this);
    }

    public void dropCourse(OnlineCourse oCourse) {
        if (!getOnlineCourses().contains(oCourse)) {
            System.out.println("The course " + oCourse.getNumWDepartment() + " could not be dropped because " + getName() + " is not enrolled in " + oCourse.getNumWDepartment() + ".");
            return;
        }
        getOnlineCourses().remove(oCourse);
        currentlyEnrolledCredits -= oCourse.getCreditUnits();
        oCourse.removeStudent(this);
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

    public void setRequiredCredits(int i) {
        this.totalUnitsNeeded = i;
    }

    public void setCompletedUnits(int i) {
        this.unitsCompleted = i;
    }
}
