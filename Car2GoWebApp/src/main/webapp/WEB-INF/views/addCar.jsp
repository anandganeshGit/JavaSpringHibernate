<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Car Details</title>
<script language="javascript">

function carNoValidation()
{
    var ext=document.formvalidation.carNo;
     if(ext.value=="")
     {
      document.getElementById("id1").innerHTML="Car No cant be empty";
      ext.focus();
      ext.select();
      return false;
     }
     else
     {
      document.getElementById("id1").innerHTML="";
      return carNameValidation();
     }
}
function carNameValidation()
{
    var ext=document.formvalidation.carName;
     if(ext.value=="")
     {
      document.getElementById("id2").innerHTML="carName cant be empty";
      ext.focus();
      ext.select();
      return false;
     }
     else
     {
      document.getElementById("id2").innerHTML="";
      return perhourrateValidation();
     }
}
function perhourrateValidation()
{
    var ext=document.formvalidation.perhourRate;
     if(ext.value=="")
     {
      document.getElementById("id3").innerHTML="Per Hour Rate cant be empty";
      ext.focus();
      ext.select();
      return false;
     }
     else
     {
      document.getElementById("id3").innerHTML="";
      return availbilityValidation();
     }
}
function availabilityValidation()
{
    var ext=document.formvalidation.availability;
     if(ext.value=="")
     {
      document.getElementById("id4").innerHTML="Availability cant be empty";
      ext.focus();
      ext.select();
      return false;
     }
     else
     {
      document.getElementById("id4").innerHTML="";
      return true;
     }
}
function validation1()
{
    return carNoValidation();
}
</script>
</head>
<body background="images/home1.jpg">
<form:form commandName = "car" name="formvalidation" onsubmit="return validation1();">
<input type="hidden" name="form" value="11"></input>
<center><h1>****Add Cars****</h1></center>
<table align="center" >
	
		<tr>
		<td>Car TypeId</td>
		<td><input type="text" name="carTypeId"></td>
		<td><font color="red"></font><span id="id2"></span></td>
	</tr>
	<tr>
		<td>Car Number</td>
		<td><input type="text" name="carNo" onblur="carNoValidation()"></td>
		<td><font color="red"></font><span id="id1"></span></td>
	</tr>
	<tr>
		<td>Car Name</td>
		<td><input type="text" name="carName" onblur="carNameValidation()"></td>
		<td><font color="red"></font><span id="id2"></span></td>
	</tr>
	<tr>
		<td>Per Hour Rate</td>
		<td><input type="text" name="perhourrate" onblur="perhourrateValidation()"></td>
		<td><font color="red"></font><span id="id3"></span>span></td>
	</tr>
	<tr>
		<td>Availability</td>
		<td><input type="text" name="availability" onblur="availabilityValidation()"></td>
		<td><font color="red"></font><span id="id4"></span>span></td>
	</tr>
	
	<tr>
		<td>Year Of Manufacture</td>
		<td><input type="text" name="yearofmanufacture"></td>
		<td><font color="red"></font></td>
	</tr>
	
	<tr>
		<td>Rating</td>
		<td><input type="text" name="rating"></td>
		<td><font color="red"></font></td>
	</tr>
	
	<tr>
		<td></td>
		<td><input type="submit" value="add"></input> <input type="reset" value="reset"/></td>
	</tr>
</table>
</form:form>
</body>
</html>