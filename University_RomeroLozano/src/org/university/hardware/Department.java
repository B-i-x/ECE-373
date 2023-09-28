package org.university.hardware;

import org.university.hardware.Department;
import org.university.software.Course;
import org.university.people.Student;
import org.university.people.Professor;

import java.util.ArrayList;


public class Department {
    private String departmentName;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Professor> professors = new ArrayList<>();

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setDepartment(this);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setDepartment(this);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
