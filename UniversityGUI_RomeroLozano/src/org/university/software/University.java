package org.university.software;

import org.university.people.Person;
import org.university.people.Professor;
import org.university.people.Staff;
import org.university.people.Student;
import org.university.hardware.Department;
import org.university.hardware.Classroom;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

public class University implements Serializable {
    public ArrayList<Department> departmentList = new ArrayList<>();
    public ArrayList<Classroom> classroomList = new ArrayList<>();

    public void printDepartmentList() {
        System.out.println("Department List:");
        for (Department d : departmentList) {
            System.out.println(d.getDepartmentName());
        }
    }

    public void printClassroomList() {
        System.out.println("\nClassroom list:");

        for (Classroom classroom : classroomList) {
            System.out.println(classroom.getRoomNumber());
        }
    }

    public void printClassroomSchedule() {
        for (Classroom classroom : classroomList) {
            System.out.println("\nThe schedule for classroom " + classroom.getRoomNumber());
            classroom.printSchedule();
        }
    }
    
    public void printStudentList() {
        for (Department d : departmentList) {
            for (Student s : d.getStudents()) {
                System.out.println(s.getName());
            }
        }
    }

    public void printProfessorList() {
        for (Department d : departmentList) {
            System.out.println("\nThe professor list for department " + d.getDepartmentName());
            d.printProfessorList();
        }
    }


    public void printCourseList() {
        for (Department d : departmentList) {
            System.out.println("\nThe course list for department " + d.getDepartmentName());
            d.printCourseList();
        }
    }

    public void printStaffList() {
        for (Department d : departmentList) {
            d.printStaffList();
        }
    }

    public Boolean departmentExists(String departmentName) {
        for (Department d : departmentList) {
            if (d.getDepartmentName().equals(departmentName)) {
                return true;
            }
        }
        return false;
    }

    public Department getDepartmentByName(String departmentName) {
        for (Department department : departmentList) {
            if (department.getDepartmentName().equals(departmentName)) {
                return department;
            }
        }
        return null; // Return null if no department with the given name is found
    }

    public OnlineCourse getOnlineCourseByNumber(int courseNumber) {
        for (Department department : departmentList) {
            for (OnlineCourse course : department.getOnlineCourseList()) {
                if (course.getCourseNumber() == courseNumber) {
                    return course; // Return the online course if found
                }
            }
        }
        return null; // Return null if no online course with the given number is found
    }

    public CampusCourse getCampusCourseByNumber(int courseNumber) {
        for (Department department : departmentList) {
            for (CampusCourse course : department.getCampusCourseList()) {
                if (course.getCourseNumber() == courseNumber) {
                    return course; // Return the campus course if found
                }
            }
        }
        return null; // Return null if no campus course with the given number is found
    }
    
    

    public Classroom getClassroomByNumber(String roomNumber) {
        for (Classroom classroom : classroomList) {
            if (classroom.getRoomNumber().equals(roomNumber)) {
                return classroom;
            }
        }
        return null; // Return null if no classroom with the given room number is found
    }
    
    public Professor getProfessorByName(String name) {
        for (Department department : departmentList) {
            for (Professor professor : department.getProfessorList()) {
                if (professor.getName().equalsIgnoreCase(name)) {
                    return professor;
                }
            }
        }
        return null; // Return null if no professor with the given name is found
    }

    public boolean courseExists(int courseNumber) {
        for (Department department : departmentList) {
            for (CampusCourse course : department.getCampusCourseList()) {
                if (course.getCourseNumber() == courseNumber) {
                    return true; // Course found
                }
            }
        }
        return false; // No course with the given number found
    }

    public Student getStudentByName(String studentName) {
        for (Department department : departmentList) {
            for (Student student : department.getStudentList()) {
                if (student.getName().equalsIgnoreCase(studentName)) {
                    return student; // Return the student if found
                }
            }
        }
        return null; // Return null if no student with the given name is found
    }
    
    
    

    public void printEveryoneInDepartmentSchedule() {
        for (Department d : departmentList) {
            System.out.println("\nDepartment " + d.getDepartmentName());

            System.out.println("\nPrinting professor schedules");
            for (Professor p: d.getProfessorList()) {
                System.out.println("\nThe schedule for Prof. " + p.getName());
                p.printSchedule();
            }

            System.out.println("\nPrinting student schedules");
            for (Student s: d.getStudentList()) {
                System.out.println("\nThe schedule for student " + s.getName());
                s.printSchedule();
            }
            System.out.println("\nPrinting staff schedules");
            for (Staff sf: d.getStaffList()) {
                System.out.println("\nThe schedule for employee " + sf.getName());
                sf.printSchedule();

                System.out.println("\nStaff: " + sf.getName() + "earns " + sf.earns() + " this month");

            }


            System.out.println("\nThe roster for courses offered by " + d.getDepartmentName());
            for (Course c: d.getCampusCourseList()) {

                System.out.println("\nThe roster for course " + c.getNumWDepartment());

                for (Person p: c.getStudentRoster()) {
                    System.out.println(p.getName());
                }
            }
        }
    }

    public void printAll() {
        printDepartmentList();
        printClassroomList();
        printProfessorList();
        printCourseList();
        printClassroomSchedule();
        printEveryoneInDepartmentSchedule();
    }

    public String printAllString() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Redirect System.out to the ByteArrayOutputStream
        PrintStream printStream = new PrintStream(baos);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        // Call the printAll() method, which will now print to the ByteArrayOutputStream
        printAll();

        // Reset System.out to the original PrintStream
        System.setOut(originalPrintStream);

        // Convert the captured output to a string
        String printedOutput = baos.toString();

        // Return the captured output as a string
        return printedOutput;
    }

    public static void saveData(University univ) {
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

        try {
            fileOut = new FileOutputStream("university.ser");
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(univ);
            objOut.close();
            fileOut.close();
        }
        catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static University loadData() {
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;
        University univ = null;

        try {
            fileIn = new FileInputStream("university.ser");
            objIn = new ObjectInputStream(fileIn);
            univ = (University) objIn.readObject();
            objIn.close();
            fileIn.close();
        }
        catch(IOException i) {
            i.printStackTrace();
        }
        catch(ClassNotFoundException c) {
            c.printStackTrace();
        }
        return univ;
    }

    
   
}


