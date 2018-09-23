package edu.amrita.zoomcar.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.amrita.zoomcar.beans.User;

public class MyUtils {
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    private static final String ATT_NAME_USER_ID = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
    public static final String LOGGED_IN = "loggedInUser";

    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
    
    public static Connection getStoredConnection(ServletRequest request) {
    	return ((Connection) request.getAttribute(ATT_NAME_CONNECTION));
    }
    
    public static void storeLoggedInUser(HttpSession session , User user) {
    	session.setAttribute(MyUtils.LOGGED_IN , user);
    }
    
    public static User getLoginedUser(HttpSession session) {
        return (User) session.getAttribute(MyUtils.LOGGED_IN);
    }
    
    public static void storeUserCookie(HttpServletResponse response, User user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_ID, user.getUserId());
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }
    
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_ID.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_ID, null);
        // 0 seconds (This cookie will expire immediately)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
}
