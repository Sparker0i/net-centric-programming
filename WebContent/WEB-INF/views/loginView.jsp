<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
      <title>Login</title>
   </head>
   <body>
   <jsp:include page="_menu.jsp"/>
   <div class="container">
       <div class="col-md-4 col-md-offset-4">
           <h3>Login</h3>
           <p style="color: red;">${errorString}</p>


           <form method="POST" action="${pageContext.request.contextPath}/login">
               <table border="0">
                   <tr>
                       <td>User ID</td>
                       <td><div class="form-group col-xs-5"><input type="text" name="userName" value= "${user.getUserId()}" /></div> </td>
                   </tr>
                   <tr>
                       <td>Password</td>
                       <td><div class="form-group col-xs-5"><input type="password" name="password" value= "${user.getPassword()}" /></div> </td>
                   </tr>
                   <tr>
                       <td>Remember me</td>
                       <td><div class="form-group col-xs-5"><input type="checkbox" name="rememberMe" value= "Y" /></div> </td>
                   </tr>
                   <tr>
                       <td colspan ="2">
                           <button type="submit" class="btn btn-danger">Login</button>
                           <a href="${pageContext.request.contextPath}/register" class="btn btn-primary">Create an Account</a>
                       </td>
                   </tr>
               </table>
           </form>
       </div>
   </div>
   <jsp:include page="_footer.jsp"/>
   </body>
</html>