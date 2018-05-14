<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Bookings</title>
</head>
<body background="images/home1.jpg">
	<br></br>

	<center>
		<h1 >****Bookings****</h1>
	</center>
	<div align="right">
		<a href=""><font color="black">Log Out</font></a>
	</div>

	<table border="1" align="center">
		<tr>
			<th>BOOKING_ID</th>
			<th>Car Id</th>
			<th>Person Id</th>
			<th>Booked From</th>
			<th>Booked Till</th>


		</tr>
		<c:forEach items="${requestScope.bookingList}" var="book">
			<tr>
				<td>${book.bookingId}</td>
				<td>${book.carId}</td>
				<td>${book.user}</td>
				<td>${book.bookedFrom}</td>
				<td>${book.bookedTill}</td>


				<td><form action="allBookings.htm" name="form1" method="post">
						<input type="hidden" name="bookingId" value="${book.bookingId}"></input>
						<input type="hidden" name="form" value="15"></input>
					</form></td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>