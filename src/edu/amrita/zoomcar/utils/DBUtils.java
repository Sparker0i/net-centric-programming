package edu.amrita.zoomcar.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.amrita.zoomcar.beans.Car;
import edu.amrita.zoomcar.beans.CarTransaction;
import edu.amrita.zoomcar.beans.Transaction;
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
            car.setImageUrl(resultSet.getString(Car.IMAGE_URL));
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

    public static Car getCar(Connection connection, Integer code) throws SQLException {
        String SQL = String.format("SELECT * FROM CAR WHERE %s = ?", Car.CAR_ID);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, code);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Car car = new Car();

            car.setCarId(resultSet.getInt(Car.CAR_ID));
            car.setCostPerDay(resultSet.getFloat(Car.COST_PER_DAY));
            car.setImageUrl(resultSet.getString(Car.IMAGE_URL));
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

    public static User findUser(Connection connection, String name) throws SQLException {
        String SQL = String.format("SELECT * FROM USER WHERE %s = ?", User.USER_ID);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();
        return sendUser(resultSet);
    }

    private static User sendUser(ResultSet resultSet) throws SQLException {
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

    public static User findUser(Connection connection, String name, String password) throws SQLException {
        String SQL = String.format("SELECT * FROM USER WHERE %s = ? AND %s = ?", User.USER_ID, User.PASSWORD);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        return sendUser(resultSet);
    }

    public static void insertUser(Connection connection, User user) throws SQLException {
        String SQL = String.format("INSERT INTO USER(%s , %s , %s , %s , %s , %s , %s) VALUES (? , ? , ? , ? , ? , ? , ?)",
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

    public static boolean checkTransactionForRange(Connection connection, Integer carId, java.util.Date startDate, java.util.Date endDate) throws SQLException {
        String SQL = String.format("SELECT * FROM TRANSACTION WHERE %s = ?", Transaction.CAR_ID);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, carId);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            java.util.Date
                    start = convertToUtil(resultSet.getTimestamp(Transaction.START_DATE)),
                    end = convertToUtil(resultSet.getTimestamp(Transaction.END_DATE));

            if (startDate.after(start) && endDate.before(end))
                return false;
            else if (inBetween(startDate, start, end))
                return false;
            else if (inBetween(endDate, start, end))
                return false;
            else if (start.after(startDate) && end.before(endDate))
                return false;
        }
        return true;
    }

    private static boolean inBetween(java.util.Date date, java.util.Date start, java.util.Date end) {
        return date.after(start) && date.before(end);
    }

    public static void insertTransaction(Connection connection, Transaction transaction) throws SQLException {
        String SQL = String.format("INSERT INTO TRANSACTION(%s , %s , %s , %s , %s) VALUES (? , ? , ? , ? , ?)",
                Transaction.USER_ID,
                Transaction.CAR_ID,
                Transaction.START_DATE,
                Transaction.END_DATE,
                Transaction.DATE_OF_REQUEST);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, transaction.getUserId());
        preparedStatement.setInt(2, transaction.getCarId());
        preparedStatement.setTimestamp(3, convertToSQL(transaction.getStartDate()));
        preparedStatement.setTimestamp(4, convertToSQL(transaction.getEndDate()));
        preparedStatement.setTimestamp(5, convertToSQL(transaction.getDateOfRequest()));

        preparedStatement.executeUpdate();
    }

    public static List<CarTransaction> getTransactions(Connection connection, User user) throws SQLException {
        String SQL = String.format("SELECT %s , %s , %s , %s, %s, %s, %s , %s , (%s - %s + 1) * %s AS %s FROM %s,%s WHERE %s=%s AND %s=?",
                CarTransaction.COMPANY,
                CarTransaction.MODEL,
                CarTransaction.VERSION,
                CarTransaction.CAR_ID,
                CarTransaction.DATE_OF_REQUEST,
                CarTransaction.COST_PER_DAY,
                CarTransaction.END_DATE,
                CarTransaction.START_DATE,
                CarTransaction.END_DATE,
                CarTransaction.START_DATE,
                CarTransaction.COST_PER_DAY,
                CarTransaction.COST,
                "CAR",
                "TRANSACTION",
                CarTransaction.CAR_ID,
                CarTransaction.TRANSACTION_CAR_ID,
                CarTransaction.USER_ID);

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, user.getUserId());
        System.out.println(preparedStatement.toString());

        ResultSet resultSet = preparedStatement.executeQuery();
        List<CarTransaction> transactions = new ArrayList<>();
        while (resultSet.next()) {
            CarTransaction transaction = new CarTransaction();

            transaction.setCompany(resultSet.getString(Car.COMPANY));
            transaction.setModel(resultSet.getString(Car.MODEL));
            transaction.setVersion(resultSet.getString(Car.VERSION));
            transaction.setCarId(resultSet.getInt(Car.CAR_ID));
            transaction.setDateOfRequest(convertToUtil(resultSet.getTimestamp(Transaction.DATE_OF_REQUEST)));
            transaction.setStartDate(convertToUtil(resultSet.getTimestamp(Transaction.START_DATE)));
            transaction.setEndDate(convertToUtil(resultSet.getTimestamp(Transaction.END_DATE)));
            transaction.setCostPerDay(resultSet.getDouble(CarTransaction.COST_PER_DAY));
            transaction.setCost(resultSet.getDouble(CarTransaction.COST));

            transactions.add(transaction);
        }
        return transactions;
    }

    private static Timestamp convertToSQL(java.util.Date date) {
        return new Timestamp(date.getTime());
    }

    private static java.util.Date convertToUtil(Timestamp date) {
        return new Date(date.getTime());
    }
}
