<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ParkingSlot</title>
</head>
<body>
     <form action="saveparkingslot" method="post">
     ParkingTag<input type="text" name="parkingTag"><br><br>
     Floor<input type="text" name="floor"><br><br>
     MinimumParkingMinutes<input type="text" name="minimumParkingMinutes"><br><br>
     SuvSupported<input type="text" name="suvSupported"><br><br>
     <input type="submit" value="saveparkingslot">
     </form>

</body>
</html>