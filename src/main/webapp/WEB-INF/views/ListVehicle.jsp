<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Vehicle</title>
</head>
<body>

<table border="1">
<tr>
<th>vehicleId</th>
<th>registrationNum</th>
<th>vehicleType</th>
<th>Action</th>


</tr>
<c:forEach items="${vehicleList}" var="m">
       <tr>
       
       <td>${m.vehicleId}</td>
       <td>${m.registrationNum}</td>
       <td>${m.vehicleType}</td>
     <td><a href="viewvehicle?vehicleId=${m.vehicleId }">View</a>|<a href="deletevehicle?vehicleId=${m.vehicleId }">Delete</a>|<a>Edit</a></td>
   </tr>
</c:forEach>
</table>

</body>
</html>