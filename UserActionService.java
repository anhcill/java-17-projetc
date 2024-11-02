import java.util.ArrayList;
import java.util.List;

public class UserActionService {
    private List<User> userList; // Danh sách người dùng

    public UserActionService() {
        userList = new ArrayList<>(); // Khởi tạo danh sách người dùng
    }

    // Phương thức để xử lý quyền truy cập của người dùng
    public void handleUserAccess(UserData userData) {
        switch (userData.userType()) {
            case Admin admin -> grantAdminAccess(admin);
            case Moderator moderator -> grantModeratorAccess(moderator);
            case RegularUser regularUser -> grantRegularUserAccess(regularUser);
            default -> throw new IllegalStateException("Unexpected value: " + userData.userType());
        }
    }

    private void grantAdminAccess(Admin admin) {
        System.out.println(admin.getUsername() + " has full access to the system.");
        System.out.println("Admin privileges: Create/Delete Users, Manage System Settings.");
    }

    private void grantModeratorAccess(Moderator moderator) {
        System.out.println(moderator.getUsername() + " can manage content.");
        System.out.println("Moderator privileges: Edit/Delete Content.");
    }

    private void grantRegularUserAccess(RegularUser regularUser) {
        System.out.println(regularUser.getUsername() + " can view content.");
        System.out.println("User privileges: View Content, Comment.");
    }

    public void deleteUser(String username) {
        User userToDelete = findUserByUsername(username);
        if (userToDelete != null) {
            userList.remove(userToDelete); // Xóa người dùng khỏi danh sách
            System.out.println("User " + username + " deleted successfully.");
        } else {
            System.out.println("Attempt to delete: " + username); // Debugging
            throw new IllegalArgumentException("User not found.");
        }
    }

    private User findUserByUsername(String username) {
        for (User user : userList) {
            // Kiểm tra tên người dùng
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // Không tìm thấy người dùng
    }

    // Thêm phương thức để kiểm tra sự tồn tại của người dùng
    public boolean userExists(String username) {
        // Sử dụng Stream API để kiểm tra
        return userList.stream()
                .anyMatch(user -> user.getUsername().equals(username)); // Trả về true nếu tìm thấy người dùng
    }

    // Thêm phương thức để đăng ký người dùng mới
    public void registerUser(User user) {
        userList.add(user);
        System.out.println("User " + user.getUsername() + " registered successfully."); // Debugging
    }
    public List<User> getUserList() {
        return userList; // Trả về danh sách người dùng
    }
}
// phuong thuc khoi phuc mat khau
