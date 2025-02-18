<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListUser</title>
</head>
<body>

<table border="1">

<c:forEach items="${userList}" var="m">
       <tr>
       <td>${m.firstName}</td>
       <td>${m.lastName}</td>	
       <td>${m.email}</td>
       <td>${m.password}</td>
       <td>${m.gender}</td>
       </tr>
			
		
</c:forEach>

 </table>
     

	
</body>
</html>