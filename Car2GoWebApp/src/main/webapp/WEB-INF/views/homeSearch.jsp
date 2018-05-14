<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Car type</title>
</head>
<body background="images/home1.jpg">
	<br></br>

	<center>
		<h1>****Car Type Details****</h1>
	</center>
	<div align="right">
		<a href="adminWelcome.htm"><font>Return back</font></a>
	</div>
	<form action="homeSearch.htm" name="form1" method="post">
		<table border="1" align="center">
			<tr>
				<th>Car Type ID</th>
				<th>Car Model</th>
				<th>Car Brand</th>
				<th>Transmission Type</th>
				<th>Engine Type</th>
				<th>Body Type</th>
				<th>Average Rate</th>
				
			</tr>
			<c:forEach items="${requestScope.carTypeList}" var="CarType">
				<tr>
					<td>${CarType.cartypeId}</td>
					<td>${CarType.carmodel}</td>
					<td>${CarType.carbrand}</td>
					<td>${CarType.transmissiontype}</td>
					<td>${CarType.enginetype}</td>
					<td>${CarType.bodytype}</td>
					<td>${CarType.avgrate}</td>
				</tr>
				<input type="hidden" name="cartypeId" value="${CarType.cartypeId}"></input>
			</c:forEach>
		</table>
	</form>
</body>
</html>