<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Booking</title>
</head>
<body background="images/home1.jpg">
	<form:form commandName="cancelBooking">
		<input type="hidden" name="form" value="15"></input>
		<center>
			<h1>****Cancel Booking****
			</h1>
		</center>
		<table align="center">
			<tr>
				<td>Enter Booking Id</td>
				<td><input type="text" name="bookingId" /></td>
			</tr>
		</table>
		<br></br>
		<center>
			<input type="submit" value="Cancel Booking" name="submit">
		</center>
	</form:form>
</body>
</html>