<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parking</title>
</head>
<body>
     <form action="saveparking" method="post">
     Title<input type="text" name="title"><br><br>
     Address<input type="text" name="address"><br><br>
     TotalcapacitytwoWheeler<input type="text" name="totalCapacityTwoWheeler"><br><br>
     TotalcapacityfourWheeler<input type="text" name="totalCapacityFourWheeler"><br><br>
     OtherInformation<input type="text" name="otherInformation"><br><br>
     Latitude<input type="text" name="latitude"><br><br>
     Longitude<input type="text" name="longitude"><br><br>
     ParkingType<input type="text" name="parkingType"><br><br>
     
     User: <select name="userId">
			<option>Select User</option>
			
			<c:forEach items="${allusers}" var="s">

					<option value="${s.userId}">${s.firstName }</option>
			
			</c:forEach>

     
     <input type="submit" value="saveparking">
     
     </form>
</body>
</html>