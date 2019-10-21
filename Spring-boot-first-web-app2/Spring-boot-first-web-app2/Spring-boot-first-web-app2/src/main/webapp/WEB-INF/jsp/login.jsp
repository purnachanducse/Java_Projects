<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<font color="red">${errorMessage}</font>
	<form method="post">
		User Name:<input type="text" name="userName" value=""/>
		Password:<input type="password" name="password" value=""/>
		<input type="submit" value="Submit Query"/>
	</form>
</body>
</html>