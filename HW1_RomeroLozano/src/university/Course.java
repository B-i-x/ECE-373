package university;

import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Integer> schedule = new ArrayList<>();
    private ArrayList<Student> studentRoster = new ArrayList<>();
    private Department department;
    private int courseNumber;

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

    public void addStudent(Student student) {
        studentRoster.add(student);
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
}
