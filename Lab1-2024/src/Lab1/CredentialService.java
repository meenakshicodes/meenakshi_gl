package Lab1;

import java.util.Scanner;
import java.util.Random;

class CredentialService extends Employee {
	
	static char[] generatePassword() {
		
		//characters
		String uc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lc = "abcdefghijklmnopqrstuvwxyz";
		String num = "12345667890";
		String spcl_char = "!@#$%^&*()_?/[]";
		String combined = uc + lc + num + spcl_char;
		
		//variables
		Random random = new Random();
		char [] random_password = new char[8];
		
		
		//Setting uc, lc, num, spcl_char
		random_password[0] = uc.charAt(random.nextInt(26));
		random_password[1] = lc.charAt(random.nextInt(26));
		random_password[2] = num.charAt(random.nextInt(10));
		random_password[3] = spcl_char.charAt(random.nextInt(spcl_char.length()));
		
		
		//loop to set the remaining 4 chars
		for(int i = 4; i < 8; i++) {
			random_password[i] = combined.charAt(random.nextInt(combined.length()));
		}
		
		
		//System.out.println(random_password);
		return random_password;
		
	}

	
	public static void main(String[] args) {
		try (Scanner inp = new Scanner(System.in)) {
			Employee emp1 = new Employee(); 
			
			
			System.out.println("***********************");
			System.out.println("Welcome to OAWA");
			System.out.println("***********************");
			System.out.println("Please enter your First Name: ");
			
			emp1.setFirstName(inp.nextLine());
			
			System.out.println("Please enter your Last Name: ");
			
			emp1.setLastName(inp.nextLine());
			
			System.out.println("Please choose your department by entering 1, 2, 3, or 4 ");
			System.out.println("1. Technical ");
			System.out.println("2. Admin ");
			System.out.println("3. Human Resource ");
			System.out.println("4. Legal ");
			
			switch(inp.nextInt()) {
			case 1: 
				emp1.setDepartment("tech");
				break;
			case 2:
				emp1.setDepartment("admin");
				break;
			case 3: 
				emp1.setDepartment("hr");
				break;
			case 4: 
				emp1.setDepartment("legal");
				break;
			}
			
			
			emp1.setEmail(emp1.FirstName.toLowerCase()+emp1.LastName.toLowerCase()+"@" + emp1.getDepartment() + ".abc.com");
			emp1.setPassword(String.valueOf(generatePassword()));


			System.out.println("Dear " + emp1.FirstName + ", your generated credentials are as follows:");
			System.out.println("Email -->" + emp1.getEmail());
			System.out.println("Password --> " + emp1.getPassword());
		}
	
	}
	
}

