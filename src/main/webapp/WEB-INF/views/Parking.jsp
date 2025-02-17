<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parking</title>
</head>
<body>
     <form action="saveparking" method="post">
     Title<input type="text" name="title">
     Address<input type="text" name="address">
     TotalcapacitytwoWheeler<input type="text" name="totalCapacityTwoWheeler">
     TotalcapacityfourWheeler<input type="text" name="totalCapacityFourWheeler">
     OtherInformation<input type="text" name="otherInformation">
     HourlychargefortwoWheeler<input type="text" name=" hourlyChargeForTwoWheeler">
     HourlychargeforfourWheeler<input type="text" name="hourlyChargeForFourWheeler">
     ParkingType<input type="text" name="parkingType">
     <input type="submit" value="saveparking">
     
     </form>
</body>
</html>