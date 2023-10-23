package org.university.hardware;

import org.university.hardware.Department;
import org.university.software.Course;
import org.university.software.CampusCourse;
import org.university.software.OnlineCourse;


import org.university.people.Student;
import org.university.people.Professor;
import org.university.people.Staff;

import java.util.ArrayList;


public class Department {
    private String departmentName;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<CampusCourse> campusCourses = new ArrayList<>();
    private ArrayList<OnlineCourse> onlineCourses = new ArrayList<>();

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Professor> professors = new ArrayList<>();
    private ArrayList<Staff> staff = new ArrayList<>();

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addCourse(CampusCourse cCourse) {
        campusCourses.add(cCourse);
        cCourse.setDepartment(this);
    }

    public void addCourse(OnlineCourse oCourse) {
        onlineCourses.add(oCourse);
        oCourse.setDepartment(this);
    }

    public void addStaff(Staff s) {
        staff.add(s);
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

    public ArrayList<Staff> getStaffList() {
        return this.staff;
    }

    public ArrayList<Student> getStudentList() {
        // System.out.println("called");
        return this.students;
    }

    public ArrayList<Course> getCourseList() {
        return this.courses;
    }

    public ArrayList<CampusCourse> getCampusCourseList() {
        return this.campusCourses;
    }

    public ArrayList<OnlineCourse> getOnlineCourseList() {
        return this.onlineCourses;
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

    public void printStaffList() {
        for (Staff s: staff) {
            System.out.println(s.getName() + " ");
        }
    }
 
    public void printCourseList() {
        for (Course c : campusCourses) {
			System.out.println(c.getNumWDepartment() + " " + c.getName());
		}

        for (Course c : onlineCourses) {
			System.out.println(c.getNumWDepartment() + " " + c.getName());
		}
    
    }
}
