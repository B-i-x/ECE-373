package org.university.software;

import org.university.people.Professor;
import org.university.people.Student;
import org.university.hardware.Classroom;
import org.university.hardware.Department;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Integer> schedule = new ArrayList<>();
    private ArrayList<Student> studentRoster = new ArrayList<>();
    private Department department;
    private int courseNumber;
    private Professor professor;

    private String[] week = new String[]{ "Mon", "Tue", "Wed", "Thu", "Fri" };
    private String[] slots = new String[]{ "08:00am to 09:15am", 
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

    public void printSchedule() {

        for (Integer time: schedule) {
            int day = time / 100;
            int time_of_day = time - (day * 100);

            // System.out.println("time: " + time);
            // System.out.println("Day is: " + day);
            // System.out.println("Time slot is: " + time_of_day);
            System.out.println(week[day] + " " + slots[time_of_day] + " " + name);

        }
        return;
    }

    public void addStudent(Student student) {
        studentRoster.add(student);
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


    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setRoomAssigned() {}

    public void setRoomAssigned(Classroom cr) {}

    public Boolean hasProfessor() {
        //if it has a professor, return true
        // System.out.println("Professor val" + professor);
        if (professor == null) {
            return false;
        }

        return true;
    }
}

