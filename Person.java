/*
 * Class: CMSC201 
 * Instructor: Dr. Grinberg
 * Description: Person class for setting name, address, phoneNumber, & email fields
 *              of all subclass instances; superclass to Student & Employee
 * Due: 07/15/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Nora Temkin
*/

import java.util.Scanner;

public class Person {
	final static String PHONE_PATTERN = "\\d{3}-\\d{3}-\\d{4}";
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String email;
	
	// Constructors
	public Person() {
		this.name = "Anon Y. Mous";
		this.address = "123 Any St., Somewhereville, MD, 12345";
		this.phoneNumber = "555-123-4567";
		this.email = this.name + "@agreatschool.edu";
	}
	
	public Person(String name, String address, String phoneNumber, String email) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Other methods
	// 1. Method to set values of class data fields from user input via keyboard
	public void initializeFieldsFromKeyboard(Scanner scan) {
		final String NAME_PROMPT = "Please enter a name: ";
				
		// Display prompt for user to enter Person's name
		System.out.print(NAME_PROMPT);
		// Get user input & use it to set Person's name
		this.name = scan.nextLine();
		
		// Personalize additional user prompts w/ Person's name
		String addressPrompt = "Enter " + this.name + "'s address: ";
		String phoneNumberPrompt = "Enter " + this.name + "'s phone number: ";
		String emailPrompt = "Enter " + this.name + "'s email: ";
		
		// Display prompt for user to enter Person's address
		System.out.print(addressPrompt);
		// Get user input & use it to set Person's address
		this.address = scan.nextLine();
		
		// Display prompt for user to enter Person's phone number
		System.out.print(phoneNumberPrompt);
		// Get user input & use it to set Person's phone number after validating input & formatting it (if necessary)
		this.phoneNumber = (validatePhoneNumber(scan.nextLine(), scan));
		
		// Display prompt for user to enter Person's email
		System.out.print(emailPrompt);
		// Get user input & use it to set Person's email
		this.email = scan.nextLine();
	}	// end method initializeFieldsFromKeyboard
	
	// 2. Method to format phoneNumber as xxx-xxx-xxxx
	public static String formatPhoneNumber(String rawPhoneNumber) {
		// NOTE: method assumes input = a String of 10 digits, w/ or w/o separators, from calling method validatePhoneNumber
		if (rawPhoneNumber.matches(PHONE_PATTERN))	// user entered phoneNumber in correct format
			return rawPhoneNumber;
		else {											// user entered phoneNumber in incorrect format; reformat it
			String[] phoneNumberSections = rawPhoneNumber.split("[\\),\\.\\- ] *");
			StringBuilder phoneNumber = new StringBuilder(phoneNumberSections[0]);
			if (phoneNumberSections.length == 1) {	// user entered only numbers, no dashes to separate them
				phoneNumber.insert(3, '-');		// inserts '-' after 1st 3 digits
				phoneNumber.insert(7, '-');		// inserts '-' after 2nd group of 3 digits
			}
			else for (int i = 1; i < phoneNumberSections.length; i++) {
				// Removed existing separators via String.split above; now replace them w/ '-'
				phoneNumber.append("-" + phoneNumberSections[i]);
			}
			// if user entered phone # in format (xxx)xxx-xxxx, delete leading '(' character
			if (phoneNumber.charAt(0) == '(')	
				phoneNumber.deleteCharAt(0);
			
			String formattedPhoneNumber = phoneNumber.toString();
			return formattedPhoneNumber;
		}
	}
	// 3. Method to validate phone number input (only digits + optional parentheses, dashes, dots, commas, and/or whitespace)
	public static String validatePhoneNumber(String userInput, Scanner scan) {
		final String ERROR_MESSAGE = "Error: invalid input.\n" +
	                                 "Please enter a 10-digit phone number in the format 123-456-7890: ";
		String tempInput = userInput;	// tempInput initially refers to userInput argument
      	
      	while (!tempInput.matches("\\(?\\d{3}[\\),\\.\\- ]? *\\d{3}[\\),\\.\\- ]?\\d{4}")) {
      		System.out.print(ERROR_MESSAGE);
      		tempInput = scan.nextLine();
      	}
      	return formatPhoneNumber(tempInput);
	}	// end method validatePhoneNumber
	
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
}
