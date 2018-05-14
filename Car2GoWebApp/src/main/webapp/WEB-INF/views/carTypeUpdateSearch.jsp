<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!--<%@ include file="update.jsp" %>
    -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Car Type</title>
</head>
<body background="images/home1.jpg">
	<form action="carTypeUpdateSearch.htm" method="post">
		<input type="hidden" name="form" value="6"></input>
		<center>
			<h1>****Update Car Type Details****
			</h1>
		</center>
		<c:if test="${sessionScope.cartype !=null}">
			<table align="center" border="1">
				<tr>
					<th>Car Type Id</th>
					<th>Car Model</th>
					<th>Car Brand</th>
					<th>Transmission Type</th>
					<th>Engine Type</th>
					<th>Body Type</th>
					<th>Average Rate</th>
				</tr>
				<tr>
					<td><input type="text" value="${sessionScope.cartype.cartypeId}"
						name="cartypeId"></input></td>
					<td><input type="text" value="${sessionScope.cartype.carmodel}"
						name="carmodel"></input></td>
					<td><input type="text" value="${sessionScope.cartype.carbrand}"
						name="carbrand"></input></td>
					<td><input type="text" value="${sessionScope.cartype.transmissiontype}"
						name="transmissiontype"></input></td>
					<td><input type="text" value="${sessionScope.cartype.enginetype}" 
					    name="enginetype"></input></td>
					<td><input type="text" value="${sessionScope.cartype.bodytype}"
						name="bodytype"></input></td>
					<td><input type="text" value="${sessionScope.cartype.avgrate}"
						name="avgrate"></input></td>
					
				</tr>
			</table>
			<br>
			<center>
				<input type="submit" value="update" name="submit"></input>
			</center>
		</c:if>

		<c:if test="${sessionScope.carType== null}">
			<center>
				<font color="red" size="4">Car Type Id Does Not Exist</font>
			</center>
		</c:if>

	</form>
</body>
</html>