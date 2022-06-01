package emailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	private String companySuffix = "company.com";
	private String password;
	private int defaultPasswordLength = 10;
	private int mailboxCapacity = 500;
	private String alternateEmail;

	// constructor to receive the first name and last name
	Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// call a method asking for the department - that return the department
		this.department = setDepartmetn();

		// combine the elements to generate the password
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

		// Call the method that returns a random password
		this.password = RandomPassword(defaultPasswordLength);
		System.out.println("your password is : " + password);

	}

	// Ask for the department
	private String setDepartmetn() {
		System.out.println(
				"New Worker:"+firstName+" Department Code: \n1 for Sales\n2 for Development \n3 for Accounting \n0 for None ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}

	// Generate a random password
	private String RandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQURISTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}

		return new String(password);
	}

	// set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// set the alternate email

	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;

	}

	// change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL : " + email + "\nMAILBOX CAPACITY: "
				+ mailboxCapacity + " mb";
	}
}
