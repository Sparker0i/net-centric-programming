<%--
  Created by IntelliJ IDEA.
  User: sparker0i
  Date: 21/9/18
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="connection.DatabaseConnection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: sparker0i
  Date: 21/9/18
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Annie Use Your Telescope' rel='stylesheet'>
    <title>
        OYO Car- The world's leading store for car rentals
    </title>
    <script>
        function showList() {
            var x = document.getElementById('carlist');
            x['style']['visibility'] = 'visible';
            var arr = x.getElementsByTagName('tr');
            var l = arr.length;
            var i = 0;
            var c1 = "#ffc7c7";
            var c2 = "#fbd7d5";

            for (i = 1; i < l; i++) {
                if (i % 2 === 1) {
                    arr[i]['style']['background-color'] = c1;
                }
                else if (i % 2 === 0) {
                    arr[i]['style']['background-color'] = c2;
                }
            }

            var set;
            set = arr[1].getElementsByTagName('td');
            var budget = document.getElementById('budget').value;
            var limit1 = 0;
            var limit2 = 0;
            if (budget == '0') {
                limit1 = -1;
                limit2 = -1;
                x['style']['visibility'] = 'hidden';
                document.getElementById('error_message').innerHTML = "*select a value for namesake";
            }
            else if (budget == '10000') {
                limit1 = 0;
                limit2 = 10000;
            }
            else if (budget == '20000') {
                limit1 = 10001;
                limit2 = 20000;
            }
            else if (budget == '50000') {
                limit1 = 20001;
                limit2 = 50000;
            }
            else if (budget == 'inf') {
                limit1 = 50001;
                limit2 = 1000000;
            }


        };
    </script>
</head>
<body>
<!--for font style reference:https://www.w3schools.com/howto/howto_google_fonts.asp -->
<!--for colour codes:https://htmlcolorcodes.com/ -->
<div style="width: 100%; height:30px; background-color:brown; font-size:22px; color:white; font-family:Annie Use Your Telescope;">
    <h2>
        <center> OYO Car</center>
    </h2>
