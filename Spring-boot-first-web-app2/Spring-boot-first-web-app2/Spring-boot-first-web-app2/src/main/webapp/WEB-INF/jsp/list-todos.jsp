<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
	<div><label>Here are the list of todos for ${userName}:</label></div>
	<table class="table table-striped">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td>${todo.targetDate}</td>
						<td></td>
						<td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<br/>
	<div><a class="button" href="/todo">Add a Todo</a></div>
	<!--  
		<div>
			<button type="submit" class="btn btn-success" value="Add Todo"/>
		</div>
	-->
</div>
<script type="text/javascript" src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>