package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaderBoard {
public void leaderboard(int score) throws SQLException {
	//connection
			Connections obj=new Connections();
			Connection connection=obj.reg();
			String leaderboardQuery = "SELECT * FROM user WHERE category = ? ORDER BY score DESC LIMIT 3";
	        PreparedStatement ps = connection.prepareStatement(leaderboardQuery);
	        String[] categories = {"java", "python", "javascript", "cpp"};
	        for (String category : categories) {
	            ps.setString(1, category);
	            ResultSet rs = ps.executeQuery();

	            System.out.println("Top three scores for category " + category + ":");
	            int rank = 1;

	            while (rs.next()) {
	                String userEmail = rs.getString("email");
	                score = rs.getInt("score");

	                System.out.println(rank + ". " + userEmail + " - Score: " + score);
	                rank++;
	            }

	            System.out.println(); // Add a newline between categories
	        }
	    }

			
	
	

}
