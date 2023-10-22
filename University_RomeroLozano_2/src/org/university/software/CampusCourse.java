package org.university.software;

import org.university.hardware.Classroom;
import org.university.people.Student;

import java.util.HashMap;
import java.util.Map;

public class CampusCourse extends Course {
    private int maxStudents;
    private Classroom classroom;

    public CampusCourse() {
        
    }

    public Classroom getRoomAssigned() {
        return classroom;
    }

    public void setRoomAssigned(Classroom classroom) {
        if (!classroom.doesTimeOverlap(this)) {
            //no conflict
            this.classroom = classroom;
            classroom.addCourse(this);
        }
        else {
            HashMap<Course, Integer> result = classroom.getOverlappingCourse(this);

            Map.Entry<Course, Integer> first = result.entrySet().iterator().next();

            Course overlapCourse = first.getKey();
            Integer overlapTime = first.getValue();


            System.out.println(getNumWDepartment() + " conflicts with " + overlapCourse.getNumWDepartment() + ". Conflicting time slot " + printIndividualSchedule(overlapTime) + ". " + getNumWDepartment() + " course cannot be added to " + classroom.getRoomNumber() + "'s Schedule");
        }
        return;

    }

    public void printSchedule() {
        System.out.println(getName() + " meets at " + schedule);
    }

    @Override
    public boolean availableTo(Student aStudent) {

        return getStudentRoster().size() < maxStudents;
    }

    // Getters and Setters for maxStudents, schedule, and classroom
    public void setMaxCourseLimit(int max) {
        this.maxStudents = max;
    }
}
