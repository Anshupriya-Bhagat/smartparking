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
<th>parkingId</th>
<th>minimumParkingMinutes</th>
<th>floor</th>
<th>active</th>
<th>parkingTag</th>
<th>parkingSlotId</th>
<th>suvSupported</th>

<th></th>
</tr>
<c:forEach items="${parkingslotList}" var="m">
       <tr>
       
       <td>${m.parkingId}</td>
       <td>${m.minimumParkingMinutes}</td>
       <td>${m.floor}</td>
       <td>${m.active}</td>
       <td>${m.parkingTag}</td>
       <td>${m.parkingSlotId}</td>
       <td>${m.suvSupported}</td>
        
         
   </tr>
			
		
</c:forEach>
</table>
</body>
</html>