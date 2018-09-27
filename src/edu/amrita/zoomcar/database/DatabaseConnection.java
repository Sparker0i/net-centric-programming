package edu.amrita.zoomcar.database;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletContext;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static JSONParser jsonParser;

    private static String URL, USER, PASS;

    private static void getCredentials(ServletContext context) {
        if (jsonParser == null)
            jsonParser = new JSONParser();
        try {
            InputStream input = context.getResourceAsStream("/WEB-INF/db.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            Object object = jsonParser.parse(reader);

            JSONObject credentials = (JSONObject) object;

            URL = "jdbc:mysql://localhost:3306/ZoomCar?useSSL=false";
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
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                getCredentials(context);
                connection = DriverManager.getConnection(URL, USER, PASS);
                return connection;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return connection;
        }
        else
            return connection;
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
