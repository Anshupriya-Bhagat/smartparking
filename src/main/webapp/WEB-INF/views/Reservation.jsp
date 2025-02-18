<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
     <input type="submit" name="saverreservation">
     </form>

</body>
</html>