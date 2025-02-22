<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Reservation</title>
</head>
<body>

ReservationId: ${reservation.reservationId}<br><br>
Date: ${reservation.date}<br><br>
StartTime: ${reservation.startTime}<br><br>
EndTime: ${reservation.endTime}<br><br>
PaymentStatus: ${reservation.paymentStatus}<br><br>
AmountPaid: ${reservation.amountPaid}<br><br>
SecurityAmountPaid: ${reservation.securityAmountPaid}

</body>
</html>