<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
  <h2>Login</h2>
  <form action="authenticate" method="post">
   Email:<input type="text" name="email"><br><br>
   Password:<input type="text" name="password"><br><br>
   <input type="submit" value="Login">
   <a href="forgotpassword">Forgot Password?</a>
  </form>
  ${error };
  <br>
  <a href="signup">SignUp</a>
</body>
</html>