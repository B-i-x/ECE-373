package org.university.people;

import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    protected List<CampusCourse> campusCourses;
    protected List<OnlineCourse> onlineCourses;

    public Person() {
        this.name = "";
        this.campusCourses = new ArrayList<>();
        this.onlineCourses = new ArrayList<>();
    }

    public boolean detectConflict(CampusCourse aCourse) {
        for (CampusCourse course : campusCourses) {
            if (course.getSchedule().stream().anyMatch(time -> aCourse.getSchedule().contains(time))) {
                return true;
            }
        }
        return false;
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
