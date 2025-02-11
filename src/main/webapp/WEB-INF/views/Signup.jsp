<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
  <h2>SignUp</h2>
  <form action="saveuser" method="post">
    FirstName:<input type="text" name="firstname"><br><br>
    LastName:<input type="text" name="lastname"><br><br>
    Email:<input type="text" name="email"><br><br>
    Password:<input type="password" name="password"><br><br>
    Contact Number:<input type="tel" name="contactno"><br><br>
    <input type="submit" value="signup">
  </form>
  <a href="login">Login</a>
</body>
</html>