<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Car</title>
<script type="text/javascript">
    function carIdValidation() //carId validation//
    {
        var regexp1 = /\d/g;
        var ext = document.formvalidation.carId;
        if (ext.value == "") {
            document.getElementById("id1").innerHTML = "carId cant be empty";
            ext.focus();
            ext.select();
            return false;
        } else {
            document.getElementById("id1").innerHTML = "";
            return true;
        }
    }
    function validation1()
    {
        return carIdValidation();
    }
</script>
</head>
<body background="images/home1.jpg">
	<form:form commandName="car" name="formvalidation" onsubmit="return validation();">
		<input type="hidden" name="form" value="12"></input>
		<center>
			<h1>****Delete Car****</h1>
		</center>
		<table align="center">

			<tr>
				<td>Enter Car Id</td>
				<td><input type="text" name="carId" onblur="carValidation()"/></td>
				<td><font color="red"><span id="id1"></span></font></td>
			</tr>
		</table>
		<br></br>
		<center>
			<input type="submit" value="delete">
		</center>
	</form:form>
</body>
</html>