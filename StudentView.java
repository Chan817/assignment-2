package assignment2;

import java.sql.*;
import java.util.Scanner;

public class StudentView {
	public void display(int n) {
		StudentModel student = new StudentModel();
		StudentControl controller = new StudentControl(student, this);
		
		Scanner input = new Scanner(System.in);
		
		if (n == 1) {
			try {
				// Reading data from user
				System.out.println("Please enter new data.");
				System.out.print("Student ID: ");
				int id = input.nextInt();
				
				System.out.print("Student name: ");
				String name = input.next();
				
				input.nextLine();
				System.out.print("Please enter the department: ");
				String department = input.nextLine();
		
				System.out.print("Please enter the math mark: ");
				double math = input.nextDouble();
				
				System.out.print("Please enter the science mark: ");
				double science = input.nextDouble();
				
				// Inserting the data through controller
				StudentControl.newStudent(id, name, department, math, science);
			}catch (SQLException e) {
				e.printStackTrace();				
			}
		}else if (n == 2) {
			// Reading student's id from user
			System.out.print("Please enter the Student ID: ");
			int id = input.nextInt();
			try {
				// Reading data from database through controller
				StudentControl.getStudent(id);
			}catch (SQLException e) {
				e.printStackTrace();				
			}
		}
	}
	
	// To display information required by controller
	public void display (int stuID, String stuName, String department, double mathMark, double scienceMark) {
		System.out.println("Student Details: ");
		System.out.println("Student ID: " + stuID);
		System.out.println("Student Name: " + stuName);
		System.out.println("Student Department: " + department);
		System.out.println("Math Mark: " + mathMark);
		System.out.println("Science Mark: " + scienceMark);
	}

}
