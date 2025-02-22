<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Location</title>
</head>
<body>
<table border="1">
<tr>
<th>LocationName</th>
</tr>


<c:forEach items="${locationList}" var="m">
       <tr>
       <td>${m.loctionName}</td>
       <td><a href="viewlocation?locationId=${m.locationId }">View</a> |<a href="viewlocation?locationId=${m.locationId }">Delete</a> | |Edit</td>
       </tr>
			
		
</c:forEach>
</table>

</body>
</html>