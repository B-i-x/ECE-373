package org.university.people;

import org.university.software.CampusCourse;
import org.university.software.Course;
import org.university.software.OnlineCourse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Person implements Serializable {
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
        Map<Integer, Course> temp_times = new HashMap<>();

        for (Course c : campusCourses) {
            for (Integer time: c.getSchedule()) {
                temp_times.put(time, c);
            }
        }

        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(temp_times.keySet());
 
        Collections.sort(sortedKeys);

        for (Integer x : sortedKeys) {
            System.out.println(Course.printIndividualSchedule(x) + temp_times.get(x).getNumWDepartment() + " " + temp_times.get(x).getName());
        }

        for (OnlineCourse course : onlineCourses) {
            System.out.println(course.getNumWDepartment() + " " + course.getName());
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
