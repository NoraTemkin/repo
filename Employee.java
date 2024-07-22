/*
 * Class: CMSC201 
 * Instructor: Dr. Grinberg
 * Description: Employee class w/ officeNumber, salary, & dateHired fields; subclass of Person
 * Due: 07/15/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Nora Temkin
*/

import java.util.Scanner;

public class Employee extends Person {
	final static String DATE_PATTERN = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
	final protected String DEFAULT_DATE_OF_HIRE = "01/01/2024";
	final protected int DEFAULT_OFFICE_NUMBER = 0,	// no office assigned to this employee
			  DEFAULT_SALARY = 82139; 	// overall average salary at Montgomery College, per salary.com
	protected int officeNumber,
			  	  salary;
	protected MyDate dateHired;

	// Constructors
	public Employee() {
		super();
		officeNumber = DEFAULT_OFFICE_NUMBER;
		salary = DEFAULT_SALARY;
		dateHired = new MyDate(DEFAULT_DATE_OF_HIRE);
	}
	
	// this constructor does not initialize inherited data fields; attributes inherited from Person superclass
	// can be initialized via overridden initializeFieldsFromKeyboard using super. version of method, or via setters
	// to avoid unreadably long list of parameters for constructor
	public Employee(int officeNumber, int salary, MyDate dateHired) {
		this.officeNumber = officeNumber;
		this.salary = salary;
		this.dateHired = dateHired;
	}
	
	// Getter & Setter methods
	public int getOfficeNumber() {
		return this.officeNumber;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public MyDate getDateHired() {
		return this.dateHired;
	}
	
	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setDateHired(MyDate dateHired) {
		this.dateHired = dateHired;
	}
	
	// Other methods
	// 1. Method to initialize data fields from user's keyboard input
	@Override
	public void initializeFieldsFromKeyboard(Scanner scan) {
		final String OFFICE_NUMBER_PROMPT = "Enter an office number: ",
					 SALARY_PROMPT = "Enter a salary: $",
					 DATE_HIRED_PROMPT = "Enter a hire date (mm/dd/yyyy): ";
		String tempOfficeInput;	// variable to hold user input "none", etc., in case employee doesn't have an office
					 
		super.initializeFieldsFromKeyboard(scan);	// initializes name, address, phone number, & email
		
		// Prompt user for employee's office number
		System.out.print(OFFICE_NUMBER_PROMPT);
		// Get user input & check that there's an office number, then assign value to officeNumber data field
		tempOfficeInput = scan.nextLine();
		if (tempOfficeInput.equalsIgnoreCase("none") || tempOfficeInput.contains("no office"))
			this.officeNumber = 0;
		else this.officeNumber = validateIntInput(tempOfficeInput, scan);
		
		// Prompt user for employee's salary
		System.out.print(SALARY_PROMPT);
		// Get user input; validate it as a whole number (no cents) & assign its value to salary field
		this.salary = validateIntInput(scan.nextLine(), scan);
		
		// Prompt user for employee's date of hire
		System.out.print(DATE_HIRED_PROMPT);
		// Get user input; validate it & format it correctly if necessary
		this.dateHired = new MyDate(validateDateString(scan.nextLine(), scan));
		
		
	}	// end method populateFieldsFromKeyboard
	
	// 2. Method to format date of hire as mm/dd/yyyy
		public static String formatDate(String rawDate) {
			// NOTE: method assumes date = a String of 8 digits, w/ or w/o separators, from calling method validateDateString
			if (rawDate.matches(DATE_PATTERN))	// user entered date of hire in correct format
				return rawDate;
			else {											// user entered phoneNumber in incorrect format; reformat it
				String[] dateSections = rawDate.split("[/,\\.\\-\\h]");
				StringBuilder date = new StringBuilder(dateSections[0]);
				if (dateSections.length == 1) {	// user entered only numbers, no slashes or other separators
					date.insert(2, '/');		// inserts '/' after month group (1st 2 digits)
					date.insert(5, '/');		// inserts '/' after day group (next 2 digits)
				}
				else for (int i = 1; i < dateSections.length; i++) {
					// Removed existing separators via String.split above; now replace them w/ '-'
					date.append("/" + dateSections[i]);
				}
				String formattedDate = date.toString();
				return formattedDate;
			}
		}
		// 3. Method to validate dateHired input (only digits + optional slashes, dashes, dots, commas, and/or whitespace)
		public static String validateDateString(String userInput, Scanner scan) {
			final String ERROR_MESSAGE = "Error: invalid input.\nPlease enter the date of hire in the format mm/dd/yyyy: ";
			String tempInput = userInput;	// tempInput initially refers to userInput argument
	      	
	      	while (!tempInput.matches("\\d\\d[/,\\.\\-\\h]?\\d\\d[/,\\.\\-\\h]?\\d\\d\\d\\d")) {
	      		System.out.print(ERROR_MESSAGE);
	      		tempInput = scan.nextLine();
	      	}
	      	return formatDate(tempInput);
		}	// end method validateDate
		
		// 4. Method to validate that user has entered an integer, e.g. for main menu choice or int attributes of child classes
		public static int validateIntInput(String userInput, Scanner scan) {
	      	final String ERROR_NON_NUMERIC_INPUT = "Error: non-numeric input. Please enter a whole number: ";

	      	String tempInput = userInput;	// tempInput initially refers to userInput argument
	      	while (tempInput.matches("\\D+")) {
	      		System.out.print(ERROR_NON_NUMERIC_INPUT);
	      		tempInput = scan.nextLine();
	      	}
	      	return Integer.parseInt(tempInput);
		}	// end method validateIntInput

}	// end Employee class


