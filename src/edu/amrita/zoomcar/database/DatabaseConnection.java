package edu.amrita.zoomcar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private static String URL = "jdbc:mysql://localhost:3306/ZoomCar?useSSL=false" , USER = "root" , PASS = "root";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
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
