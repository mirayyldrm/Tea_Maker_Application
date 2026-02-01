import java.sql.*;
public class DatabaseHelper {
    private static DatabaseHelper uniqueInstance;
    private static final String URL = "jdbc:mysql://localhost:3306/tea_maker_db";
    private static final String USER = "root";
    private static final String PASSWORD ="yeniSifre123.";
    private DatabaseHelper(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static synchronized DatabaseHelper getInstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new DatabaseHelper();
        }
        return uniqueInstance;
    }
    public void logTea(int cups){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO tea_logs (num_cups, log_date) VALUES (?, NOW())")) {
            stmt.setInt(1, cups);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getDailyCups(){
        int total = 0;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT SUM(num_cups) FROM tea_logs WHERE DATE(log_date) = CURDATE()")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public int getMonthlyCups(){
        int total = 0;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT SUM(num_cups) FROM tea_logs WHERE MONTH(log_date) = MONTH(CURRENT_DATE()) AND YEAR(log_date) = YEAR(CURRENT_DATE())")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

}
