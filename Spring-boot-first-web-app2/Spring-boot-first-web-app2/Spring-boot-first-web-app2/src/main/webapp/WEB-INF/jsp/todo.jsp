<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Todos</title>
<link href="webjars/bootstrap/4.1.0/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
	<div class="container">
		<div><label>Add todo description for <b>${userName}</b> here: </label></div>
		<br/>
		<form:form name="addTodoForm" method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:label path="desc">Description: </</form:label>
				<form:input path="desc" type="text" id="descId" class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning"/>
			</fieldset>
			<button type="submit" name = "submitQryBtn" id="submitQryBtnId" class="btn btn-success">Add</button>
		</form:form>
	</div>
	<script type="text/javascript" src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>