package assignment2;

import java.sql.*;

public class StudentControl {

	private StudentModel model;
	private static StudentView view;
	
	public StudentControl(StudentModel model, StudentView view) {
		this.model = model;
		this.view = view;
	}
	
	// Receive the data from view and save it to database.
	public static void newStudent(int id, String name, String department, double math, double science) throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?", "root", "Chan@1115");
		Statement stmt = conn.createStatement();
		
		// Inserting data into database
		stmt.executeUpdate("INSERT INTO STUDENT VALUES (" + id + ", '" + name + "', '" + department + "', " + math + ", " + science + ");");

		// Send a notification
		System.out.println("Data is saved into database.");
	}
	
	// Read data from database and put it on Model class and send it back to view
	public static void getStudent(int id)throws SQLException{
		// Create an object for model class
		StudentModel student = new StudentModel();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?", "root", "Chan@1115");
		
		// Searching for specific student from the database
		String mySQL = "SELECT * FROM STUDENT WHERE ID = " + id;
		
		// Execute the statement
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(mySQL);
		
		if(rs.next()) {
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setDepartment(rs.getString("department"));
			student.setScience(rs.getDouble("science"));
			student.setMath(rs.getDouble("math"));
		}
		
		// Passing the data to view to be displayed to the user
		view.display(student.getId(), student.getName(), student.getDepartment(), student.getMath(), student.getScience());
		
		
	}
}
