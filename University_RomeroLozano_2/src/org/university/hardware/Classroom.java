package org.university.hardware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.university.software.Course;

public class Classroom {
    private String room;
    
    private ArrayList<Course> courses = new ArrayList<>();

    public String getRoomNumber() {
        return room;
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

    public void setRoomNumber(String string) {
        this.room = string;
    }

    public Boolean doesTimeOverlap(Course new_course) {
        if (courses == null) {
            return false;
        }
        for (Course c: courses) {

            for (Integer time: c.getSchedule() ) {

                for (Integer new_time: new_course.getSchedule() ) {

                    if (new_time == time) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public HashMap<Course, Integer> getOverlappingCourse(Course new_course) {
        HashMap<Course, Integer> output = new HashMap<>();
        for (Course c: courses) {

            for (Integer time: c.getSchedule() ) {

                for (Integer new_time: new_course.getSchedule() ) {

                    if (new_time == time) {
                        output.put(c, time);
                    }
                }
            }
        }

        // output.forEach((key, value) -> System.out.println(key + " " + value));

        return output;
    }

    public void addCourse(Course new_course){

        courses.add(new_course);
        
    }
    
}
