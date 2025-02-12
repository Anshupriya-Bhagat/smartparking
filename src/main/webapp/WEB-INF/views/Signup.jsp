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
    FirstName:<input type="text" name="firstName"><br><br>
    LastName:<input type="text" name="lastName"><br><br>
    Email:<input type="text" name="email"><br><br>
    Gender:Male<input type="radio"  name="gender" value="male">
           Female<input type="radio" name="gender" value="female"><br><br>
    Password:<input type="password" name="password"><br><br>
    Contact Number:<input type="tel" name="contactnum"><br><br>
    <input type="submit" value="signup">
  </form>
  <a href="login">Login</a>
</body>
</html>