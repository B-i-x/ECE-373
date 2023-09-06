package university.debug;


import static org.junit.Assert.*;
import org.junit.*;

import university.*;
import java.util.ArrayList;


public class CourseTest {
    
    @Test
    public void testStudent() {
        Student s1 = new Student();
        s1.setName("Tom");
        
        assertEquals("Tom", s1.getName());
        
        Department d = new Department();
        
        s1.setDepartment(d);
        
        assertEquals(d, s1.getDepartment());
        
        Course course1 = new Course();
        course1.setName("Java");
        course1.setSchedule(201);
        course1.setSchedule(401);
        course1.setCourseNumber(373);
        
        s1.addCourse(course1);
        assertEquals("Tom", course1.getStudentRoster().get(0).getName());
    }
    
    @Test
    public void testDepartment() {
        Department d1 = new Department();
        d1.setDepartmentName("ECE");
        
        assertEquals("ECE", d1.getDepartmentName());
        
        Course course1 = new Course();
        course1.setName("OO Programming");
        course1.setSchedule(201);
        course1.setSchedule(401);
        course1.setCourseNumber(373);
        
        d1.addCourse(course1);
        assertEquals("ECE", course1.getDepartment().getDepartmentName());
        
        Student s1 = new Student();
        s1.setName("Pattie");
        
        d1.addStudent(s1);
        
        assertTrue(s1.getDepartment().equals(d1));
        assertEquals("Pattie", d1.getStudents().get(0).getName());
    }
    
    @Test
    public void testStudentRoster() {
        Student s1 = new Student();
        s1.setName("Hagen");
        Student s2 = new Student();
        s2.setName("Daz");
        
        Department d1 = new Department();
        d1.setDepartmentName("ECE");
        
        Course course1 = new Course();
        course1.setName("OO Programming");
        course1.setSchedule(201);
        course1.setSchedule(401);
        course1.setCourseNumber(373);
        
        s1.addCourse(course1);
        s2.addCourse(course1);
        d1.addCourse(course1);
        
        ArrayList<Student> sr = course1.getStudentRoster();
        System.out.println("\nHere is the Roster for " + course1.getName() + " course");
        
        for (Student st : sr) {
            System.out.println(st.getName() + " ");
        }
        
        System.out.println("\nHere is the schedule for " +  course1.getName() + " course");
        ArrayList<Integer> schedule = course1.getSchedule();
        for (Integer time : schedule) {
            System.out.println(time + " ");
        }
        
        System.out.println("\nThe department for " +  course1.getName() +" course is "
                           + course1.getDepartment().getDepartmentName());
        
    }
    
    @Test
    public void testUniversity() {
        University univ = new University();
        
        Student s1 = new Student();
        s1.setName("Hagen");
        Student s2 = new Student();
        s2.setName("Daz");
        Student s3 = new Student();
        s3.setName("Lily");
        
        Department d1 = new Department();
        d1.setDepartmentName("ECE");
        
        Department d2 = new Department();
        d2.setDepartmentName("CS");
        
        Course course1 = new Course();
        course1.setName("OO Programming");
        course1.setSchedule(201);
        course1.setSchedule(401);
        course1.setCourseNumber(373);
        
        Course course2 = new Course();
        course2.setName("Analysis of Discrete Structures");
        course2.setSchedule(301);
        course2.setSchedule(501);
        course2.setCourseNumber(345);
        
        s1.addCourse(course1);
        s2.addCourse(course1);
        d1.addCourse(course1);
        d1.addStudent(s1);
        d1.addStudent(s2);
        
        s3.addCourse(course2);
        d2.addCourse(course2);
        d2.addStudent(s3);
        
        univ.departmentList.add(d1);
        univ.departmentList.add(d2);
        
        /* Print department list from university */
        
        System.out.println("\nThe list of departments in the university:");
        univ.printDepartmentList();
        
        /* Print student list from university */
        
        System.out.println("\nThe list of students in the university:");
        univ.printStudentList();
        
        /* Print course list from university */
        
        System.out.println("\nThe list of courses in the university:");
        univ.printCourseList();
        
    }
    
}
