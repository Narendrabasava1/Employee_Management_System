package Employee_management_System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee";

    private static final String USER = "root";

    private static final String PASSWORD = "Your_Password";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
