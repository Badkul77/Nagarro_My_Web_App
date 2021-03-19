<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Age Calculator</title>
</head>
<body>
 <h1 style="text-align:center">Age Calculator</h1>
  <p style="text-align:center">Your Age will  rendered here :</p><br>

<p style="text-align:center">Your Current age is :<%= request.getAttribute("result") %></p>
</body>
</html>