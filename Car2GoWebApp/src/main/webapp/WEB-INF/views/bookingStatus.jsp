<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Status</title>
</head>
<body background="images/home1.jpg">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form commandName="customer">
		<input type="hidden" name="form" value="15"></input>
		<center>
			<h1>
				****Booking History****
			</h1>
		</center>
		<table align="center">
			<tr>
				<td>Enter Person Id</td>
				<td><input type="text" name="personId" /></td>
			</tr>
		</table>
		<br></br>
		<center>
			<input type="submit" value="View All Booking" name="submit">
		</center>
		<div align="right">
		<a href="/Controller/">Log Out</a>
	</div>
	</form:form>
	<form action="${contextPath}/pdf/pdfview" method="post" commandName="book" name="PDF">
	<input type="submit" value="View PDF Booking" name="submit">
	</form>
</body>
</html>