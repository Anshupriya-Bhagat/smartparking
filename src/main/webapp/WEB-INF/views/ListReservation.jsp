<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Reservation</title>
</head>
<body>
<table border="1">
<tr>
<th>reservationId</th>
<th>date</th>
<th>startTime</th>
<th>endTime</th>
<th>paymentStatus</th>
<th>amountPaid</th>
<th>securityAmountPaid</th>
<th>Action</th>

</tr>
<c:forEach items="${reservationList}" var="m">
       <tr>
       
       <td>${m.reservationId}</td>
       <td>${m.date}</td>
       <td>${m.startTime}</td>
        <td>${m.endTime}</td>
        <td>${m.paymentStatus}</td>
        <td>${m.amountPaid}</td>
        <td>${m.securityAmountPaid}</td>
        <td><a href="viewreservation?reservationId=${m.reservationId }">View</a>|<a href="deletereservation?reservationId=${m.reservationId }">Delete</a>|<a>Edit</a></td>
   </tr>
</c:forEach>
</table>
</body>
</html>