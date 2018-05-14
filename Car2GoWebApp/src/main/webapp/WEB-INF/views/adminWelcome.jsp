<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin welcome</title>
</head>
<body background="images/home1.jpg">
<center>
	<h1>
		Welcome Administrator <br> <br>
		
		Admin Operations for <c:out value="${sessionScope.user.username}" /> <br> 
	</h1>

	    <a href="addCarType&Car.htm"> Add Car Type & Car</a> <br> <br> 
	    <a href="updateCarType&Car.htm"> Update Car Type & Car</a> <br> <br>
		<a href="deleteCarType&Car.htm"> Delete Car Type & Car</a> <br> <br>
		
	</center>
</body>
</body>
</html>