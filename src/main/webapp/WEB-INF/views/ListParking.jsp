<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Parking</title>
</head>
<body>
<table border="1">
<tr>
<th>parkingId</th>
<th>title</th>
<th>address</th>
<th>totalCapacityTwoWheeler</th>
<th>totalCapacityFourWheeler</th>
<th>otherInformation</th>
<th>active</th>
<th>hourlyChargeForTwoWheeler</th>
<th>hourlyChargeForFourWheeler</th>
<th>longitude</th>
<th>latitude</th>
<th>parkingType</th>
<th>Action</th>
</tr>
<c:forEach items="${parkingList}" var="m">
       <tr>
       
       <td>${m.parkingId}</td>
       <td>${m.title}</td>
       <td>${m.address}</td>
        <td>${m.totalCapacityTwoWheeler}</td>
         <td>${m.totalCapacityFourWheeler}</td>
         <td>${m.otherInformation}</td>
         <td>${m.active}</td>
         <td>${m.hourlyChargeForTwoWheeler}</td>
         <td>${m.hourlyChargeForFourWheeler}</td>
         <td>${m.longitude}</td>
         <td>${m.latitude}</td>
         <td>${m.parkingType}</td>
         <td><a href="viewparking?parkingId=${m.parkingId }">View</a>| <a href="deleteparking?parkingId=${m.parkingId }">Delete</a>|<a>Edit</a></td>
        
         
   </tr>
			
		
</c:forEach>
</table>


</body>
</html>