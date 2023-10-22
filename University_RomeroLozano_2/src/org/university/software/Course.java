package org.university.software;

import org.university.people.Professor;
import org.university.people.Student;
import org.university.hardware.Department;

import java.util.ArrayList;

public abstract class Course {
    private String name;
    private Department department;
    private int courseNumber;
    protected ArrayList<Integer> schedule = new ArrayList<>();
    private ArrayList<Student> studentRoster;
    private Professor professor;
    private int creditUnits;

    private static String[] week = new String[]{ "Mon", "Tue", "Wed", "Thu", "Fri" };
    private static String[] slots = new String[]{   "08:00am to 09:15am", 
                                                    "09:30am to 10:45am", 
                                                    "11:00am to 12:15pm", 
                                                    "12:30pm to 01:45pm", 
                                                    "02:00pm to 04:45pm" };

    public Course() {
        this.name = "";
        this.department = null;
        this.courseNumber = 0;
        this.studentRoster = new ArrayList<>();
        this.professor = null;
        this.creditUnits = 0;
    }
    /////////////////////Simple Getters and Setters/////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Boolean hasProfessor() {
        //if it has a professor, return true
        // System.out.println("Professor val" + professor);
        if (professor == null) {
            return false;
        }

        return true;
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
    /////////////////////SCHEDULING/////////////////////

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
    /////////////////////SCHEDULING/////////////////////

    public void addStudentToRoster(Student student) {
        if (!studentRoster.contains(student)) {
            studentRoster.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (studentRoster.contains(student)) {
            studentRoster.remove(student);
        }
        
    }

    public abstract boolean availableTo(Student aStudent);

    // Getters and Setters for all the fields
    // ... (omitted for brevity)
}
