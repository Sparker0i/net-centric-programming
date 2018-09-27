package edu.amrita.zoomcar.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import edu.amrita.zoomcar.beans.Car;
import edu.amrita.zoomcar.beans.User;

public class DBUtils {
    public static List<Car> getCars(Connection connection) throws SQLException {
        String SQL = "SELECT * FROM CAR";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Car> list = new ArrayList<>();
        while (resultSet.next()) {
            Car car = new Car();
            
            car.setCarId(resultSet.getInt(Car.CAR_ID));
            car.setCostPerDay(resultSet.getFloat(Car.COST_PER_DAY));
            car.setNumberPlate(resultSet.getString(Car.NUMBER_PLATE));
            car.setAc(resultSet.getBoolean(Car.AC));
            car.setCarType(resultSet.getString(Car.CAR_TYPE));
            car.setColor(resultSet.getString(Car.COLOR));
            car.setCompany(resultSet.getString(Car.COMPANY));
            car.setFuelType(resultSet.getString(Car.FUEL_TYPE));
            car.setLeatherSeats(resultSet.getBoolean(Car.LEATHER_SEATS));
            car.setModel(resultSet.getString(Car.MODEL));
            car.setVersion(resultSet.getString(Car.VERSION));
            car.setSunroof(resultSet.getBoolean(Car.SUNROOF));
            car.setGearType(resultSet.getString(Car.GEAR_TYPE));

            list.add(car);
        }
        return list;
    }

    public static Car getCar(Connection connection , Integer code) throws SQLException {
        String SQL = String.format("SELECT * FROM CAR WHERE %s = ?" , Car.CAR_ID);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1 , code);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Car car = new Car();
            
            car.setCarId(resultSet.getInt(Car.CAR_ID));
            car.setCostPerDay(resultSet.getFloat(Car.COST_PER_DAY));
            car.setNumberPlate(resultSet.getString(Car.NUMBER_PLATE));
            car.setAc(resultSet.getBoolean(Car.AC));
            car.setCarType(resultSet.getString(Car.CAR_TYPE));
            car.setColor(resultSet.getString(Car.COLOR));
            car.setCompany(resultSet.getString(Car.COMPANY));
            car.setFuelType(resultSet.getString(Car.FUEL_TYPE));
            car.setLeatherSeats(resultSet.getBoolean(Car.LEATHER_SEATS));
            car.setModel(resultSet.getString(Car.MODEL));
            car.setVersion(resultSet.getString(Car.VERSION));
            car.setSunroof(resultSet.getBoolean(Car.SUNROOF));
            car.setGearType(resultSet.getString(Car.GEAR_TYPE));

            return car;
        }
        return null;
    }

    public static User findUser(Connection connection , String name) throws SQLException {
    	String SQL = String.format("SELECT * FROM USER WHERE %s = ?" , User.USER_ID);
    	
    	PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1 , name);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setUserId(resultSet.getString(User.USER_ID));
            user.setPassword(resultSet.getString(User.PASSWORD));
            user.setDob(convertToUtil(resultSet.getTimestamp(User.DOB)));
            user.setEmail(resultSet.getString(User.E_MAIL));
            user.setPhone(resultSet.getString(User.PHONE));
            user.setGender(resultSet.getString(User.GENDER));
            user.setUserName(resultSet.getString(User.USER_NAME));
            return user;
        }
        return null;
    }
    
    public static User findUser(Connection connection , String name , String password) throws SQLException {
    	String SQL = String.format("SELECT * FROM USER WHERE %s = ? AND %s = ?" , User.USER_ID , User.PASSWORD);
    	
    	PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1 , name);
        preparedStatement.setString(2 , password);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setUserId(resultSet.getString(User.USER_ID));
            user.setPassword(resultSet.getString(User.PASSWORD));
            user.setDob(convertToUtil(resultSet.getTimestamp(User.DOB)));
            user.setEmail(resultSet.getString(User.E_MAIL));
            user.setPhone(resultSet.getString(User.PHONE));
            user.setGender(resultSet.getString(User.GENDER));
            user.setUserName(resultSet.getString(User.USER_NAME));
            return user;
        }
        return null;
    }
    
    public static void insertUser(Connection connection , User user) throws SQLException {
    	String SQL = String.format("INSERT INTO USER(%s , %s , %s , %s , %s , %s , %s) VALUES (? , ? , ? , ? , ? , ? , ?)" ,
    			User.USER_ID,
    			User.USER_NAME,
    			User.PASSWORD,
    			User.DOB,
    			User.E_MAIL,
    			User.GENDER,
    			User.PHONE);
    	
    	PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    	preparedStatement.setString(1, user.getUserId());
    	preparedStatement.setString(2, user.getUserName());
    	preparedStatement.setString(3, user.getPassword());
    	preparedStatement.setTimestamp(4, convertToSQL(user.getDob()));
    	preparedStatement.setString(5, user.getEmail());
    	preparedStatement.setString(6, user.getGender());
    	preparedStatement.setString(7, user.getPhone());
    	
    	preparedStatement.executeUpdate();
    }
    
    public static Timestamp convertToSQL(java.util.Date date) {
    	return new Timestamp(date.getTime());
    }
    
    public static java.util.Date convertToUtil(Timestamp date) {
    	return new Date(date.getTime());
    }
}
