/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacbankpoo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Beto
 */
public class ConnectionUtils {
    private static Connection connection = null;
    
    public static Connection getConnection () throws SQLException {
        if(connection == null || connection.isClosed()) {
            String dbURL = "jdbc:derby://localhost:1527/sistemapoo";
            
            Properties properties = new Properties();
            properties.put("user", "root");
            properties.put("password", "root");
            connection = DriverManager.getConnection(dbURL, properties);
        }
        return connection;
    }
}
