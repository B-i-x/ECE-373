package org.university.software;

import org.university.people.Student;

public class OnlineCourse extends Course{
    
    @Override
    public boolean availableTo(Student aStudent) {
        if (aStudent.getcurrentlyEnrolledCredits() >= 6) {
            return true;
        }
        System.out.println("Student " + aStudent.getName() + "has only " + aStudent.getcurrentlyEnrolledCredits() + " on campus credits enrolled. Should have at least 6 credits registered before registering online courses.");
        return false;
    }

}
