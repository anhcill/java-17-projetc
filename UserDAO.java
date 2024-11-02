import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public void addUser(String username, String password, String email, String role) {
        String sql = "INSERT INTO Users (username, password, email, role) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password); // Nên mã hóa mật khẩu trước khi lưu
            statement.setString(3, email);
            statement.setString(4, role);
            statement.executeUpdate();
            System.out.println("Người dùng đã được thêm thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
