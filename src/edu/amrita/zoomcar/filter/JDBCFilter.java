package edu.amrita.zoomcar.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import edu.amrita.zoomcar.database.DatabaseConnection;
import edu.amrita.zoomcar.utils.MyUtils;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebFilter(filterName = "jdbcFilter", urlPatterns = {"/*"})
public class JDBCFilter implements Filter{
	
	public JDBCFilter() {
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	private boolean needJDBC(HttpServletRequest request) {
        System.out.println("JDBC Filter");
        
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
 
        String urlPattern = servletPath;
 
        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
        }
 
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();
 
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }
	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		 
        // Only open connections for the special requests.
        // (For example, the path to the servlet, JSP, ..)
        // 
        // Avoid open connection for commons request.
        // (For example: image, css, javascript,... )
        // 
        if (this.needJDBC(req)) {
 
            System.out.println("Open Connection for: " + req.getServletPath());
 
            Connection conn = null;
            try {
                // Create a Connection.
                conn = DatabaseConnection.getConnection(req.getServletContext());
                conn.setAutoCommit(false);

                MyUtils.storeConnection(request, conn);
                chain.doFilter(request, response);
 
                // Invoke the commit() method to complete the transaction with the DB.
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                DatabaseConnection.rollback();
                throw new ServletException();
            } finally {
                DatabaseConnection.disconnect();
            }
        }
        else {
            chain.doFilter(request, response);
        }
	}
	
}
