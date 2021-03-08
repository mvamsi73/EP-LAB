<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<script type="text/javascript">
function validate()
{
   var name=document.f1.name.value;
   var email=document.f1.email.value;
   var phnum=document.f1.phnum.value;
   var pass=document.f1.pass.value;
   if(name=="")
	   {
	   alert("Name field should not be empty");
	   document.f1.name.focus();
	   return false;
	   }
   else if(email=="")
	   {
	   alert("Email Field Should not be Empty");
	   document.f1.email.focus();
	   return false;
	   }
   else if(phnum=="")
	   {
	   alert("Phone Number Field should not be empty");
	   document.f1.phnum.focus();
	   return false;
	   }
   else if(pass=="")
	   {
	   alert("Password Should not be Empty");
	   document.f1.pass.focus();
	   return false;
	   }
   if(pass.length<8)
	{
	alert("Password Should be 8 characters long");
	document.f1.pass.focus();
	return false;
	}
}
</script>
</head>
<body>
<form name="f1" action="register.jsp" method="post" onsubmit="return validate()">
<table align="center">
<h1 align="center">Registration Form</h1>
<tr><td>Enter Your Name</td><td><input type="text" name="name"></td></tr>
<tr><td>Enter Your Email</td><td><input type="text" name="email"></td></tr>
<tr><td>Enter Your Phone Number</td><td><input type="text" name="phnum"></td></tr>
<tr><td>Enter Your Password</td><td><input type="password" name="pass"></td></tr>
<tr><td><input type="submit"></td></tr>
</table>
</form>
</body>
</html>