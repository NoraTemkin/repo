/*
 * Class: CMSC201 
 * Instructor: Dr. Grinberg
 * Description: Program creates Student, Faculty, & Staff objects (all subclasses of Person class)
 *              from user input and displays the attributes of each object created
 * Due: 07/15/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Nora Temkin
*/

import java.util.Scanner;

public class Driver {
	public static final int MIN_CHOICE = 1, MAX_CHOICE = 2, CREATE_STUDENT = 1, CREATE_EMPLOYEE = 2,
			                CREATE_FACULTY = 1, CREATE_STAFF = 2, INVALID_CHOICE = -1;
	
	public static void main(String[] args) {
		// create a Scanner to get user input
		Scanner input = new Scanner(System.in);
		
		// display main menu & get user input to find out whether user wants to create a Student or an Employee
		int menuChoice = doMainMenu(input);
		
		if (menuChoice == CREATE_STUDENT) {
		// create a Student object & display its attributes
			Person currentStudent = Student.createFromKeyboard(input);
			System.out.println(currentStudent.toString());
		}	// end if block to create Student
		
		else if (menuChoice == CREATE_EMPLOYEE) {
		// create an Employee object of user's desired classification (faculty or staff)
		// display submenu to find out whether user wants to enter a Faculty or Staff member
			
			menuChoice = doEmployeeMenu(input);
			
			if (menuChoice == CREATE_FACULTY) {
				// create a Faculty object & display its attributes
				Person currentFaculty = new Faculty();
				((Faculty)currentFaculty).initializeFieldsFromKeyboard(input);
				System.out.println(((Faculty)currentFaculty).toString());
			}	// end inner if block to create Faculty member
			
			else if (menuChoice == CREATE_STAFF) {
				// create a Staff object & display its attributes
				Person currentStaff = new Staff();
				((Staff)currentStaff).initializeFieldsFromKeyboard(input);
				System.out.println(((Staff)currentStaff).toString());
			}	// end inner elseif block to create Staff member
		}	// end outer elseif block to create an Employee
		
		// close the Scanner
		input.close();
	}	// end method main()

	// Method to display main menu & get user choice of whether to create a Student or an Employee
	public static int doMainMenu(Scanner input) {
		final String MAIN_MENU = "Enter\n1 to create a Student\n"
				          		+ "2 to create an Employee\n"
				          		+ "Choice: ",
				     ERROR_MESSAGE = "Error: invalid menu choice. Please enter 1 or 2: ";
		int userMenuChoice = INVALID_CHOICE;
		
		System.out.print(MAIN_MENU);	// display main menu & prompt
		do {	// get user input; as long as user's menu choice input is invalid, show error message/reprompt
			// validate that user entered a number in range (1 or 2)
			userMenuChoice = Person.validateIntInput(input.nextLine(), input);
			if (userMenuChoice < MIN_CHOICE || userMenuChoice > MAX_CHOICE)	// user choice out of range
				userMenuChoice = INVALID_CHOICE;
			
			if (userMenuChoice == INVALID_CHOICE) {
				System.out.print(ERROR_MESSAGE);
				userMenuChoice = Person.validateIntInput(input.nextLine(), input);
				if (userMenuChoice < MIN_CHOICE || userMenuChoice > MAX_CHOICE) {
					userMenuChoice = INVALID_CHOICE;
					System.out.print(ERROR_MESSAGE);
				}
			}	// end if userMenuChoice is invalid block
		} while (userMenuChoice == INVALID_CHOICE);
		
		return userMenuChoice;
	}
	
	// Method to display Employee sub-menu & get user choice of whether to create a Faculty or Staff member
	public static int doEmployeeMenu(Scanner input) {
		final String EMPLOYEE_MENU = "1) To create a faculty member\n"
          							+ "2) To create a staff member\n"
          							+ "Choice: ",
          			 ERROR_MESSAGE = "Error: invalid menu choice. Please enter 1 or 2: ";
		int userMenuChoice = INVALID_CHOICE;

		System.out.print(EMPLOYEE_MENU);	// display menu & prompt
		do {	// get user input; while user's menu choice input is invalid, show error message & reprompt
			
			// validate that user entered a number in range (1 or 2)
			userMenuChoice = Person.validateIntInput(input.nextLine(), input);
			if (userMenuChoice < MIN_CHOICE || userMenuChoice > MAX_CHOICE)	// user choice out of range
				userMenuChoice = INVALID_CHOICE;
			
			if (userMenuChoice == INVALID_CHOICE) {
				System.out.print(ERROR_MESSAGE);
				userMenuChoice = Person.validateIntInput(input.nextLine(), input);
				if (userMenuChoice < MIN_CHOICE || userMenuChoice > MAX_CHOICE) {
					userMenuChoice = INVALID_CHOICE;
					System.out.print(ERROR_MESSAGE);
				}
			}	// end if userMenuChoice is invalid block
		} while (userMenuChoice == INVALID_CHOICE);

return userMenuChoice;
	}
}	// end class Driver
