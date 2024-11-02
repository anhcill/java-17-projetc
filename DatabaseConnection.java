import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/usermanagementdb";
    private static final String USER = "root"; // Thay 'your_username' bằng tên đăng nhập thực tế của bạn
    private static final String PASSWORD = "123456789"; // Thay 'your_password' bằng mật khẩu thực tế của bạn

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
        return connection;
    }
}
