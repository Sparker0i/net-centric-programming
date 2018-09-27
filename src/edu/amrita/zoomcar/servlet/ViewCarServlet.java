package edu.amrita.zoomcar.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.amrita.zoomcar.beans.Car;
import edu.amrita.zoomcar.beans.User;
import edu.amrita.zoomcar.utils.DBUtils;
import edu.amrita.zoomcar.utils.MyUtils;

@WebServlet(urlPatterns = {"/viewCar"})
public class ViewCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCarServlet() {
		super();
	}

	String carId;

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
		Car car = null;
		String errorString = null;

		try {
			car = DBUtils.getCar(connection, Integer.parseInt(carId));
		}
		catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		if (errorString != null && car == null) {
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

	    String from = req.getParameter("fromDate");
		String to = req.getParameter("toDate");
		System.out.println(from + " " + to);

        resp.sendRedirect(req.getContextPath() + "/viewCar?CAR_ID=" + carId);
	}


}
