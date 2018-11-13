package edu.amrita.zoomcar.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

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

@WebServlet(urlPatterns = {"/carList"})
public class CarListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CarListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loginedUser = MyUtils.getLoggedUser(session);

        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Connection conn = MyUtils.getStoredConnection(request);

        String errorString = null;
        List<Car> list = null;
        try {
            list = DBUtils.getCars(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);

        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/carListView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Float minPrice , maxPrice;
        try {
            minPrice = Float.parseFloat(request.getParameter("minPrice"));
        }
        catch (Exception ex) {
            minPrice = null;
        }

        try {
            maxPrice = Float.parseFloat(request.getParameter("maxPrice"));
        }
        catch (Exception ex) {
            maxPrice = null;
        }

        String company = request.getParameter("company");
        System.out.println(minPrice + " " + maxPrice + " " + company);

        Connection conn = MyUtils.getStoredConnection(request);

        String errorString = null;
        List<Car> list = null;
        try {
            list = DBUtils.getCars(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (minPrice != null && maxPrice != null) {
            if (maxPrice < minPrice) {
                errorString = "";
                dispatch(request , response , errorString , list);
            }
        }

        if (list != null) {
            System.out.println(list.size());

            Iterator<Car> iter = list.iterator();
            while (iter.hasNext()) {
                Car car = iter.next();

                if (minPrice != null) {
                    //System.out.println("Min is not null");
                    if (car.getCostPerDay() < minPrice) {
                        iter.remove();
                        continue;
                    }
                }
                if (maxPrice != null) {
                    //System.out.println("Max is not null");
                    if (car.getCostPerDay() > maxPrice) {
                        iter.remove();
                    }
                }
                if (company != null) {
                    if (!car.getCompany().equalsIgnoreCase(company))
                        iter.remove();
                }
            }
            System.out.println(list.size());
        }

        dispatch(request , response , errorString , list);
    }

    private void dispatch(HttpServletRequest request , HttpServletResponse response , String errorString , List<Car> list) throws ServletException, IOException {
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/carListView.jsp");
        dispatcher.forward(request, response);
    }
}