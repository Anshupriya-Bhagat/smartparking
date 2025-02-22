<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Parking</title>
</head>
<body>

ParkingId: ${parking.parkingId}<br><br>
Title: ${parking.title}<br><br>
Address: ${parking.address}<br><br>
TotalCapacityTwoWheeler: ${parking.totalCapacityTwoWheeler}<br><br>
TotalCapacityFourWheeler: ${parking.totalCapacityFourWheeler}<br><br>
OtherInformation: ${parking.otherInformation}<br><br>
Active: ${parking.active}<br><br>
HourlyChargeForTwoWheeler: ${parking.hourlyChargeForTwoWheeler}<br><br>
HourlyChargeForFourWheeler: ${parking.hourlyChargeForFourWheeler}<br><br>
Longitude: ${parking.longitude}<br><br>
Latitude: ${parking.latitude}<br><br>
ParkingType: ${parking.parkingType}

</body>
</html>