import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {

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

            // Update data
            String query = "UPDATE student " +
                    "SET age = 21, course = 'IT' " +
                    "WHERE id = 1";

            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("No record found with ID 1.");
            }

            // Close resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}