package org.university.software;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import org.university.hardware.Classroom;
import org.university.hardware.Department;
import org.university.people.Professor;
import org.university.people.Student;

public class UniversityGUI extends JFrame {
	
	private University univ;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu studentMenu;
	private JMenu adminMenu;
	
	
	// File
	private JMenuItem fileSave;
	private JMenuItem fileLoad;
	private JMenuItem fileExit;
	
	//Student
	private JMenuItem studentAddCourse;
	private JMenuItem studentDropCourse;
	private JMenuItem studentPrintSchedule;
	
	//Administrator
	private JMenuItem adminPrintInfo;
	private JMenuItem adminNewCampusCourse;
	private JMenuItem adminNewOnlineCourse;
	private JMenuItem adminNewDepartment;
	private JMenuItem adminAssignClass;
	private JMenuItem adminAssignProfessor;
	

	public UniversityGUI(String windowTitle, University univ1) {
		super(windowTitle);
		univ = univ1;
		setSize(300,100);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel("<HTML><center>Welcome to the University." +
				"<BR>Choose an action from the above menus.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}

	public void buildGUI() {
		menuBar = new JMenuBar();
     	
		fileMenu = new JMenu("File");
		studentMenu = new JMenu("Students");
		adminMenu = new JMenu("Administrators");
		
		fileSave = new JMenuItem("Save");
		fileLoad = new JMenuItem("Load");
		fileExit = new JMenuItem("Exit");
		
		studentAddCourse = new JMenuItem("Add Course");
		studentDropCourse = new JMenuItem("Drop Course");
		studentPrintSchedule = new JMenuItem("Print Schedule");
		
		adminPrintInfo = new JMenuItem("Print All Info");
		adminNewCampusCourse = new JMenuItem("New Campus Course");
		adminNewOnlineCourse = new JMenuItem("New Online Course");
		adminNewDepartment = new JMenuItem("New Department");
		adminAssignClass = new JMenuItem("Assign Course Classroom");
		adminAssignProfessor = new JMenuItem("Assign Course Professor");
		
	    fileSave.addActionListener(new MenuListener());
	    fileLoad.addActionListener(new MenuListener());
	    fileExit.addActionListener(new MenuListener());
	    studentAddCourse.addActionListener(new MenuListener());
	    studentDropCourse.addActionListener(new MenuListener());
	    studentPrintSchedule.addActionListener(new MenuListener());
	    adminPrintInfo.addActionListener(new MenuListener());
	    adminNewCampusCourse.addActionListener(new MenuListener());
	    adminNewOnlineCourse.addActionListener(new MenuListener());
	    adminNewDepartment.addActionListener(new MenuListener());
	    adminAssignClass.addActionListener(new MenuListener());
	    adminAssignProfessor.addActionListener(new MenuListener());
		
	    fileMenu.add(fileSave);
		fileMenu.add(fileLoad);
		fileMenu.add(fileExit);
		studentMenu.add(studentAddCourse);
		studentMenu.add(studentDropCourse);
		studentMenu.add(studentPrintSchedule);
	    adminMenu.add(adminPrintInfo);
		adminMenu.add(adminNewCampusCourse);
		adminMenu.add(adminNewOnlineCourse);
		adminMenu.add(adminNewDepartment);
		adminMenu.add(adminAssignClass);
		adminMenu.add(adminAssignProfessor);
		
			
		menuBar.add(fileMenu);
	    menuBar.add(studentMenu);
	    menuBar.add(adminMenu);

	
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(fileSave)) {
				University.saveData(univ);
			}
			else if(source.equals(fileLoad)) {
				univ = University.loadData();
			}
			else if(source.equals(fileExit)) {
				System.exit(0);
			}
			else if(source.equals(studentAddCourse)) {
				handleStudentAddCourse();
			}
			else if(source.equals(studentDropCourse)) {
				handleStudentDropCourse();
			}
			// else if(source.equals(studentPrintSchedule)) {
			// 	handleStudentPrint();
			// }
			else if(source.equals(adminPrintInfo)) {
				handleAdminPrintInfo();
			}
			else if(source.equals(adminNewCampusCourse)) {
				handleAdminNewCampusCourse();
			}
			else if(source.equals(adminNewOnlineCourse)) {
				handleAdminNewOnlineCourse();
			}
			else if(source.equals(adminNewDepartment)) {
				handleAdminNewDepartment();
			}
			else if(source.equals(adminAssignClass)) {
				handleAdminAssignClassroom();
			}
			else if(source.equals(adminAssignProfessor)) {
				handleAdminAssignProfessor();
			}
			
			
			
	    }

    }

