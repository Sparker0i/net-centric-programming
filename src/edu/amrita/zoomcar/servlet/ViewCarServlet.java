package edu.amrita.zoomcar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.amrita.zoomcar.beans.Car;
import edu.amrita.zoomcar.beans.Transaction;
import edu.amrita.zoomcar.beans.User;
import edu.amrita.zoomcar.utils.DBUtils;
import edu.amrita.zoomcar.utils.MyUtils;

@WebServlet(urlPatterns = {"/viewCar" , "/carView"})
public class ViewCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCarServlet() {
		super();
	}

	private String carId;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User loginedUser = MyUtils.getLoggedUser(session);

        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

		Connection connection = MyUtils.getStoredConnection(req);

		carId = req.getParameter(Car.CAR_ID);
		if (carId == null) {
		    carId = (String) req.getAttribute(Car.CAR_ID);
        }
        System.out.println("Car : " + carId);
		Car car = null;
		String errorString = null;

		try {
			car = DBUtils.getCar(connection, Integer.parseInt(carId));
		}
		catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		if (errorString != null) {
            resp.sendRedirect(req.getServletPath() + "/productList");
            return;
        }

		req.setAttribute("errorString", errorString);
        req.setAttribute("car", car);

        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/carView.jsp");
        dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loginedUser = MyUtils.getLoggedUser(session);

        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

		Date from = null , to = null , request = new Date();
		try {
		    from = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fromDate"));
			to = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("toDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		User user = MyUtils.getLoggedUser(req.getSession());
		Connection connection = MyUtils.getStoredConnection(req);
        PrintWriter out = resp.getWriter();
        try {
            if (DBUtils.checkTransactionForRange(connection , Integer.parseInt(carId) , from , to)) {
                DBUtils.insertTransaction(connection , new Transaction(user.getUserId() , Integer.parseInt(carId) , from , to , request));
                alert(out , "Success");
            }
            else {
                alert(out , "You have already booked a car for the date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alert(out , "Error in Connectivity. Please try again later");
        }
	}

	private void alert(PrintWriter out , String s) {
	    out.println("<script type='text/javascript'>");
        out.println("alert('" + s + "');");
        out.println("location='/';");
        out.println("</script>");
    }
}
