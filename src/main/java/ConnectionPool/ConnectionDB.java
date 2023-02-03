package ConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

    public static Connection getConnection() throws SQLException {
        try (InputStream input = ConnectionDB.class.getClassLoader().getResourceAsStream("database.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            String url = prop.getProperty("database.url");
            String username = prop.getProperty("database.username");
            String pass = prop.getProperty("database.password");

            return DriverManager.getConnection(url, username, pass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
