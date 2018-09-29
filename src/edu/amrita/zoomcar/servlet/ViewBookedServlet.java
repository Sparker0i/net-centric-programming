package edu.amrita.zoomcar.servlet;

import edu.amrita.zoomcar.beans.Transaction;
import edu.amrita.zoomcar.beans.User;
import edu.amrita.zoomcar.utils.DBUtils;
import edu.amrita.zoomcar.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/orders"})
public class ViewBookedServlet extends HttpServlet {
    public ViewBookedServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loginedUser = MyUtils.getLoggedUser(session);

        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Connection connection = MyUtils.getStoredConnection(request);
        
        String errorString = null;
        List<Transaction> transactions = null;
        try {
            transactions = DBUtils.getTransactions(connection , loginedUser);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("transactions", transactions);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/orderView.jsp");
        dispatcher.forward(request, response);
    }
}
