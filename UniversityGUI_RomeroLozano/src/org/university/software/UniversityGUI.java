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
	private JFrame frame;
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
			// else if(source.equals(studentAddCourse)) {
			// 	handleStudentAddCourse();
			// }
			// else if(source.equals(studentDropCourse)) {
			// 	handleStudentDropCourse();
			// }
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
			// else if(source.equals(adminNewDepartment)) {
			// 	handleAdminNewDepartment();
			// }
			else if(source.equals(adminAssignClass)) {
				handleAdminAssignClassroom();
			}
			// else if(source.equals(adminAssignProfessor)) {
			// 	handleAdminAssignProfessor();
			// }
			
			
			
	    }

    }

    public static boolean areAllFieldsFilled(ArrayList<String> fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                                              "All fields must be filled out.", 
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

            CampusCourse course = univ.getCourseByNumber(courseNum);
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
                                                "Classroom '" + roomNumber + "' is already assigned to a course at this time", 
                                                "Error", 
                                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            course.setRoomAssigned(classroom);
        }


    }
}