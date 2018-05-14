<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Registration Form</title>
</head>
<body background="images/home1.jpg">

	<h2>Register a New User</h2>

	<form:form action="addUserForm.htm" commandName="user" method="post">

		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstname" size="30" /> <font color="red"><form:errors 
				            path="firstname" /></font></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastname" size="30" /> <font color="red"><form:errors
							path="lastname" /></font></td>
			</tr>


			<tr>
				<td>User Name:</td>
				<td><form:input path="username" size="30" /> <font color="red"><form:errors
							path="username" /></font></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30" /> <font
					color="red"><form:errors path="password" /></font></td>
			</tr>

			<tr>
				<td>Contact:</td>
				<td><form:input path="phonenumber" size="30" /> <font
					color="red"><form:errors path="phonenumber" /></font></td>
			</tr>

			<tr>
				<td>Role:</td>
				<td><form:input path="role" size="30" /> <font color="red"><form:errors
							path="role" /></font></td>
			</tr>

			<tr>
				<td>Email Id:</td>
				<td><form:input path="emailId" size="30" /> <font color="red"><form:errors
							path="emailId" /></font></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><form:input path="address" size="30" /> <font color="red"><form:errors
							path="address" /></font></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value=" Register New User" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>