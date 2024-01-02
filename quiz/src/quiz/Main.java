package quiz;

import java.util.Scanner;


public class Main {
	static Scanner d=new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		System.out.println("Enter 1 for Registration");
		System.out.println("Enter 2  to  Login");
		System.out.println("Enter 3  to Exit");
		
	
		int choice=d.nextInt();
		switch(choice) {
		case 1:
			Registration reg=new Registration();
			reg.registers();
		case 2:
			Login log=new Login();
			log.logins();
			break;
		case 3:
			System.exit(0);
			System.out.println("you are loggedout");
		default:
			System.out.println("select any option to performance");
			//System.out.println("Enter 1 for Registration");
			//System.out.println("Enter 2  to  Login");
			//System.out.println("Enter 3  to Exit");
			//Main obj=new Main();
			Main.main(args);
			
			
			}

}
}
