<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List ParkingSlot</title>
</head>
<body>
<table border="1">
<tr>
<th>parkingSlotId</th>
<th>minimumParkingMinutes</th>
<th>floor</th>
<th>active</th>
<th>parkingTag</th>
<th>parkingId</th>
<th>suvSupported</th>
<th>Action</th>

<th></th>
</tr>
<c:forEach items="${parkingslotList}" var="m">
       <tr>
       
       <td>${m.parkingSlotId}</td>
       <td>${m.minimumParkingMinutes}</td>
       <td>${m.floor}</td>
       <td>${m.active}</td>
       <td>${m.parkingTag}</td>
       <td>${m.parkingId}</td>
       <td>${m.suvSupported}</td>
       <td><a href="viewparkingslot?parkingSlotId=${m.parkingSlotId }">View</a>|<a href="deleteparkingslot?parkingSlotId=${m.parkingSlotId }">Delete</a>|<a>Edit</a></td>
        
         
   </tr>
			
		
</c:forEach>
</table>
</body>
</html>