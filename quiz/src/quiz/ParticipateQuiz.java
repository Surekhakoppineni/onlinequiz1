package quiz;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class ParticipateQuiz {
    private static final int TIME_LIMIT_SECONDS = 200; // 1 minutes

    public void participateQuiz(String email) throws SQLException, IOException {
        // Connection
        Connections obj = new Connections();
        Connection connection = obj.reg();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String category = null;
        int score = 0;

        // Choose quiz category
        System.out.println("********* Participate in the quiz ********");
        System.out.println("Select your category to participate in a quiz");
        System.out.println("Enter 1 for the Java Quiz");
        System.out.println("Enter 2 for Python Quiz");
        System.out.println("Enter 3 for JavaScript Quiz");
        System.out.println("Enter 4 for CPP Quiz");
        System.out.println("-----------------------");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();

        switch (select) {
            case 1:
                System.out.println("You choosed Java quiz to participate");
                category = "java";
                break;
            case 2:
                System.out.println("You choosed Python quiz to participate");
                category = "python";
                break;
            case 3:
                System.out.println("You choosed JavaScript quiz to participate");
                category = "javascript";
                break;
            case 4:
                System.out.println("You choosed CPP quiz to participate");
                category = "cpp";
                break;
        }

        // Fetch quiz questions
        String data = "SELECT * FROM admin WHERE category = ? ORDER BY RAND() LIMIT 10";
        PreparedStatement ps = connection.prepareStatement(data);
        ps.setString(1, category);
        ResultSet rs = ps.executeQuery();

        // Set up timer
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int secondsPassed = 0;

            @Override
            public void run() {
                secondsPassed++;
                if (secondsPassed >= TIME_LIMIT_SECONDS) {
                    System.out.println("Time's up! Quiz participation completed.");
                    timer.cancel(); // Stop the timer
                    try {
                        connection.close(); // Close the database connection
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.exit(0); // Terminate the program
                }
            }
        };
        

        // Schedule the timer to run every second
        timer.scheduleAtFixedRate(task, 1000, 1000);
       // Quiz participation
        int questionNo = 1;
        while (rs.next()) {
            System.out.println("Answer the following questions");
            System.out.print(questionNo + ". ");
            System.out.println(rs.getString("question"));

            if ("mcq".equals(rs.getString("questiontype"))) {
                System.out.println("Options are:");
                System.out.println("A. " + rs.getString("A"));
                System.out.println("B. " + rs.getString("B"));
                System.out.println("C. " + rs.getString("C"));
                System.out.println("D. " + rs.getString("D"));
            }

            String userAns = reader.readLine().toLowerCase();

            if (userAns.equals(rs.getString("answer").toLowerCase())) {
                System.out.println("Answer is correct");
                System.out.println(rs.getString("explanation"));
                score += 1;
            } else {
                System.out.println("Wrong answer");
                System.out.println("Correct answer is " + rs.getString("answer"));
                System.out.println(rs.getString("explanation"));
            }
            questionNo++;
        }

        // Quiz completion
        timer.cancel(); // Stop the timer

        // Insert user's performance into the database
        System.out.println("Your score is " + score);
        String user = "INSERT INTO user VALUES (?, ?, ?);";
        PreparedStatement ps1 = connection.prepareStatement(user);
        ps1.setString(1, email);
        ps1.setString(2, category);
        ps1.setInt(3, score);
        ps1.executeUpdate();

        // Progress tracking
        System.out.println("Enter 1 to see your performance");
        System.out.println("Enter 2 to exit ");

        int input = sc.nextInt();
        if (input == 1) {
            if (score == 0) {
                System.out.println("Your performance is Zero");
            } else if (score == 1) {
                System.out.println("Your performance is Poor");
            } else if (score == 2) {
                System.out.println("Your performance is Below Average");
            } else if (score == 3) {
                System.out.println("Your performance is Average");
            } else if (score == 4) {
                System.out.println("Your performance is Good");
            } else if (score == 5) {
                System.out.println("Your performance is Excellent");
            }
        } else if (input == 2) {
            System.out.println("Your quiz is done");
        }

        // Close resources
        connection.close();
    }
}
