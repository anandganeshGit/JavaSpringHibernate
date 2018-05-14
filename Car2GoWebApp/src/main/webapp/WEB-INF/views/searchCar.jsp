<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Search</title>
</head>
<body background="images/home1.jpg">
	<br></br>

	<center>
		<h1>****Car Details****
		</h1>
	</center>
	<div align="right">
		<a href=""><font>Log Out</font></a>
	</div>

	<table border="1" align="center">
		<tr>
			<th>Car Type ID</th>
			<th>Car Id</th>
			<th>Car Number</th>
			<th>Car Name</th>
			<th>Average rate Per Hour</th>
			<th></th>
		</tr>
		<c:forEach items="${requestScope.carList}" var="Car">
			<tr>
				<td>${Car.cartypeId}</td>
				<td>${Car.carId}</td>
				<td>${Car.carNo}</td>
				<td>${Car.carName}</td>
				<td>${Car.perhourrate}</td>
				<td><form action="searchCar.htm" name="form1" method="post">
						<input type="submit" value="Select Car"><input
							type="hidden" name="carId" value="${Car.carId}"></input> <input
							type="hidden" name="form" value="9"></input>
					</form></td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>