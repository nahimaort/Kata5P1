package kata5;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTable {
    
    public static void createNewTable() {
        String url = "jdbc:sqlite:mail.db";
        
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT, \n"
                + " Mail text NOT NULL) ;";
        
        try (Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tabla creada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
