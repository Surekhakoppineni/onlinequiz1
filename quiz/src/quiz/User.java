package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
	public void user(String email)  throws SQLException, IOException {
		//connection
		Connections obj=new Connections();
		Connection connection=obj.reg();
		int score=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean loop=true;
		while(loop) {
		System.out.println("select option\n1.participate quiz\n2.LeaderBoard\n3.Feedback\n4.Mock Test\n5.exit");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		String category = null;
		switch(option) {
		case 1:
			ParticipateQuiz objj=new ParticipateQuiz();
			objj.participateQuiz(email);
			break;
		
            	
		case 2:
			LeaderBoard obj2=new LeaderBoard();
			obj2.leaderboard(score);
			break;
			
		case 3:
			Feedback obj3=new Feedback();
			obj3.takeFeedback();
			break;
		case 4:
			CustomizationOptions obj4=new CustomizationOptions();
			obj4.video();
			break;
			
		case 5:
            System.out.println("*** Thanks for using ***");
            System.out.println("*** Logged out successfully ***");
            loop = false;
            break;
		}
		}
	}

	}
	
	


