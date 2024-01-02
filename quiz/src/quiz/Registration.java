package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Registration {
	String Name;
	String Emailid;
	String Password;
	boolean usertype;
	
	
	Scanner sc = new Scanner(System.in);
	public void registers() throws Exception {
		
		
		System.out.println("Enter Name");
		Name=sc.next();
		
		System.out.println("Enter Emailid");
		Emailid=sc.next();
		
		System.out.println("Enter Password");
		Password=sc.next();
		
		System.out.println("enter the type of user\nenter 'true' for admin\ntenter 'false' for student ");
		usertype=sc.nextBoolean();
		if(usertype==true)
			System.out.println(" admin registered successfully");
		else if(usertype==false)
			System.out.println(" Student registered successfully ");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
	}
		//public void usertype() {
			//boolean admin = true;
			//boolean student=false;
			//if(admin==true) {
				//System.out.println("admin registered successfully");
				//}
			//else if(student==false) {
				//System.out.println("Student registered successfully");
			//}
		
		
		Connection conn=null;
		
		String dbURL = "jdbc:mysql://localhost:3306/quiz";
		String username="root";
		String password="Surekha@111";
		
		try {
			conn=DriverManager.getConnection(dbURL,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query1="insert into registration(name,email,password,usertype) values(?,?,?,?)";
		
		 try(PreparedStatement preparedStatement=conn.prepareStatement(query1)) {
			
				preparedStatement.setString(1, Name);
				preparedStatement.setString(2, Emailid);
				preparedStatement.setString(3, Password);
				preparedStatement.setBoolean(4, usertype);
				
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
		}
	}



