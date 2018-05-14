<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserLinks</title>

</head>
<body background="images/home1.jpg">
	<div>
		<h1>Welcome ${user.username}</h1>
		<h2>
				<a href="/Controller/"><font>Log Out</font></a>
		</h2>
	</div>
	<br></br>
	<br></br>
	<center>
		<h2>
			<a href="searchSuccess.htm">Book a Car</a> <br></br>
			<br></br> <a href="bookingStatus.htm">View Status</a>
		</h2>
	</center>
</body>
</html>