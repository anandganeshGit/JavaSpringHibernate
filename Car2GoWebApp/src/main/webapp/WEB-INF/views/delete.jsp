<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Car Type</title>


<body background="images/home1.jpg">
<center>
	<h1>****Delete Car Type****</h1>
</center>
<form:form commandName="cartype">
	<input type="hidden" name="form" value="5"></input>
	<table align="center">
		<tr>
			<td>Enter Car Type Id</td>
			<td><form:input path="cartypeId" size="30" /> <font
				color="red"><form:errors path="cartypeId" /></font></td>
		</tr>
	</table>
	<br></br>
	<center>
		<input type="submit" value="delete" name="submit">
	</center>
</form:form>
</body>

</html>