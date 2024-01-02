package quiz;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Admin {
	public void admin(String email) throws SQLException, IOException {
		//connection
		Connections obj=new Connections();
		Connection connection=obj.reg();
		boolean loop=true;
		while(loop) {
		System.out.println("select option\n1.create the quiz\n2.feedback\n3.exit");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option) {
		case 1:
		System.out.println("*********create your quiz********");
		System.out.println("select your category to create a quiz");
		System.out.println("Enter 1 for the java Quiz");
		System.out.println("Enter 2 for Python Quiz");
		System.out.println("Enter 3 for JavaScript Quiz");
		System.out.println("Enter 4 for cpp Quiz");
		System.out.println("-----------------------");
		String category = null;
		String questiontype = null;
		String question=null;
		String A=null;
		String B=null;
		String C=null;
		String D=null;
		String answer=null;
		String explanation=null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int select=sc.nextInt();
		switch(select) {
		case 1:
			System.out.println("you choosed java quiz to create ");
			category="java";
			break;
		case 2:
			System.out.println("you choosed python quiz to create");
			category="python";
			break;
		case 3:
			System.out.println("you choosed javascript quiz to create");
			category="javascript";
			break;
		case 4:
			System.out.println("you choosed cpp quiz to create");
			category="cpp";
			break;
		}
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1;i<=5;i++) {
 			//System.out.println("enter question type");
 			System.out.println("1.mcq\t2.fill in blank\t3.true or false");
 			int qt=sc.nextInt();
 			if (qt==1) {
 				
 				String mcqQueary="insert into admin(category,questiontype,question,A,B,C,D,answer,explanation) values(?,?,?,?,?,?,?,?,?);";
 				PreparedStatement ps=connection.prepareStatement(mcqQueary);
 				System.out.println("you choosed mcq");
 				ps.setString(1,category );
 				System.out.println("enter the questiontype");
 				ps.setString(2, reader.readLine());
 				System.out.println("enter the question");
 				ps.setString(3, reader.readLine());
 				System.out.println("---Enter options---");
 				System.out.println("option A");
 				ps.setString(4, reader.readLine());
 				System.out.println("option B");
 				ps.setString(5, reader.readLine());
 				System.out.println("option C");
 				ps.setString(6, reader.readLine());
 				System.out.println("option D");
 				ps.setString(7, reader.readLine());
 				System.out.println("Enter correct option:Answer");
 				ps.setString(8, reader.readLine());
 				System.out.println("Explanation to your answer");
 				ps.setString(9, reader.readLine());
 				ps.executeUpdate();
 				}
			else if(qt==2) {
				//System.out.println("you choosed fill in the blank");
				questiontype="blanks";
			
				System.out.println("you choosed fill in the blank");
				System.out.println("---Enter question---");
				System.out.println("Note:Enter blank as' _____'");
				 question=  reader.readLine();				  
				System.out.println("Enter answer");
				 answer= reader.readLine();	
				System.out.println("Explanation to your answer");
				 explanation= reader.readLine();	
				 String Queary="insert into admin(category,questiontype,question,answer,explanation) values(?,?,?,?,?);";
				 PreparedStatement ps=connection.prepareStatement(Queary);
						ps.setString(1, category);
						ps.setString(2, questiontype);
						ps.setString(3, question);
						ps.setString(4, answer);
						ps.setString(5, explanation);
						ps.executeUpdate();
				}
			else if(qt==3) {
				questiontype="true and false";
		
				System.out.println("you choosed true or false");
			    System.out.println("---Enter question---");
				question=  reader.readLine();	
				System.out.println("Enter answer");
				answer= reader.readLine();	
				System.out.println("Explanation to your answer");
				explanation= reader.readLine();	
			 String Queary="insert into admin(category,questiontype,question,answer,explanation) values(?,?,?,?,?);";
			 PreparedStatement ps=connection.prepareStatement(Queary);
					ps.setString(1, category);
					ps.setString(2, questiontype);
					ps.setString(3, question);
					ps.setString(4, answer);
					ps.setString(5, explanation);
					ps.executeUpdate();
					break;
				
			}}
		case 2:
			Feedback obj1=new Feedback();
			obj1.takeFeedback();
			break;
		 case 3:
             System.out.println("*** Thanks for using ***");
             System.out.println("*** Logged out successfully ***");
             loop = false;
             break;
		}
	}

	}
}
