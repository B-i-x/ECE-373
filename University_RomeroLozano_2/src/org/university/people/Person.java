package org.university.people;

import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    protected List<CampusCourse> campusCourses = new ArrayList<>() ;
    protected List<OnlineCourse> onlineCourses = new ArrayList<>() ;

    public Person() {
    }

    public boolean detectConflict(CampusCourse aCourse) {
        Boolean conflict_flag = false;
        for (CampusCourse c : campusCourses) {
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

    public void printSchedule() {
        System.out.println(name + "'s Schedule:");
        for (CampusCourse course : campusCourses) {
            System.out.println(course.getName() + " - " + course.getSchedule());
        }
        for (OnlineCourse course : onlineCourses) {
            System.out.println(course.getName());
        }
    }

    public abstract void addCourse(CampusCourse cCourse);
    public abstract void addCourse(OnlineCourse oCourse);

    // Getters and Setters for name, campusCourses, and onlineCourses
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<CampusCourse> getCampusCourses() {
        return campusCourses;
    }

    public List<OnlineCourse> getOnlineCourses() {
        return onlineCourses;
    }
}
