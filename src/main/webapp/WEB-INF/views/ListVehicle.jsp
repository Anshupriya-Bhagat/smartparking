<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>
<th>vehicleId</th>
<th>userId</th>
<th>registrationNum</th>
<th>vehicleType</th>


</tr>
<c:forEach items="${vehicleList}" var="m">
       <tr>
       
       <td>${m.vehicleId}</td>
       <td>${m.userId}</td>
       <td>${m.registrationNum}</td>
       <td>${m.vehicleType}</td>
     
   </tr>
</c:forEach>
</table>

</body>
</html>