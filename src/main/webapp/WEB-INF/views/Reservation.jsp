<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation</title>
</head>
<body>
     <form action="savereservation" method="post">
     Date<input type="date" name="date"><br><br>
     StartTime<input type="datetime-local" name="startTime"><br><br>
     EndTime<input type="datetime-local" name="endTime"><br><br>
     AmountPaid<input type="text" name="amountPaid"><br><br>
     SecurityAmountPaid<input type="text" name="securityAmountPaid"><br><br>
     
      User: <select name="userId">
			<option>Select User</option>
			
			<c:forEach items="${allusers}" var="s">

					<option value="${s.userId}">${s.firstName }</option>
			
			</c:forEach>

		</select> <br><br>
		
		
		 <select name="parkingSlotId">
			<option>Select Floor</option>
			
			<c:forEach items="${allparkingslot}" var="s">

					<option value="${s.parkingSlotId}">${s.floor }</option>
			
			</c:forEach>

		</select> <br><br>
		
		
		<select name="vehicleId">
			<option>Select RegistrationNum</option>
			
			<c:forEach items="${allvehicles}" var="s">

					<option value="${s.vehicleId}">${s.registrationNum }</option>
			
			</c:forEach>

		</select> <br><br>
		
		<select name="parkingId">
			<option>Select Title</option>
			
			<c:forEach items="${allparkings}" var="s">

					<option value="${s.parkingId}">${s.title }</option>
			
			</c:forEach>

		</select> <br><br>
		
		
		
		
     
     <input type="submit" name="saverreservation">
     </form>

</body>
</html>