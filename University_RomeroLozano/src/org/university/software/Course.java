package org.university.software;

import org.university.people.Professor;
import org.university.people.Student;
import org.university.hardware.Classroom;
import org.university.hardware.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {
    private String name;
    private ArrayList<Integer> schedule = new ArrayList<>();
    private ArrayList<Student> studentRoster = new ArrayList<>();
    private Department department;
    private int courseNumber;
    private Professor professor;
    private Classroom classroom;

    private static String[] week = new String[]{ "Mon", "Tue", "Wed", "Thu", "Fri" };
    private static String[] slots = new String[]{ "08:00am to 09:15am", 
                                          "09:30am to 10:45am", 
                                          "11:00am to 12:15pm", 
                                          "12:30pm to 01:45pm", 
                                          "02:00pm to 04:45pm" };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchedule(int time) {
        schedule.add(time);
    }

    public ArrayList<Integer> getSchedule() {
        return schedule;
    }

    public static String printIndividualSchedule(int time) {
        int day = time / 100;
        int time_of_day = time - (day * 100);

        // System.out.println("time: " + time);
        // System.out.println("Day is: " + day);
        // System.out.println("Time slot is: " + time_of_day);
        String formmatted = week[day-1] + " " + slots[time_of_day-1] + " ";
        return formmatted;
    }

    public void printSchedule() {

        for (Integer time: schedule) {
            System.out.println(printIndividualSchedule(time) + name);

        }
        return;
    }

    public void addStudent(Student student) {
        studentRoster.add(student);
    }

    public void removeStudent(Student student) {
        studentRoster.remove(student);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Student> getStudentRoster() {
        return studentRoster;
    }

    
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public String getNumWDepartment() {
        return department.getDepartmentName() + courseNumber;
    }


    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCourseNumber() {
        return courseNumber;
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

    public Boolean hasProfessor() {
        //if it has a professor, return true
        // System.out.println("Professor val" + professor);
        if (professor == null) {
            return false;
        }

        return true;
    }
}

