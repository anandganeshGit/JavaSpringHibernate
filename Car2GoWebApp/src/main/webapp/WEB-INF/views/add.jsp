<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Car Type</title>

</head>

<body background="images/home1.jpg">
	<form:form name="form1" commandName="cartype">
		<input type="hidden" name="form"></input>
		<center>
			<h1>****Add Car Types****</h1>
		</center>
		<table align="center">

			<tr>
				<td>*Car Model:</td>
				<td><form:input path="carmodel" size="30" /> <font color="red"><form:errors
							path="carmodel" /></font></td>
			</tr>

			<tr>
				<td>*Car Brand</td>
				<td><form:input path="carbrand" size="30" /> <font
					color="red"><form:errors path="carbrand" /></font></td>
			</tr>

			<tr>
				<td>*Transmission Type</td>
				<td><form:input path="transmissiontype" size="30" /> <font color="red"><form:errors
							path="transmissiontype" /></font></td>
			</tr>
			<tr>
				<td>*Engine Type</td>
				<td><form:input path="enginetype" size="30" /> <font
					color="red"><form:errors path="enginetype" /></font></td>
			</tr>
			
			<tr>
				<td>*Body Type</td>
				<td><form:input path="bodytype" size="10" /> <font
					color="red"><form:errors path="bodytype" /></font></td>

			</tr>
			
			<tr>
				<td>*Average Rate Per Hour</td>
				<td><form:input path="avgrate" size="10" /> <font
					color="red"><form:errors path="avgrate" /></font></td>
			</tr>
			
		</table>
		<center>
			<input type="submit" value="add" name="submit"></input> 
			<input type="reset" value="reset" />
		</center>

	</form:form>
</body>
</html>