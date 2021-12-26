package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
    private Connection connect() {
        String url = "jdbc:sqlite:KATA5.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return connection;
    }
    public void selectAll() {
        String sql = "SELECT * FROM PEOPLE";
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t" +
                        rs.getString("Nombre") + "\t" +
                        rs.getString("Apellidos") + "\t" +
                        rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
