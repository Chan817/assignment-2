package assignment2;

import java.util.Scanner;

public class StudentTest {
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		StudentView view = new StudentView();
		
		boolean loop = true;
				
		while(loop) {
			System.out.println("Please insert:\n"
					+ "1: create new data\n"
					+ "2: check student marks");
			int choose = sc.nextInt();
			
			while(choose != 1 && choose != 2) {
				System.out.println("Invalid input. Please try again.");
				System.out.println("Please insert:\n"
						+ "1: create new data\n"
						+ "2: check student marks");
				choose = sc.nextInt();
			}
			
			view.display(choose);
			
			System.out.println("Enter 1 to continue, 2 to exit");
			if(sc.nextInt()==1)
				loop = true;
			else loop = false;
	}
	System.out.println("Program ended.");
	System.exit(0);
}}
