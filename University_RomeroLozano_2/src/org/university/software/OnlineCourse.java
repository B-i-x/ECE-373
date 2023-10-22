package org.university.software;

import org.university.people.Student;

public class OnlineCourse extends Course{
    
    @Override
    public boolean availableTo(Student aStudent) {
        if (aStudent.getcurrentlyEnrolledCredits() >= 6) {
            return true;
        }
        return false;
    }

}
