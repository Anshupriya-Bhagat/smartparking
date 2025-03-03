<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle</title>
</head>
<body>
      <form action="savevehicle" method="post">
      Registration Number<input type=text name="registrationNum"><br><br>
      Vehicle Type<input type=text name="vehicleType"><br><br>
      
      User: <select name="userId">
			<option>Select User</option>
			
			<c:forEach items="${allusers}" var="s">

					<option value="${s.userId}">${s.firstName }</option>
			
			</c:forEach>

		</select> <br><br>
      
      <input type="submit" value="savevehicle">
      </form>
</body>
</html>