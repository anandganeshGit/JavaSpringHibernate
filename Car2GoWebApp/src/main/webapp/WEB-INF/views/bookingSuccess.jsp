<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Success</title>
</head>
<body background="images/home1.jpg">
	
	<center>
	<h1>Booking Successful</h1>
	</center>
	<table align="center">
		<tr>
			<td><font>Booking Id:</font></td>
			<td><font>${sessionScope.bookingDetails.bookingId }</font></td>
		</tr>
		<tr>
			<td><font>Car Id:</font></td>
			<td><font>${sessionScope.bookingDetails.carId }</font></td>
		</tr>
		<tr>
			<td><font>Person Id:</font></td>
			<td><font>${sessionScope.bookingDetails.user}</font></td>
		</tr>
		<tr>
			<td><font>Booked From:</font></td>
			<td><font>${sessionScope.bookingDetails.bookedFrom }</font></td>
		</tr>
		<tr>
			<td><font>Booked Till:</font></td>
			<td><font>${sessionScope.bookingDetails.bookedTill}</font></td>
		</tr>
	</table>

</body>
</html>