package university;

import java.util.ArrayList;

public class Student {
    private String name;
    private Department department;
    private ArrayList<Course> courses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