</div>
<br>
<form>
    <fieldset
            style="border-left:10px solid brown; border-right:10px solid brown; border-top:3px solid brown; border-bottom:3px solid brown; border-radius:10px;">
        <legend style="color:red;"><i> Cars for rent </i></legend>
        Start Date
        <input type="date">
        End Date
        <input type="date">
        <select name="budget" id="budget">
            <option value="0" selected>--Choose a budget--</option>
            <option value="10000"> 0 - 10,000</option>
            <option value="20000"> 10,001 - 20,000</option>
            <option value="50000"> 20,001 - 50,000</option>
            <option value="inf"> 50,001 +</option>
        </select>
        <button type="button" onclick="showList()" style="background-color:brown; color:white; border-style:none;"> Go
        </button>
        <br>
        <p id="error_message" style="color:red; font-style:italic; font-size:13px;"></p>
    </fieldset>
    <table id="carlist" style="visibility:hidden; width:99%; font-size:20px;">
        <tr style="background-color:brown; color:white;">
            <th> Car Name</th>
            <th> Rent per Day</th>
            <th> Specs</th>
        </tr>
        <tr>
            <td> Honda City</td>
            <td> 18000</td>
            <td> AC, Automatic transmission</td>
        </tr>
        <tr>
            <td> Maruti Suzuki 800</td>
            <td> 5000</td>
            <td> Great Mileage</td>
        </tr>
        <tr>
            <td> Maruti Suzuki Alto 800</td>
            <td> 7000</td>
            <td> AC,Great Milege,FM</td>
        </tr>
        <tr>
            <td> Hyundai i10</td>
            <td> 7750</td>
            <td> AC, Sunroof, Leather Seats, Automatic Transmission</td>
        </tr>
        <tr>
            <td> Mercedes S-class</td>
            <td> 33500</td>
            <td> AC, Sunroof, Leather Seats, Automatic Transmission, Luxury Car</td>
        </tr>
        <tr>
            <td> BMW 7-series</td>
            <td> 35000</td>
            <td> AC, Luxury Car, Leather Seat, Automatic Transmission</td>
        </tr>
        <tr>
            <td> Lamborghini Gallardo</td>
            <td> 55000</td>
            <td> AC, Stylish, Very Fast, Nitro Boost, Automatic Transmission, Leather Seats</td>
        </tr>
        <tr>
            <td> Rolls-Royce Phantom</td>
            <td> 115000</td>
            <td> AC, Luxury Car, Leather Seat, Automatic Transmission, Leather Seats, Swimming Pool</td>
        </tr>
        <tr>
            <td> Datsun Go</td>
            <td> 6000</td>
            <td> AC, Great Mileage</td>
        </tr>
        <tr>
            <td>Maruti Suzuki Swift</td>
            <td> 8000</td>
            <td> AC, Great Mileage, FM</td>
        </tr>
        <tr>
            <td>Maruti Suzuki Swift Dzire</td>
            <td> 11000</td>
            <td> AC, Great Mileage, Music System</td>
        </tr>
        <tr>
            <td>Hyundai i20</td>
            <td> 9500</td>
            <td> AC, Great Mileage, Music System, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Honda Jazz</td>
            <td> 9000</td>
            <td> AC, Great Mileage, Music System</td>
        </tr>
        <tr>
            <td>Maruti Suzuki Ciaz</td>
            <td> 17500</td>
            <td> AC, Music System,Leather Seats</td>
        </tr>
        <tr>
            <td> Nissan Micra</td>
            <td> 7000</td>
            <td> AC, Great Mileage, FM</td>
        </tr>
        <tr>
            <td>Hyundai Verna</td>
            <td> 18500</td>
            <td> AC, Automatic Transmission, Leather seats</td>
        </tr>
        <tr>
            <td>Skoda Rapid</td>
            <td> 16000</td>
            <td> AC, Leather Seats, Music System, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Fiat Punto</td>
            <td> 8500</td>
            <td> AC, Music System</td>
        </tr>
        <tr>
            <td>BMW 5-series</td>
            <td> 27500</td>
            <td> AC, Luxury Car, Leather Seats, Sunroof, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Skoda Superb</td>
            <td> 22500</td>
            <td> AC, Music System,Leather Seats, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Mahindra Scorpio</td>
            <td> 19000</td>
            <td> AC, Music System,Leather Seats, Automatic Transmission, 8-seater</td>
        </tr>
        <tr>
            <td>Toyota Innova</td>
            <td> 20000</td>
            <td> AC, Leather Seats, Music System, Automatic Transmission,8-seater</td>
        </tr>
        <tr>
            <td>Fiat Linea</td>
            <td> 17000</td>
            <td> AC, Music System, Leather Seats</td>
        </tr>
        <tr>
            <td>BMW 3-series</td>
            <td> 25000</td>
            <td> AC, Luxury Car, Leather Seats, Sunroof, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Volkswagon Passat</td>
            <td> 22000</td>
            <td> AC, Music System,Leather Seats, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Honda Civic</td>
            <td> 20000</td>
            <td> AC, Music System,Leather Seats, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Lamborghini Murcielago</td>
            <td> 87000</td>
            <td> AC, Automatic Transmission,Nitro Boost</td>
        </tr>
        <tr>
            <td>Volkswagon Polo</td>
            <td> 8000</td>
            <td> AC, Music System</td>
        </tr>
        <tr>
            <td>Volkswagon Vento</td>
            <td> 11000</td>
            <td> AC, Music System, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Tata Tiago</td>
            <td> 7500</td>
            <td> AC, Leather Seats, Music System, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Volkswagon Beetle</td>
            <td> 22000</td>
            <td> AC, Music System, Leather Seats, Vintage Style, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Mini Cooper</td>
            <td> 23000</td>
            <td> AC, Music System, Leather Seats, Automatic Transmission</td>
        </tr>
        <tr>
            <td>Toyota LandCruiser</td>
            <td> 32000</td>
            <td> AC, Music System,Leather Seats, Automatic Transmission, 6-seater, Sunroof</td>
        </tr>
        <tr>
            <td>Bugatti Veyron</td>
            <td> 80000</td>
            <td> AC, Nitro Boost, Automatic Transmission</td>
        </tr>
        <tr>
            <td> Dragon</td>
            <td> 105000</td>
            <td> Can fly, Breathes fire and mist, Has scales, Very awesome</td>
        </tr>
    </table>
</form>
<%
    try {
        Connection connection = DatabaseConnection.getConnection();
        String SQL = "SELECT * FROM Car";
        PreparedStatement statement = connection.prepareStatement(SQL);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(
                    resultSet.getString("NAME") + " " +
                            resultSet.getFloat("PRICE") + " " +
                            resultSet.getString("FEATURES"));
        }
    }
    catch (Exception ex) {
        ex.printStackTrace();
    }
    DatabaseConnection.disconnect();
%>
</body>
</html>
