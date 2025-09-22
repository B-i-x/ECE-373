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
        return this.students;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public ArrayList<Professor> getProfessorList() {
        return this.professors;
    }

    public void printSchedule() {
    }

    public ArrayList<Student> getStudentList() {
        // System.out.println("called");
        return this.students;
    }

    public ArrayList<Course> getCourseList() {
        return this.courses;
    }

    public void printStudentList() {
        for (Student st : students) {
			System.out.println(st.getName() + " ");
		}
    }

    public void printProfessorList() {
        for (Professor p : professors) {
			System.out.println(p.getName() + " ");
		}
    }

    public void printCourseList() {
        for (Course c : courses) {
			System.out.println(c.getNumWDepartment() + " ");
		}
    }
}