    public static boolean areAllFieldsFilled(ArrayList<String> fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                                              "User input cannot be empty", 
                                              "Error", 
                                              JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }


    public void handleAdminPrintInfo() {
        JTextArea textArea = new JTextArea(25, 50); // Set your desired size
        textArea.setText(univ.printAllString()); // Assuming getAllInfo() returns a String
        textArea.setEditable(false); // Make the text area non-editable
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JFrame infoFrame = new JFrame("University Information");
        infoFrame.add(scrollPane); // Add the JScrollPane to the frame
        infoFrame.pack(); // Adjusts the frame to the size of its contents
        infoFrame.setLocationRelativeTo(null); // Center the frame
        infoFrame.setVisible(true); // Make the frame visible
    
    }

    public void handleAdminNewCampusCourse() {
        JTextField courseNameField = new JTextField(10);
        JTextField departmentField = new JTextField(10);
        JTextField courseField = new JTextField(10);
        JTextField maxStudentsField = new JTextField(10);
        JTextField creditsField = new JTextField(10);
        JTextField scheduleField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));


        myPanel.add(new JLabel("Course Name:"));
        myPanel.add(courseNameField);
        myPanel.add(new JLabel("Department:"));
        myPanel.add(departmentField);
        myPanel.add(new JLabel("Course #:"));
        myPanel.add(courseField);
        myPanel.add(new JLabel("Max Students:"));
        myPanel.add(maxStudentsField);
        myPanel.add(new JLabel("Credits:"));
        myPanel.add(creditsField);
        myPanel.add(new JLabel("Schedule:"));
        myPanel.add(scheduleField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Please enter the following information:", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String courseName = courseNameField.getText();
            String department = departmentField.getText();
            String courseNumber = courseField.getText();
            String maxStudents = maxStudentsField.getText();
            String credits = creditsField.getText();
            String schedule = scheduleField.getText();

            department = department.toUpperCase();

            if (!areAllFieldsFilled(new ArrayList<String>(Arrays.asList(courseName, department, courseNumber, maxStudents, credits, schedule)))) {;
                return;
            }

            if (!univ.departmentExists(department)) {
                JOptionPane.showMessageDialog(null, 
                                                "Department '" + department + "' isn't a valid department", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            } 

            int courseNum = Integer.parseInt(courseNumber);
            int maxStud = Integer.parseInt(maxStudents);
            int creditUnits = Integer.parseInt(credits);
            int sched = Integer.parseInt(schedule);

            CampusCourse newCourse = new CampusCourse();
            newCourse.setName(courseName);
            newCourse.setCourseNumber(courseNum);
            newCourse.setMaxCourseLimit(maxStud);
            newCourse.setCreditUnits(creditUnits);
            newCourse.setSchedule(sched);

            Department dept = univ.getDepartmentByName(department);
            if (dept != null) {
                dept.addCourse(newCourse);
                }
        }
    }

    public void handleAdminNewOnlineCourse() {
        JTextField courseNameField = new JTextField(10);
        JTextField departmentField = new JTextField(10);
        JTextField courseField = new JTextField(10);
        JTextField creditsField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));


        myPanel.add(new JLabel("Course Name:"));
        myPanel.add(courseNameField);
        myPanel.add(new JLabel("Department:"));
        myPanel.add(departmentField);
        myPanel.add(new JLabel("Course #:"));
        myPanel.add(courseField);
        myPanel.add(new JLabel("Credits:"));
        myPanel.add(creditsField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Please enter the following information:", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String courseName = courseNameField.getText();
            String department = departmentField.getText();
            String courseNumber = courseField.getText();
            String credits = creditsField.getText();

            department = department.toUpperCase();

            if (!areAllFieldsFilled(new ArrayList<String>(Arrays.asList(courseName, department, courseNumber, credits)))) {;
                return;
            }

            if (!univ.departmentExists(department)) {
                JOptionPane.showMessageDialog(null, 
                                                "Department '" + department + "' isn't a valid department", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            } 

            int courseNum = Integer.parseInt(courseNumber);
            int creditUnits = Integer.parseInt(credits);

            OnlineCourse newCourse = new OnlineCourse();
            newCourse.setName(courseName);
            newCourse.setCourseNumber(courseNum);
            newCourse.setCreditUnits(creditUnits);

            Department dept = univ.getDepartmentByName(department);
            if (dept != null) {
                dept.addCourse(newCourse);
                }
        }
    }

    public void handleAdminAssignClassroom() {
        JTextField courseNameField = new JTextField(10);
        JTextField courseField = new JTextField(10);
        JTextField roomField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.add(new JLabel("Course Name:"));
        myPanel.add(courseNameField);
        myPanel.add(new JLabel("Course #:"));
        myPanel.add(courseField);
        myPanel.add(new JLabel("Room #:"));
        myPanel.add(roomField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Please enter the following information:", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String courseName = courseNameField.getText();
            String courseNumber = courseField.getText();
            String roomNumber = roomField.getText();

            if (!areAllFieldsFilled(new ArrayList<String>(Arrays.asList(courseName, courseNumber, roomNumber)))) {;
                return;
            }

            int courseNum = Integer.parseInt(courseNumber);

            CampusCourse course = univ.getCampusCourseByNumber(courseNum);
            if (course == null) {
                JOptionPane.showMessageDialog(null, 
                                                "Course '" + courseNum + "' isn't a valid course", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            } 

            Classroom classroom = univ.getClassroomByNumber(roomNumber);
            if (classroom == null) {
                JOptionPane.showMessageDialog(null, 
                                                "Classroom '" + roomNumber + "' isn't a valid classroom", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            } 

            if (classroom.doesTimeOverlap(course)) {
                JOptionPane.showMessageDialog(null, 
                                                course.getNumWDepartment() + " conflicts with " + classroom.getCourseOverlap(course).getNumWDepartment() + ". Conflicting time slot Mon 9:30am to 10:45am. " + course.getNumWDepartment() + " course cannot be added to " + classroom.getRoomNumber() +"'s Schedule.", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            course.setRoomAssigned(classroom);

            JOptionPane.showMessageDialog(null, 
                                            "Success you have assigned " + course.getNumWDepartment() + " to " + classroom.getRoomNumber(), 
                                            "Success", 
                                            JOptionPane.DEFAULT_OPTION);
        }
    }

    public void handleAdminNewDepartment() {
        JTextField departmentField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.add(new JLabel("Department:"));
        myPanel.add(departmentField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "New Department", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String department = departmentField.getText();

            if (!areAllFieldsFilled(new ArrayList<String>(Arrays.asList(department)))) {;
                return;
            }

            department = department.toUpperCase();

            if (univ.departmentExists(department)) {
                JOptionPane.showMessageDialog(null, 
                                                department + " Department " + " already exists", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            } 

            Department newDepartment = new Department();
            newDepartment.setDepartmentName(department);

            univ.departmentList.add(newDepartment);

            JOptionPane.showMessageDialog(null, 
                                            department + " Department was added to University", 
                                            "Success", 
                                            JOptionPane.DEFAULT_OPTION);
        }
    }
    
    public void handleAdminAssignProfessor() {
        JTextField ProfessorField = new JTextField(10);
        JTextField DepartmentField = new JTextField(10);
        JTextField CourseField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.add(new JLabel("Professor:"));
        myPanel.add(ProfessorField);
        myPanel.add(new JLabel("Department:"));
        myPanel.add(DepartmentField);
        myPanel.add(new JLabel("Course #:"));
        myPanel.add(CourseField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Assign Professor to Course", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            String professor = ProfessorField.getText();
            String department = DepartmentField.getText();
            String courseNumber = CourseField.getText();

            if (!areAllFieldsFilled(new ArrayList<String>(Arrays.asList(professor, department, courseNumber)))) {;
                return;
            }

            department = department.toUpperCase();

            if (!univ.departmentExists(department)) {
                JOptionPane.showMessageDialog(null, 
                                                "Department " + department + " doesn't exist", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            Professor prof = univ.getProfessorByName(professor);

            if (prof == null) {
                JOptionPane.showMessageDialog(null, 
                                                "Professor " + professor + " doesn't exist", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!univ.courseExists(Integer.parseInt(courseNumber))) {
                JOptionPane.showMessageDialog(null, 
                                                "Course " + courseNumber + " doesn't exist", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            OnlineCourse course = univ.getOnlineCourseByNumber(Integer.parseInt(courseNumber));
            if (course != null) {
                
                if (course.getProfessor() != null) {
                    JOptionPane.showMessageDialog(null, 
                            "The professor cannot be assigned to this online course, because professor " + 
                            course.getProfessor().getName() + " is already assigned to the online course " + 
                            course.getName() + ".",
                                                    "Error", 
                                                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            CampusCourse course2 = univ.getCampusCourseByNumber(Integer.parseInt(courseNumber));
            if (course2 != null) {
                if (course2.getProfessor() != null) {
                    JOptionPane.showMessageDialog(null, 
                            "The professor " + prof.getName() + "cannot be assigned to this campus course, because professor " + 
                            course2.getProfessor().getName()  + " is already assigned to the course " + 
                            course2.getName() + ".",
                                                    "Error", 
                                                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }

    public void handleStudentAddCourse() {
        JTextField studentField = new JTextField(10);
        JTextField departmentField = new JTextField(10);
        JTextField courseField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.add(new JLabel("Student:"));
        myPanel.add(studentField);
        myPanel.add(new JLabel("Department:"));
        myPanel.add(departmentField);
        myPanel.add(new JLabel("Course #:"));
        myPanel.add(courseField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Add Course", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String student = studentField.getText();
            String department = departmentField.getText();
            String courseNumber = courseField.getText();

            if (!areAllFieldsFilled(new ArrayList<String>(Arrays.asList(student, department, courseNumber)))) {;
                return;
            }

            department = department.toUpperCase();

            if (!univ.departmentExists(department)) {
                JOptionPane.showMessageDialog(null, 
                                                "Department " + department + " doesn't exist", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student stud = univ.getStudentByName(student);

            if (stud == null) {
                JOptionPane.showMessageDialog(null, 
                                                "Student " + student + " doesn't exist", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            OnlineCourse course = univ.getOnlineCourseByNumber(Integer.parseInt(courseNumber));
            if (course != null && !stud.addOnlineCourseToString(course).isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                                                stud.addOnlineCourseToString(course), 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);                
                return;
            }

            CampusCourse course2 = univ.getCampusCourseByNumber(Integer.parseInt(courseNumber));
            if (course2 != null && !stud.addCampusCourseToString(course2).isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                                                stud.addCampusCourseToString(course2), 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);                
                return;
            }

            if (course != null) {
                stud.addCourse(univ.getOnlineCourseByNumber(Integer.parseInt(courseNumber)));
                JOptionPane.showMessageDialog(null, 
                                            "Success you have added " + course.getNumWDepartment() + " to " + stud.getName(), 
                                            "Success", 
                                            JOptionPane.DEFAULT_OPTION);
            } else if (course2 != null) {
                stud.addCourse(univ.getCampusCourseByNumber(Integer.parseInt(courseNumber)));
                JOptionPane.showMessageDialog(null, 
                                            "Success you have added " + course2.getNumWDepartment() + " to " + stud.getName(), 
                                            "Success", 
                                            JOptionPane.DEFAULT_OPTION);
            } else {
                return;
            }           
        }
    }

    public void handleStudentDropCourse() {
        JTextField studentField = new JTextField(10);
        JTextField departmentField = new JTextField(10);
        JTextField courseField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));

        myPanel.add(new JLabel("Student:"));
        myPanel.add(studentField);
        myPanel.add(new JLabel("Department:"));
        myPanel.add(departmentField);
        myPanel.add(new JLabel("Course #:"));
        myPanel.add(courseField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Add Course", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String student = studentField.getText();
            String department = departmentField.getText();
            String courseNumber = courseField.getText();

            if (!areAllFieldsFilled(new ArrayList<String>(Arrays.asList(student, department, courseNumber)))) {;
                return;
            }

            department = department.toUpperCase();

            if (!univ.departmentExists(department)) {
                JOptionPane.showMessageDialog(null, 
                                                "Department " + department + " doesn't exist", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student stud = univ.getStudentByName(student);

            if (stud == null) {
                JOptionPane.showMessageDialog(null, 
                                                "Student " + student + " doesn't exist", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            OnlineCourse course = univ.getOnlineCourseByNumber(Integer.parseInt(courseNumber));
            if (course != null && !stud.dropOnlineCourseToString(course).isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                                                stud.dropOnlineCourseToString(course), 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);                
                return;
            }

            CampusCourse course2 = univ.getCampusCourseByNumber(Integer.parseInt(courseNumber));
            if (course2 != null && !stud.dropCampusCourseToString(course2).isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                                                stud.dropCampusCourseToString(course2), 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);                
                return;
            }

            if (course != null) {
                stud.dropCourse(univ.getOnlineCourseByNumber(Integer.parseInt(courseNumber)));
                JOptionPane.showMessageDialog(null, 
                                            "Success you have dropped " + course.getNumWDepartment() + " from " + stud.getName(), 
                                            "Success", 
                                            JOptionPane.DEFAULT_OPTION);
            } else if (course2 != null) {
                stud.dropCourse(univ.getCampusCourseByNumber(Integer.parseInt(courseNumber)));
                JOptionPane.showMessageDialog(null, 
                                            "Success you have dropped " + course2.getNumWDepartment() + " from " + stud.getName(), 
                                            "Success", 
                                            JOptionPane.DEFAULT_OPTION);
            } else {
                return;
            }
        }
    }
}