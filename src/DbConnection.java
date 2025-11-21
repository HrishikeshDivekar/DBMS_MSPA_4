import java.sql.*;

public class DbConnection{
    static PreparedStatement stmt;
    public static Connection getConnection() {
        String USER = "root",  PASSWORD = "Hrishikesh@2004";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", USER, PASSWORD);
        } catch(Exception e) {
            System.out.println("Connection Failed! Check output console");
        }
        return conn;
    }

}