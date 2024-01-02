package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	public Connection reg() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Surekha@111");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}