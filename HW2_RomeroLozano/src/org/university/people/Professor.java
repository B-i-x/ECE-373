package org.university.people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.university.hardware.Department;
import org.university.software.Course;

public class Professor {
    private String name;
    private List<Course> courses;
    private Department department;

    public Professor() {
        this.courses = new ArrayList<>();
    }

    public boolean detectScheduleConflict(Course aCourse) {
        Boolean conflict_flag = false;
        for (Course c : courses) {
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

    public boolean detectProfessorConflict(Course aCourse) {
        if (aCourse.hasProfessor()) {
            System.out.println("The professor cannot be assigned to this course because professor " + name + " is already assigned to the course " +  aCourse.getCourseNumber() );

            return true;
        }

        return false;
    }

    public boolean detectConflict(Course aCourse) {        

        return (detectProfessorConflict(aCourse) || detectScheduleConflict(aCourse)); // No conflict
    }

    public void addCourse(Course aCourse) {
        if (!detectConflict(aCourse)) {
            courses.add(aCourse);
            aCourse.setProfessor(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printSchedule() {
        Map<Integer, Course> temp_times = new HashMap<>();

        for (Course c : courses) {
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

    public Department getDepartment() {
        return department;
    }

}

// public void printScheduleBasic(List<Course> courses) {
//     Map<Integer, Course> tempTimes = new HashMap<>();

//     // 1) Flatten all course times into the map
//     for (Course c : /* ______ */) { // TODO: pick the collection to iterate
//         for (Integer t : /* ______ */) { // TODO: get times from the course
//             tempTimes.put(/* key */ ______, /* value */ ______); // TODO
//         }
//     }

//     // 2) Copy keys to a list and sort
//     List<Integer> sortedKeys = new ArrayList<>(/* ______ */); // TODO: which keys?
//     /* ______ */.sort(sortedKeys); // TODO: which utility sorts?

//     // 3) Print
//     for (Integer x : /* ______ */) { // TODO: which list to iterate?
//         System.out.println(
//             Course.printIndividualSchedule(/* ______ */) +  // TODO: time key
//             tempTimes.get(/* ______ */).getNumWDepartment() + " " + // TODO
//             tempTimes.get(/* ______ */).getName() // TODO
//         );
//     }
// }
