<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>carUpdate</title>
</head>
<body background="images/home1.jpg">
	<form action="HBMSController" method="post">
		<input type="hidden" name="form" value="13"></input>
		<center>
			<h1>****Update Car Details****</h1>
		</center>
		<c:if test="${sessionScope.car.carId!=null}">
			<table align="center" border="1" style="color: white">
				<tr>
					<th>Car Id</th>
					<th>Car Type Id</th>
					<th>Car No</th>
					<th>Car Name</th>
					<th>Per Hour Rate</th>
					<th>Availability</th>
				</tr>
				<tr>
					<td>${sessionScope.car.carId}</td>
					<td>${sessionScope.car.cartypeId}</td>
					<td>${sessionScope.car.carNo}</td>
					<td>${sessionScope.car.carName}</td>
					<td><input type="text"
						value="${sessionScope.car.perhourrate}" name="perhourrate"></input></td>
					<td><input type="text"
						value="${sessionScope.car.availability}" name="availability"></input></td>
				</tr>
			</table>
			<br>
			<center>
				<input type="submit" value="update" name="submit"></input>
			</center>
		</c:if>
		<c:if test="${sessionScope.car.carId==null}">
			<center>
				<font color="red" size="4">Car Id Does Not Exist</font>
			</center>
		</c:if>



	</form>
</body>
</html>