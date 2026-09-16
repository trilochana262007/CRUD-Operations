import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "MySql@123";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement stmt = con.createStatement();

            // Insert data
            String query = "INSERT INTO student VALUES " +
                    "(1, 'Ravi', 20, 'CSE')";

            stmt.executeUpdate(query);

            System.out.println("Data inserted successfully!");

            // Close resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}