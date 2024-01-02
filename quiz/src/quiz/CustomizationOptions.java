package quiz;
import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class CustomizationOptions {
    public void video() {
        // Connection
        Connections obj = new Connections();
        Connection connection = obj.reg(); 
              Scanner sc = new Scanner(System.in);
              //Scanner sc = new Scanner(System.in);

              System.out.println("Participate in the online mock test");
              System.out.println("Select your category to participate in the mock test");
              System.out.println("Enter 1 for the Java mock test");
              System.out.println("Enter 2 for the Python mock test");
              System.out.println("Enter 3 for the JavaScript mock test");
              System.out.println("Enter 4 for the CPP mock test");

              int option = sc.nextInt();

              switch (option) {
                  case 1:
                      System.out.println("You choosed the Java mock test.");
                      openLink("https://www.w3schools.com/quiztest/quiztest.asp?qtest=JAVA");
                      
                      break;
                  case 2:
                      System.out.println("You choosed the Python mock test.");
                      openLink("https://www.w3schools.com/quiztest/quiztest.asp?qtest=PYTHON");
                     
                      break;
                  case 3:
                      System.out.println("You choosed the JavaScript mock test.");
                      openLink("https://www.w3schools.com/quiztest/quiztest.asp?qtest=JS");
                      
                      break;
                  case 4:
                      System.out.println("You choosed the C programming mock test.");
                      openLink("https://www.w3schools.com/quiztest/quiztest.asp?qtest=CPP");
                      
                      break;
                  default:
                      System.out.println("Invalid option. Please choose a valid option.");
              }
          }

          private static void openLink(String link) {
              try {
                  Desktop.getDesktop().browse(new URI(link));
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      }


