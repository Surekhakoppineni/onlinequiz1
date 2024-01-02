package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Feedback {
    public static void takeFeedback() throws IOException {
            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //System.out.println("Thank you for partcipicating in quiz..!");
            System.out.println("Please provide your feedback:");
            int rating;
            do
            {
                System.out.println("Enter your feedback rating (1 to 5):");
                rating = scanner.nextInt();
                if (rating < 1 || rating > 5)
                {
                   System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
                }

            } while (rating < 1 || rating > 5);

            System.out.println("Thank you for your feedback! You entered a rating of " + rating);
            System.out.print("Comments: ");
            String comments = reader.readLine();
            System.out.println(comments); 
            System.out.println("Feedback received.Thank you!");
        }
}


