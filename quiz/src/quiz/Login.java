package quiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Login {
	public void logins() throws SQLException, IOException {
		String email;
	    String password;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Your Email : ");
		email = sc.next();
		System.out.println("Enter Your Password : ");
		password = sc.next();
		//connection
		Connections obj=new Connections();
		Connection connection=obj.reg();
        String query="select * from registration";
		PreparedStatement view=connection.prepareStatement(query);
		int user=1;
		ResultSet rs=view.executeQuery();
		while(rs.next()) {
            if(email.equals(rs.getString("email")) && password.equals(rs.getString("password"))) {
				user=2;
				System.out.println("login successfull");
				boolean usertype=rs.getBoolean("usertype");
				System.out.println(usertype);
				if(usertype==true) {
					Admin a=new Admin();
					a.admin(email);
				}
				else if(usertype==false) {
					User u=new User();
					u.user(email);
				}
				break;
			
            }
		}
            if (user==1) {
				System.out.println("invalid email or password ");
				Login o=new Login();
				o.logins();
				//System.out.println("Enter the correct login id ");
			}
		}
	}