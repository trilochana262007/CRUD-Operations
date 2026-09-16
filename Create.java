import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "MySql@123";

        try {

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            // Create Statement
            Statement stmt = con.createStatement();

            // Create student table
            String query = "CREATE TABLE IF NOT EXISTS student (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT, " +
                    "course VARCHAR(50))";

            // Execute query
            stmt.executeUpdate(query);

            System.out.println("Student table created successfully!");

            // Close resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}