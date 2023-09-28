package org.university.software;

import org.university.people.Student;
import org.university.hardware.Department;

import java.util.ArrayList;

public class University {
    public ArrayList<Department> departmentList = new ArrayList<>();
    public ArrayList<Department> classroomList = new ArrayList<>();

    public void printDepartmentList() {
        for (Department d : departmentList) {
            System.out.println(d.getDepartmentName());
        }
    }

    public void printStudentList() {
        for (Department d : departmentList) {
            for (Student s : d.getStudents()) {
                System.out.println(s.getName());
            }
        }
    }

    public void printCourseList() {
        for (Department d : departmentList) {
            for (Course c : d.getCourses()) {
                System.out.println(c.getName());
            }
        }
    }
}