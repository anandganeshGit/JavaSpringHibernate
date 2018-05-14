<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Car Type</title>
</head>
<body background="images/home1.jpg">
	<br></br>

	<center>
		<h1 >****Car Type Details****</h1>
	</center>
	<div align="right">
		<a href="/Controller/"><font>Log Out</font></a>
	</div>

	<c:if test="${!empty(carTypeList)}">

		<table border="1" align="center">

			<tr>
				<th>Car Type ID</th>
				<th>Car Model</th>
				<th>Car Brand</th>
				<th>Transmission Type</th>
				<th>Engine Type</th>
				<th>Average Rate</th>
				<th>Body Type</th>
				<th></th>
			</tr>

			<c:forEach items="${requestScope.carTypeList}" var="CarType">
				<form action="searchSuccess.htm" method="post">
					<tr>
						<td>${CarType.cartypeId}</td>
						<td>${CarType.carmodel}</td>
						<td>${CarType.carbrand}</td>
						<td>${CarType.transmissiontype}</td>
						<td>${CarType.enginetype}</td>
						<td>${CarType.avgrate}</td>
						<td>${CarType.bodytype}</td>

						<td><input type="submit" value="Select Car type"></input></td>
					</tr>

					<input type="hidden" name="cartypeId"
						value="${CarType.cartypeId}"></input> <input type="hidden"
						name="form" value="8"></input>
				</form>
			</c:forEach>
		</table>

	</c:if>
	<c:if test="${empty(carTypeList)}">
		<center>
			<font color="red" size="4">No Car Types Available</font>
		</center>
	</c:if>
</body>
</html>