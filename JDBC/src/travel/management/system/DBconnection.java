package travel.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/proj";  // Ensure the database name is 'proj'
    private static final String USER = "root";  // Your MySQL username
    private static final String PASSWORD = "your_password";  // Your MySQL password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
