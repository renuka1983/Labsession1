package labsession;
//Email Generator
import java.util.Scanner;

class EmailGenerator {

	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private int defaultpasswordlength = 8;
	private String companySuffix = "xyz.com";
	private String email;

	//Constructor to receive first and last name
	public EmailGenerator(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Welcome "+ firstName +" "+ lastName);
		
		this.department = setDepartment();

		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;

		this.password = getPassword(defaultpasswordlength);

	}
	//Get the department 
	private String setDepartment() {
		System.out.println("Deaprtment codes:\n1 for Technical \n2 for Admin \n3 for HumanResources \n4 Legal \n0 for none\nEnter department code:");
		Scanner sc = new Scanner(System.in);
		int depchoice = sc.nextInt();
		if(depchoice == 1) {
			return "tech";
		}
		else if(depchoice == 2) {
			return "admin";
		}
		else if(depchoice == 3) {
			return "hr";
		}
		else if(depchoice == 4) {
			return "legal";
		}
		else {
			return " ";
		}
	}
	//Generate a password
	private String getPassword(int length) {
		String passwordset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890~!@#$%^&*";
		char[] password = new char[length];
		for(int i = 0; i<length; i++) {
			int rand = (int)(Math.random()* passwordset.length());
			password [i] = passwordset.charAt(rand);
		}
		return new String (password);
	}
	public void showInfo(){
		System.out.println("Welcome "+ firstName +" "+ lastName);
		
		System.out.println("Your Email ID is:"+ email);

		System.out.println("Your password is:" + this.password);

		System.out.println("Department:" + this.department);
	}
}
class CredentialServices {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please,Enter your first name:");
		String fName = sc.next();
		System.out.println("Please,Enter your last name:");
		String lName = sc.next();
		
		EmailGenerator email = new EmailGenerator(fName,lName);
		email.showInfo();
	}
} 