package edu.amrita.zoomcar.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletContext;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static JSONParser jsonParser;

    private static String USER, PASS;

    private static void getCredentials(ServletContext context) {
        if (jsonParser == null)
            jsonParser = new JSONParser();
        try {
            InputStream input = context.getResourceAsStream("/WEB-INF/db.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            Object object = jsonParser.parse(reader);

            JSONObject credentials = (JSONObject) object;

            USER = (String) credentials.get("username");
            PASS = (String) credentials.get("password");
        }
        catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(ServletContext context) {
        if (connection == null) {
            try {
                getCredentials(context);
                MysqlDataSource dataSource = getDataSource();
                connection = dataSource.getConnection();
                return connection;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return connection;
        }
        else
            return connection;
    }

    private static MysqlDataSource getDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUseSSL(false);
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("ZoomCar");
        dataSource.setAllowPublicKeyRetrieval(true);
        dataSource.setPortNumber(3306);
        dataSource.setUser(USER);
        dataSource.setPassword(PASS);
        return dataSource;
    }

    public static void disconnect() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void rollback() {
    	try {
    		connection.rollback();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
