package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class InsertData {
    private Connection connect() {
        String url = "jdbc:sqlite:mail.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    public void insert(String email) {
        String sql = "INSERT INTO EMAIL(Mail) VALUES(?)";
        try (Connection connection = this.connect();
                PreparedStatement pstatement = connection.prepareStatement(sql)) {
            pstatement.setString(1, email);
            pstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
