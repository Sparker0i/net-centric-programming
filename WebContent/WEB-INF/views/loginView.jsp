<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>
   <jsp:include page="_top.jsp"/>
 
      <h3>Login Page</h3>
      <p style="color: red;">${errorString}</p>
 
 
      <form method="POST" action="${pageContext.request.contextPath}/login">
         <table border="0">
            <tr>
               <td>User ID</td>
               <td><input type="text" name="userName" value= "${user.getUserId()}" /> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="password" name="password" value= "${user.getPassword()}" /> </td>
            </tr>
            <tr>
               <td>Remember me</td>
               <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
            </tr>
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/register">Create an Account</a>
               </td>
            </tr>
         </table>
      </form>
 
      <jsp:include page="_footer.jsp"/>
   </body>
</html>